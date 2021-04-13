package br.com.roberto.exceptions;

public class NegocioException extends Exception {

    public static final int CODIGO = 412;

    public NegocioException(String message) {
        super(message);
    }

    public NegocioException(String message, Throwable cause) {
        super(message, cause);
    }


}
