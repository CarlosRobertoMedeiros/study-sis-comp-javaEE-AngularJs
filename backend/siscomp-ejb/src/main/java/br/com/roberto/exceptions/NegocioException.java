package br.com.roberto.exceptions;

import java.io.Serializable;

public class NegocioException extends RuntimeException implements Serializable {

    private static final int CODIGO = 412;

    public NegocioException(String message) {
        super(message);
    }

    public NegocioException(String message, Throwable cause) {
        super(message, cause);
    }

    public static int getCodigo() {
        return CODIGO;
    }
}
