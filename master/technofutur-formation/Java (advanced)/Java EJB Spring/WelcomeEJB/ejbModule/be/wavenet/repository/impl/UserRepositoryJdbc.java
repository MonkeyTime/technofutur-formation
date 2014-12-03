package be.wavenet.repository.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;

import be.wavenet.domain.User;
import be.wavenet.repository.RepositoryException;
import be.wavenet.repository.UserRepository;

@Stateless(name="UserRepositoryJdbc")
public class UserRepositoryJdbc implements UserRepository {
	
	@Resource(mappedName="java:/welcomeDS")
	private DataSource dataSource;

	@Override
	public boolean addUser(User u) throws RepositoryException {
		Connection conn = null;
		Statement stmt = null;
		
		try {
			conn = dataSource.getConnection();
			stmt = conn.createStatement();
			
			int n = stmt.executeUpdate("INSERT INTO USERS" +
										" (LOGIN,PASSWORD,FIRSTNAME,LASTNAME)" +
										" VALUES ('" + u.getLogin() + "','" + u.getPassword() + "','" + 
													u.getFirstName() + "','" + u.getLastName() + "')");
			
			return n == 1;
		} catch (SQLException e) {
			throw new RepositoryException(e);
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					System.err.println(e);
				}
			}
			
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					System.err.println(e);
				}
			}		
		}
	}

	@Override
	public boolean deleteUser(User u) throws RepositoryException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User findUser(String login) throws RepositoryException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = dataSource.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM USERS WHERE LOGIN = '" + login + "'");
			
			if (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("ID"));
				user.setFirstName(rs.getString("FIRSTNAME"));
				user.setLastName(rs.getString("LASTNAME"));
				user.setLogin(rs.getString("LOGIN"));
				user.setPassword(rs.getString("PASSWORD"));
				
				return user;
			}
			
			return null;
		} catch (SQLException e) {
			throw new RepositoryException(e);
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					System.err.println(e);
				}
			}
			
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					System.err.println(e);
				}
			}
			
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					System.err.println(e);
				}
			}		
		}
	}

	@Override
	public User findUser(int id) throws RepositoryException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override 
	public boolean updateUser(User u) throws RepositoryException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<User> findUsers() throws RepositoryException {
		// TODO Auto-generated method stub
		return null;
	}

}
