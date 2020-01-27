package com.everis.kuntur.core.exception;

public class KunturHttpModelValidationException extends Exception {

    public KunturHttpModelValidationException(String message) {
        super(message);
    }

    public KunturHttpModelValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}
