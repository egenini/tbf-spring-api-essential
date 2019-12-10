package ar.com.tbf.api.essential.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import ar.com.tbf.common.application.helper.IMessageManager;

public class NotFound404Exception extends ResponseStatusException{

	private static final long serialVersionUID = -410846358602528931L;
	
	private IMessageManager messageManager;
	
	/**
	 * Envía un 404 con la descripción del o los errores
	 * @param reason
	 */
	public NotFound404Exception( String reason ) {
		
		this( HttpStatus.NOT_FOUND, reason);
	}
	
	/**
	 * @param status
	 * @param reason
	 */
	public NotFound404Exception(HttpStatus status, String reason) {
		super(status, reason);
	}
	
	public NotFound404Exception( IMessageManager reason ) {
		
		this( HttpStatus.NOT_FOUND, "" );
		
		this.setMessageManager(reason);
	}

	public IMessageManager getMessageManager() {
		return messageManager;
	}

	public void setMessageManager(IMessageManager messageManager) {
		this.messageManager = messageManager;
	}

}
