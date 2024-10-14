package com.java.interactiveEndpoint.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DepartmentNotfoundException extends RuntimeException{
	
	  private static final long serialVersionUID = 7428051251365675318L;

	  public DepartmentNotfoundException(String message) {
		  super(message);
	  }

}
