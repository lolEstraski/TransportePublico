package com.edu.co.uniquindio.transporte.publico.dto;

import java.io.Serializable;

public class LoginRequest implements Serializable {

    private String nombreUsuario;

    private String contrasena;

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
