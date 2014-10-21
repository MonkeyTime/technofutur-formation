package be.technofutur.hospital;

public final class Doctor extends Person {
	
	protected Patient [] patients = new Patient[1000];

	public Doctor(String firstName, String lastName, String birthDate) {
		
		super(firstName, lastName, birthDate);
	}

}
