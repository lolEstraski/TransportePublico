package com.edu.co.uniquindio.transporte.publico.exception;

import lombok.Getter;

@Getter
public class TPublicoException extends Exception{

    private String mensaje;

    public TPublicoException(String mensaje) {
        super(mensaje);
        this.mensaje = mensaje;
    }
}
