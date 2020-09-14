package ar.com.tbf.api.essential.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class NotAllowed405Exception extends ResponseStatusException{

	private static final long serialVersionUID = 3098620863477812169L;

	public NotAllowed405Exception( String reason) {
		this(HttpStatus.METHOD_NOT_ALLOWED, reason);
	}

	public NotAllowed405Exception(HttpStatus status, String reason) {
		super(status, reason);
	}

}
