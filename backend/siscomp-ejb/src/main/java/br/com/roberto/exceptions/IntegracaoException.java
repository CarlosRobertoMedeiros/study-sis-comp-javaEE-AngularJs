package br.com.roberto.exceptions;

public class IntegracaoException extends Exception {

	public static final int CODIGO = 400;

	public IntegracaoException(String message) {
		super(message);
	}

	public IntegracaoException(String message, Throwable cause) {
		super(message, cause);
	}
}
