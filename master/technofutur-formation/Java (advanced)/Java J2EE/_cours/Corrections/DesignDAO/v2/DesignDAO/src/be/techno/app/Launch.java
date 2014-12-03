package be.techno.app;

import java.sql.SQLException;
import java.util.List;

import be.techno.app.domain.Student;
import be.techno.app.domain.dao.DAO;
import be.techno.app.domain.dao.jdbc.impl.StudentDAO;

public class Launch {

	public static void main(String[] args) {
		/*try {
			Connection c = ConnectionJDBC.getConnection();
			if(c!=null)
				System.out.println("ok : " + c);
			else
				System.out.println("Conn down");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}*/
		
		StudentDAO myDAO = StudentDAO.getInstance();
		
		try {
			Student student1 = new Student("Carine", 18);
			System.out.println("before insert : " + student1);
			myDAO.create(student1);
			System.out.println("after insert : " + student1);
			
			student1.setName("Karine");
			System.out.println("before update : " + student1);
			student1 = myDAO.update(student1);
			
			System.out.println("after update : " + student1);
			
			Student s = myDAO.read(1);
			System.out.println("searched(3) : " + s);
			
			myDAO.delete(s);
			Student s2 = myDAO.read(1);
			System.out.println("searched(3) after delete : " + s2);
			
			List<Student> list = myDAO.findAll();
			for(Student st : list) {
				System.out.println(st);
			}
			
			System.out.println(myDAO.findByName("John"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
