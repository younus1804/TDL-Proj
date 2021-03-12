package com.example.demo.exceptions;

import javax.persistence.EntityNotFoundException;

public class TaskNotFoundException extends EntityNotFoundException {
	
	private static final long serialVersionUID = -123456789L;

	public TaskNotFoundException() {
		super();
	}

	public TaskNotFoundException(String message) {
		super(message);
	}
}
