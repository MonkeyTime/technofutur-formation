package be.technofutur.labo.ejbs;

import java.util.List;
import be.technofutur.labo.entities.Subject;

public interface ISubjectManager {
	
	Subject createSubject(final Subject subject);

	List<Subject> findAll();

	Subject findByTitle(final String title);

	Subject saveSubject(final Subject subject);

	void deleteSubject(final Subject subject);
}
