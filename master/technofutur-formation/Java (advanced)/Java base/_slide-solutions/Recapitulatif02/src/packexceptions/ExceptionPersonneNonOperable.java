package packexceptions;

public class ExceptionPersonneNonOperable extends Exception {
	private static final long serialVersionUID = 1L;

	public ExceptionPersonneNonOperable(String nom, String prenom) {
		super(prenom + " " + nom + " n'a pas été diagnostiqué comme opérable");
	}
}
