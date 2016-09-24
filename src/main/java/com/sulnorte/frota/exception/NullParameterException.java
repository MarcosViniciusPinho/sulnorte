package com.sulnorte.frota.exception;

public class NullParameterException extends IllegalArgumentException {
    public NullParameterException(String mensagem) {
        super(mensagem);
    }
}
