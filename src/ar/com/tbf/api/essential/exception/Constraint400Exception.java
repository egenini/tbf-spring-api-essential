package ar.com.tbf.api.essential.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ar.com.tbf.common.application.helper.IMessageManager;

public class Constraint400Exception extends ResponseStatusException{

	private static final long serialVersionUID = -410846358602528931L;
	private IMessageManager messageManager;
	
	/**
	 * Envía un 400 con la descripción del o los errores
	 * @param reason
	 */
	public Constraint400Exception( String reason ) {
		
		this( HttpStatus.BAD_REQUEST, reason);
	}

	public Constraint400Exception( IMessageManager reason ) {
		
		//this( HttpStatus.BAD_REQUEST, new ObjectMapper().setSerializationInclusion(Include.NON_NULL).writeValueAsString(reason) );		
		
		this( HttpStatus.BAD_REQUEST, "" );
		
		this.setMessageManager(reason);
	}

	/**
	 * @See ValidationException( String reason )
	 * @param status
	 * @param reason
	 */
	public Constraint400Exception(HttpStatus status, String reason) {
		super(status, reason);
		
	}

	public IMessageManager getMessageManager() {
		return messageManager;
	}

	public void setMessageManager(IMessageManager messageManager) {
		this.messageManager = messageManager;
	}
}
