package be.technofutur.hospital;

public interface ISurgery {
	
	public final int CARDIOLOGIE = 1, NEUROLOGIE = 2, PNEUMOLOGIE = 3, STOMATOLOGIE = 4, UROLOGIE = 5;
	public void setSurgerySpeciality(int s);
}
