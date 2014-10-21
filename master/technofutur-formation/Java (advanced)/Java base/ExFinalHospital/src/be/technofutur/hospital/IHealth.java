package be.technofutur.hospital;

public interface IHealth {
	
	public int healthState = 0;
	
	
	public void setHealthState(int state) throws Exception;
	public String getHealthState();
}
