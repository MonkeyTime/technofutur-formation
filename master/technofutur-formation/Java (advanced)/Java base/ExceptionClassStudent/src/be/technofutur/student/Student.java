package be.technofutur.student;
import java.util.Arrays;

public class Student {

	protected String firstName;
	protected String lastName;
	protected Course [] courses = new Course [10];
	protected int indexCourse;
	protected static int MAX_COURSES = 10;
	
	/**
	 * Constructor
	 * 
	 * @param firstName
	 * @param lastName
	 * 
	 */
	public Student(String firstName, String lastName) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.indexCourse = 0;
	}
	
	/**
	 * addCourse
	 * 
	 * @param course
	 * @throws Exception
	 */
	public void addCourse(Course course) throws Exception {
		
		if(Arrays.binarySearch(courses, course.label) >= 0) {
			
			throw new Exception("This course is already added.");
		}
		
		if(this.indexCourse < MAX_COURSES) {
			
			courses[this.indexCourse] = course;
					
			indexCourse++;
			
			return;
		
		}
		
		throw new Exception("Max courses reached: Max " + MAX_COURSES);
	}
	
	/**
	 * getCourse
	 * 
	 * @param index
	 * 
	 * @return Course
	 * 
	 * @throws Exception
	 */
	public Course getCourse(int index) throws Exception {
		
		if((index - 1) < 0) {
			
			throw new Exception("Human index start to 1");
		}
		
		if((index - 1) >= 10) {
			
			throw new Exception("Human index end at 10");
		}
		
		if(this.courses[index] == null) {
			
			throw new Exception("No course found at this index");
		}
		
		return this.courses[index];
	}

}
