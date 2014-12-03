package be.wavenet.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		final String query = request.getParameter("query");
		if (query == null || query.trim().length() == 0) {
			ServletHelper.redirectErrors(request, response, new Exception(
					"Missing Query"), "query.html");
			return;
		}

		final HttpSession clientSession = request.getSession();
		if (clientSession == null) {
			ServletHelper.redirectErrors(request, response, new Exception(
					"Invalid Session"), "index.html");
			return;
		}

		final Object attribute = clientSession.getAttribute("connection");
		if (attribute instanceof Connection == false) {
			ServletHelper.redirectErrors(request, response, new Exception(
					"Missing Connection"), "index.html");
			return;
		}

		final Connection connection = (Connection) attribute;
		Statement stmt = null;

		try {
			stmt = connection.createStatement();

			boolean isResultSet = stmt.execute(query);
			if (isResultSet) {
				request.setAttribute("result", resultSetToArray(stmt
						.getResultSet()));
			} else {
				request.setAttribute("result", stmt.getUpdateCount());
			}
			request.getRequestDispatcher("result.jsp").forward(request,
					response);
		} catch (SQLException e) {
			ServletHelper.redirectErrors(request, response, e, "query.html");
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException ie) {
			}
		}
	}

	@SuppressWarnings("unchecked")
	private List resultSetToArray(ResultSet resultSet) throws SQLException {
		ResultSetMetaData metadata = resultSet.getMetaData();
		int columns = metadata.getColumnCount();

		List rows = new ArrayList();

		// headers
		List row = new ArrayList();
		rows.add(row);
		for (int i = 1; i <= columns; i++) {
			row.add(metadata.getColumnLabel(i));
		}

		// rows
		while (resultSet.next()) {
			row = new ArrayList();
			rows.add(row);

			for (int i = 1; i <= columns; i++) {
				row.add(resultSet.getObject(i));
			}
		}

		return rows;
	}
}
