package be.techno.app;

import java.sql.Connection;
import java.sql.SQLException;

import be.techno.app.domain.Student;
import be.techno.app.domain.dao.DAO;
import be.techno.app.domain.dao.jdbc.impl.ConnectionJDBC;
import be.techno.app.domain.dao.jdbc.impl.StudentDAO;

public class Launch {

	public static void main(String[] args) {
		try {
			Connection c = ConnectionJDBC.getConnection();
			if(c!=null)
				System.out.println("ok : " + c);
			else
				System.out.println("Conn down");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	DAO<Student,Integer> myDAO = StudentDAO.getInstance();
	Student student1 = new Student("john",25);
	

}
