package be.technofutur.hospital;

public final class Patient extends Person implements IHealth {

	protected int healthState = 0;
	
	public final int TO_DIAGNOSE = 0;
	public final int TO_OPERATE = 1;
	public final int IN_TREATMENT = 2;
	public final int DIED = 3;
	public final int RECOVERED = 4;
	
	protected String status [] = {"TO DIAGNOSE", "TO OPERATE", "IN TREATMENT", "DIED", "RECOVERED"};
	
	/**
	 * Constructor
	 * 
	 * @param firstName
	 * @param lastName
	 * @param birthDate
	 * 
	 */
	public Patient(String firstName, String lastName, String birthDate) {
		
		super(firstName, lastName, birthDate);
	}
	
	/**
	 * setHealthState
	 * 
	 * @param int 	The current state (TO_DIAGNOSE, TO_OPERATE, IN_TREATMENT, DIED, RECOVERED)
	 * 
	 * @throws Exception 
	 */
	public void setHealthState(int state) throws Exception {
		
		if(state < 0 || state > 4) {
			
			throw new Exception("Health state must be a valid state. Use only TO_DIAGNOSE, TO_OPERATE, IN_TREATMENT, DIED or RECOVERED constant");
		}
		
		this.healthState = state;
	}
	
	public String getHealthState() {
		 
		return this.status[this.healthState];
	}

}
