package be.technofutur.labo.ejbs;

import java.util.ArrayList;
import java.util.List;

import be.technofutur.labo.entities.Subject;

public class SubjectRepository implements ISubjectRepository {

	private List<Subject> subjects;
	
	public SubjectRepository() {
		
		this.subjects = new ArrayList<Subject>();
	}
	
	@Override
	public List<Subject> findAll() {

		return this.subjects;
	}

	@Override
	public Subject findByTitle(String title) {
		
		for(Subject subject : this.subjects) {
			
			if(subject.getTitle() == title) {
				
				return subject;
			}
		}
		
		return null;
	}

	@Override
	public Subject saveSubject(Subject subject) {

		this.subjects.add(subject);
		
		return subject;
	}

	@Override
	public void deleteSubject(Subject subject) {
		
		this.subjects.remove(subject);
	}

}
