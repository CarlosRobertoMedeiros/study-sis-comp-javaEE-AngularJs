package br.com.roberto.exceptions;

import java.io.Serializable;

public class InfraEstruturaException extends Exception implements Serializable {

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
