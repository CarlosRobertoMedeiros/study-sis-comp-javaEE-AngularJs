package br.com.roberto.exceptions;

import java.io.Serializable;

public class NegocioException extends Exception implements Serializable {

    public static final int CODIGO = 412;

    public NegocioException(String message) {
        super(message);
    }

    public NegocioException(String message, Throwable cause) {
        super(message, cause);
    }


}
