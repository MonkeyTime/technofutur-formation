package be.techno.app.domain.dao;

import java.sql.SQLException;

import be.techno.app.domain.Student;

public interface IStudentDAO {

	public Student findByName(String name) throws SQLException;
}
