package com.api.demo.employee.employee_api.exceptionhandling;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.api.demo.employee.employee_api.models.EmployeeNotFoundException;

@RestController
@ControllerAdvice
public class CustomizedResponseEntityExceptionhandler extends ResponseEntityExceptionHandler {

	public CustomizedResponseEntityExceptionhandler() {
		
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleAllException(Exception ex, WebRequest req) {
		
		ExceptionReponse exceptionReponse = new ExceptionReponse(new Date(), ex.getMessage(), req.getDescription(false));
		return new ResponseEntity<Object>(exceptionReponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<Object> handleUserNotFoundException(EmployeeNotFoundException ex, WebRequest req){
		ExceptionReponse exceptionReponse = new ExceptionReponse(new Date(), ex.getMessage(), req.getDescription(false));
		return new ResponseEntity<Object>(exceptionReponse, HttpStatus.NOT_FOUND);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		ExceptionReponse exceptionReponse = new ExceptionReponse(new Date(), "Validation Failed", ex.getBindingResult().toString());
		return new ResponseEntity<>(exceptionReponse, HttpStatus.BAD_REQUEST);
	}
}
