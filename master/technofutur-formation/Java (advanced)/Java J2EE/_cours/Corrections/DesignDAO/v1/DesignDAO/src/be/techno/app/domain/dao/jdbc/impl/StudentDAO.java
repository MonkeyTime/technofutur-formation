package be.techno.app.domain.dao.jdbc.impl;

import java.sql.Connection;
import java.sql.SQLException;

import be.techno.app.domain.Student;
import be.techno.app.domain.dao.DAO;

public class StudentDAO implements DAO<Student,Integer> {

	private static StudentDAO singleton;
	
	private StudentDAO() {}
	

	
	public static StudentDAO getInstance() {
		if(singleton==null) {
			singleton = new StudentDAO();
		}
		return singleton;
	}
	
	@Override
	public Student create(Student s) {
		try {

		} catch (Exception e) {
			return null;
		}
		

		return s;
	}

	@Override
	public Student read(Integer id) {
		
		return null;
	}

	@Override
	public Student update(Student s) {
		
		return null;
	}

	@Override
	public void delete(Student s) {
		
	}

}
