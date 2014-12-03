package packexceptions;

public class ExceptionNbHabitantsNul extends Exception {
	private static final long serialVersionUID = 1L;
	

	public ExceptionNbHabitantsNul(String nomVille) {
		super("Le nombre d'habitants de " + nomVille + " est nul.");		
	}
}
