package be.technofutur.labo.ejbs;

import java.util.List;

import javax.ejb.LocalBean;

import be.technofutur.labo.entities.Subject;

@LocalBean
public interface ISubjectRepository {

	List<Subject> findAll();

	Subject findByTitle(final String title);

	Subject saveSubject(final Subject subject);

	void deleteSubject(final Subject subject);
}
