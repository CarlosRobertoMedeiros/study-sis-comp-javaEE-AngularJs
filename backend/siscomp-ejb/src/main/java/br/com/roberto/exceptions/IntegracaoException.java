package br.com.roberto.exceptions;

import java.io.Serializable;

public class IntegracaoException extends Exception implements Serializable {

	public static final int CODIGO = 400;

	public IntegracaoException(String message) {
		super(message);
	}

	public IntegracaoException(String message, Throwable cause) {
		super(message, cause);
	}
}
