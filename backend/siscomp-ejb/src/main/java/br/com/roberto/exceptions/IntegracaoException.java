package br.com.roberto.exceptions;

import java.io.Serializable;

public class IntegracaoException extends RuntimeException implements Serializable {

	private static final int CODIGO = 400;

	public IntegracaoException(String message) {
		super(message);
	}

	public IntegracaoException(String message, Throwable cause) {
		super(message, cause);
	}

	public static int getCodigo() {
		return CODIGO;
	}
}
