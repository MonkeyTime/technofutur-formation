package be.techno.web.interpreter.controller.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.techno.web.interpreter.controller.wrapper.ConnectionWrapper;

/**
 * Servlet implementation class RequestServlet
 */
@WebServlet("/doRequest")
public class RequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final String query = request.getParameter("query");
		
		if (query == null || query.trim().length() == 0) {
			ServletHelper.errorForwarding(request, response, new Exception(
					"Missing Query"), "query.html");
			return;
		}
		
		Object attribute = request.getSession().getAttribute("user.db.connection");
		if (attribute instanceof ConnectionWrapper == false) {
			ServletHelper.errorForwarding(request, response, new Exception(
					"Missing Connection"), "index.html");
			return;
		}
		
		final Connection connection = ((ConnectionWrapper) attribute).conn();
		Statement stmt = null;
		
		try {
			stmt = connection.createStatement();

			boolean isResultSet = stmt.execute(query);
			if (isResultSet) {
				@SuppressWarnings("rawtypes")
				List results = resultSetToArray(stmt.getResultSet());
				
				request.setAttribute("resultStore", results);
				if(results.size()>0)
					request.setAttribute("result", results.size()-1);
				else
					request.setAttribute("result", results.size());
			} else {
				request.setAttribute("result", stmt.getUpdateCount());
			}
			request.getRequestDispatcher("WEB-INF/jsp/result.jsp").forward(request, response);
			
		} catch (SQLException e) {
			ServletHelper.errorForwarding(request, response, e, "query.html");
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException ie) {}
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private List resultSetToArray(ResultSet resultSet) throws SQLException {
		ResultSetMetaData metadata = resultSet.getMetaData();
		int columns = metadata.getColumnCount();
		List rows = new ArrayList();

		// populate headers
		List row = new ArrayList();
		rows.add(row);
		
		for (int i = 1; i <= columns; i++) {
			row.add(metadata.getColumnLabel(i));
		}

		// populate each rows
		while (resultSet.next()) {
			row = new ArrayList();
			rows.add(row);

			for (int i = 1; i <= columns; i++) {
				row.add(resultSet.getObject(i));
			}
		}

		return rows;
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
