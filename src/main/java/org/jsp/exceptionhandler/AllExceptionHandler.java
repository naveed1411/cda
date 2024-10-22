package org.jsp.exceptionhandler;

import org.jsp.exception.NoDepartmentFoundException;
import org.jsp.exception.UserNotFoundException;
import org.jsp.responsestructure.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AllExceptionHandler {
	
	@ExceptionHandler(NoDepartmentFoundException.class)
	public ResponseEntity<?> nDepartmentFoundExceptionHandler(NoDepartmentFoundException e)
	{
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResponseStructure.builder().message("No Department found in the database...").status(HttpStatus.BAD_REQUEST.value()).body(e.getMessage()).build());

	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<?> userNotFoundExceptionHandler(UserNotFoundException e)
	{
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResponseStructure.builder().message("No user found in the database...").status(HttpStatus.BAD_REQUEST.value()).body(e.getMessage()).build());

	}
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<?> runtimeExceptionHandler(RuntimeException  e)
	{
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResponseStructure.builder().message("Exception Occured....").status(HttpStatus.BAD_REQUEST.value()).body(e.getMessage()).build());

	}
	

}
