package ar.com.tbf.api.essential.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class Forbidden403Exception extends ResponseStatusException{

	private static final long serialVersionUID = -410846358602528931L;
	
	/**
	 * Envía un 403 por no tener permirido el acceso al recurso.
	 * 
	 * Aclaración: el 401 corresponde a la falta de autenticación
	 * 
	 * @param reason
	 */
	public Forbidden403Exception( String reason ) {
		
		this( HttpStatus.FORBIDDEN, reason);
	}
	
	/**
	 * @See ValidationException( String reason )
	 * @param status
	 * @param reason
	 */
	public Forbidden403Exception(HttpStatus status, String reason) {
		super(status, reason);
		
	}
}
