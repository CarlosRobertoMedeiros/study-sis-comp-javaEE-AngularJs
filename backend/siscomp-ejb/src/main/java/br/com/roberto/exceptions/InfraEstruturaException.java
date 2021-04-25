package br.com.roberto.exceptions;

import java.io.Serializable;

public class InfraEstruturaException extends RuntimeException implements Serializable {

	/**
	 *
	 */
	private static final int CODIGO = 500;

	public InfraEstruturaException(String message) {
		super(message);
	}

	public InfraEstruturaException(String message, Throwable cause) {
		super(message, cause);
	}

	public static int getCodigo() {
		return CODIGO;
	}
}
