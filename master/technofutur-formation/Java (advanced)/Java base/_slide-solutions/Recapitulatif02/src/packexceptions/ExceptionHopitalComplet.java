package packexceptions;

public class ExceptionHopitalComplet extends Exception {
	private static final long serialVersionUID = 1L;

	public ExceptionHopitalComplet() {
		super("L'hôpital est complet.");
	}
}
