package be.wavenet.domain.exceptions;

import javax.ejb.ApplicationException;

/*
 * Les exceptions gérées par JPA sont toutes des RuntimeException
 * Une fois que le JPA provider catch ce genre d'exception, un rollback
 * peut être effectué afin de ne pas interrompre le programme appelant
 * L'action sur les entités est donc annulée
 */
@ApplicationException(rollback = true)
public class ValidationException extends RuntimeException {

	private static final long serialVersionUID = 6648414257544745664L;

	public ValidationException(final String message) {
		super(message);
	}
	
}
