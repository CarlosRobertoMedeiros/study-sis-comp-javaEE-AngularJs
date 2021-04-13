package br.com.roberto.exceptions;

public class IntegracaoException extends Exception {

	/**
	 *
	 */
	private static final long serialVersionUID = 7974266281769294001L;

	public static final int CODIGO = 400;

	public IntegracaoException(String message) {
		super(message);
	}

	public IntegracaoException(String message, Throwable cause) {
		super(message, cause);
	}
}
