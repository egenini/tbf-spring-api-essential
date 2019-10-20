package ar.com.tbf.api.essential.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class NotFound404Exception extends ResponseStatusException{

	private static final long serialVersionUID = -410846358602528931L;
	
	/**
	 * Envía un 404 con la descripción del o los errores
	 * @param reason
	 */
	public NotFound404Exception( String reason ) {
		
		this( HttpStatus.NOT_FOUND, reason);
	}
	
	/**
	 * @See ValidationException( String reason )
	 * @param status
	 * @param reason
	 */
	public NotFound404Exception(HttpStatus status, String reason) {
		super(status, reason);
		
	}
}
