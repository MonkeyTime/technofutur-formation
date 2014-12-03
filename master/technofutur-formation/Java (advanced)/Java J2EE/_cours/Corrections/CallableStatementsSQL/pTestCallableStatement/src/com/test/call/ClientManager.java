package com.test.call;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class ClientManager {

	private static Connection connection;
	
	public static Connection getConnection() throws SQLException {
		if(connection==null || connection.isClosed()) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3316/test", "root", "admin");
		}
		return connection;
	}
	
	public static void closeConnection() throws SQLException {
		connection.close();
	}
	
	public static Client create(Client c) throws SQLException {
		String query = "{call insert_client(?,?)}";
		
		try(CallableStatement cs = getConnection().prepareCall(query)) {
			int i=1;
			cs.setString(i++, c.getFirstName());
			cs.setString(i++, c.getLastName());
			try {
				if(cs.execute()) {
					try(ResultSet rs = cs.getResultSet()) {
						rs.next();
						c.setId(rs.getInt("client_id"));
					}
				}
			}
			catch(SQLException e) {
				if(e.getMessage().contains("Duplicate entry"))
					return null;
			}
		}
		return c;
	}
	
	public static Client read(int id) throws SQLException {
		String query = "{call search_client_by_id(?)}";
		Client c = null;
		try(CallableStatement cs = getConnection().prepareCall(query)) {
			cs.setInt(1, id);
			if(cs.execute()) {
				try(ResultSet rs = cs.getResultSet()) {
					rs.next();
					c = new Client();
					c.setId(rs.getInt("client_id"));
					c.setFirstName(rs.getString("first_name"));
					c.setLastName(rs.getString("last_name"));
				}
			}
		}
		return c;
	}
	
	public static void delete(Client c) throws SQLException {
		String query = "{call delete_client_by_name(?,?)}";
		
		try(CallableStatement cs = getConnection().prepareCall(query)) {
			int i=1;
			cs.setString(i++, c.getFirstName());
			cs.setString(i++, c.getLastName());
			cs.execute();
		}
	}
	
	public static Client update(Client c) throws SQLException {
		String query = "{call update_client_by_id(?,?,?)}";
		
		try(CallableStatement cs = getConnection().prepareCall(query)) {
			int i = 1;
			cs.setInt(i++, c.getId());
			cs.setString(i++, c.getFirstName());
			cs.setString(i++, c.getLastName());
			cs.execute();
		}
		return c;
	}
	
	public static void main(String[] args) {
		Client c = new Client();
		c.setFirstName("Albert");
		c.setLastName("II");
		try {
			
			c = create(c);
			
			System.out.println(c + " added");
			
			Client c2 = read(4);
			System.out.println(c2 + " found");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//		
//		Connection conn = null;
//		try {
//			conn = DriverManager.getConnection("jdbc:mysql://localhost:3316/test", "root", "admin");
//			System.out.println("Connection ok");
//			
//			CallableStatement cs = conn.prepareCall("{call new_procedure(?,?)}");
//			cs.registerOutParameter(2, Types.INTEGER);
//			cs.setInt(1, 5);
//			
//			boolean exec = cs.execute();
//			if(exec) {
//				System.out.println("There is a resultset");
//				
//				ResultSet rs = cs.getResultSet();
//			}
//			else
//				System.out.println("Proc no resultset");
//			
//			System.out.println("out : " + cs.getInt(2));
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		finally {
//			try {
//				if(conn!=null)
//					conn.close();
//			} catch (SQLException e) {}
//		}
		
	}

}
