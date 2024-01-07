package me.demelo.base.exceptions;

public class ResourceNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1334249612361953705L;

	public ResourceNotFoundException(String msg) {
		super(msg);
	}

}
