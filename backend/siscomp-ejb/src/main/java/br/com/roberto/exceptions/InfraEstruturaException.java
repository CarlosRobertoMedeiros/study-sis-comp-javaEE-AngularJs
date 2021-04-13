package br.com.roberto.exceptions;

public class InfraEstruturaException extends Exception {

	/**
	 *
	 */
	public static final int CODIGO = 500;

	public InfraEstruturaException(String message) {
		super(message);
	}

	public InfraEstruturaException(String message, Throwable cause) {
		super(message, cause);
	}
}
