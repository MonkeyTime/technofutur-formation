package be.techno.app.domain.dao.jdbc.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import be.techno.app.domain.Student;
import be.techno.app.domain.dao.DAO;
import be.techno.app.domain.dao.IStudentDAO;

public class StudentDAO implements DAO<Student,Integer>, IStudentDAO {

	private static StudentDAO singleton;
	
	private StudentDAO() {}
	
	public static StudentDAO getInstance() {
		if(singleton==null) {
			singleton = new StudentDAO();
		}
		return singleton;
	}
	
	@Override
	public Student create(Student s) throws SQLException {
		Connection conn = ConnectionJDBC.getConnection();
		PreparedStatement ps = conn.prepareStatement("insert into training.student (name, age) values(?,?)", Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, s.getName());
		ps.setInt(2, s.getAge());
		
		System.out.println("Inserted rows : " + ps.executeUpdate());
		
		ResultSet rs = ps.getGeneratedKeys();
		if(rs.next()) {
			int generatedId = rs.getInt(1);
			s.setId(generatedId);
		}
		rs.close();
		ps.close();
		return s;
	}

	@Override
	public Student read(Integer id) throws SQLException {
		Student s = null;
		Connection conn = ConnectionJDBC.getConnection();
		PreparedStatement ps = conn.prepareStatement("select student.student_id, student.name, student.age from training.student where student.student_id=?");
		ps.setInt(1, id);
		
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			s = new Student();
			s.setId(rs.getInt(1));
			s.setName(rs.getString(2));
			s.setAge(rs.getInt(3));
		}
		
		rs.close();
		ps.close();
		
		return s;
	}

	@Override
	public Student update(Student s) throws SQLException {
		Connection conn = ConnectionJDBC.getConnection();
		PreparedStatement ps = conn.prepareStatement("update training.student set name=?, age=? where student.student_id=?");
		ps.setString(1, s.getName());
		ps.setInt(2, s.getAge());
		ps.setInt(3, s.getId());
		
		System.out.println("Updated rows : " + ps.executeUpdate());
		
		ps.close();
		return s;
	}

	@Override
	public void delete(Student s) throws SQLException {
		Connection conn = ConnectionJDBC.getConnection();
		PreparedStatement ps = conn.prepareStatement("delete from training.student where student.student_id=?");
		ps.setInt(1, s.getId());
		
		System.out.println("Deleted rows : " + ps.executeUpdate());
		
		ps.close();
	}

	@Override
	public List<Student> findAll() throws SQLException {
		Connection conn = ConnectionJDBC.getConnection();
		PreparedStatement ps = conn.prepareStatement("select student.student_id, student.name, student.age from training.student");
		
		ResultSet rs = ps.executeQuery();
		List<Student> list = new ArrayList<Student>();
		while(rs.next()) {
			Student s = new Student();
			s.setId(rs.getInt(1));
			s.setName(rs.getString(2));
			s.setAge(rs.getInt(3));
			
			list.add(s);
		}
		
		rs.close();
		ps.close();
		return list;
	}

	@Override
	public Student findByName(String name) throws SQLException {
		Student s = null;
		Connection conn = ConnectionJDBC.getConnection();
		PreparedStatement ps = conn.prepareStatement("select student.student_id, student.name, student.age from training.student where student.name=?");
		ps.setString(1, name);
		
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			s = new Student();
			s.setId(rs.getInt(1));
			s.setName(rs.getString(2));
			s.setAge(rs.getInt(3));
		}
		rs.close();
		ps.close();
		return s;
	}

}
