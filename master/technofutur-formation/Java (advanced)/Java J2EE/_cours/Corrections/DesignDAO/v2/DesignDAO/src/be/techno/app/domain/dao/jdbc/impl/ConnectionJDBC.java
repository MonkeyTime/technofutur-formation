package be.techno.app.domain.dao.jdbc.impl;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionJDBC {

	private static Connection connection;
	private static String DRIVER = "com.mysql.jdbc.Driver";
	/*private static String DB_URL = "jdbc:mysql://localhost:3316/training";
	private static String DB_USER = "root";
	private static String DB_PWD = "admin";*/
	
	private ConnectionJDBC() { }
	
	public static Connection getConnection() throws SQLException {
		/* Logic d'ouverture de connection */
		if(connection==null || connection.isClosed()) {
			
			try {
				Class.forName(DRIVER).newInstance();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				return null;
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		
			Properties prop = new Properties();
			InputStream is = ClassLoader.getSystemResourceAsStream("db.properties");
			
			String url = null;
			String user = null;
			String pwd = null;
			try {
				prop.load(is);
				url = prop.getProperty("jdbc.db_url");
				user = prop.getProperty("jdbc.db_user");
				pwd = prop.getProperty("jdbc.db_password");
				
				System.out.println("url:'" + url + "'");
				
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
			if(url==null || user==null || pwd==null)
				return null;
			
			connection = DriverManager.getConnection(url, user, pwd);
		}
		return connection;
	}
	
}
