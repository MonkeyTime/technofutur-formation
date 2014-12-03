package packexceptions;

public class ExceptionNbHabitantsNegatif extends Exception {
	private static final long serialVersionUID = 1L;
	

	public ExceptionNbHabitantsNegatif(String nomVille) {
		super("Le nombre d'habitants de " + nomVille + " est négatif.");		
	}

}
