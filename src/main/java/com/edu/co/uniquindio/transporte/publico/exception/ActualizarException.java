package com.edu.co.uniquindio.transporte.publico.exception;

import lombok.Getter;

@Getter
public class ActualizarException extends Exception {
    private String mensaje;

    public ActualizarException(String mensaje) {
        super(mensaje);
        this.mensaje = mensaje;
    }
}
