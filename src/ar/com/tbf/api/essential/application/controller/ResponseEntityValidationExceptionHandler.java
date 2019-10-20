package ar.com.tbf.api.essential.application.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import ar.com.tbf.api.essential.exception.Constraint400Exception;
import ar.com.tbf.common.application.helper.IMessageManager;

@ControllerAdvice
@RestController
public class ResponseEntityValidationExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(Constraint400Exception.class)
	 public final ResponseEntity<IMessageManager> handleNotFoundException(Constraint400Exception ex, WebRequest request) {
		
	    return new ResponseEntity<IMessageManager>(ex.getMessageManager(), HttpStatus.BAD_REQUEST );
	  }

}
