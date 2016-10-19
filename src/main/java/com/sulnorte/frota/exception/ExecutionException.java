package com.sulnorte.frota.exception;

public class ExecutionException extends RuntimeException {
    public ExecutionException(Throwable cause) {
        super(cause);
    }
    public ExecutionException(String message, Throwable cause) {
        super(message, cause);
    }
}
