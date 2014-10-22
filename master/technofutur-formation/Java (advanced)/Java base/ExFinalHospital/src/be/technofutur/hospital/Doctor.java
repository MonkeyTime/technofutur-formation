package be.technofutur.hospital;
import java.util.LinkedList;

public class Doctor extends Person {
	
	protected static int indexPatients = 0;
	
	protected LinkedList<Patient> patients = new LinkedList<Patient>();

	/**
	 * Constructor
	 * 
	 * @param firstName
	 * @param lastName
	 * @param birthDate
	 */
	public Doctor(String firstName, String lastName, String birthDate) {
		
		super(firstName, lastName, birthDate);
	}
	
	
	public void addPatient(Patient patient) throws Exception {
		
		for(int i = 0; i < patients.size(); i++) {
			
			if(patients.get(i).equals(null)) {
				
				return;
			}
			
			if(patients.get(i).equals(patient)) {
				
				throw new Exception("This patient " +patient.firstName +  " " + patient.lastName + " already exist.");
			}
		}
		
		patients.add(patient);
	}

	/*protected void flushPatientsList() {
		
		for(int i = 0; i < patients.size(); i++) {
			
			if(patients.get(i).status.equals("RECOVERED") || patients.get(i).status.equals("DIED")) {
				
				patients.remove(patients.get(i));
			}
		}
	}*/
}
