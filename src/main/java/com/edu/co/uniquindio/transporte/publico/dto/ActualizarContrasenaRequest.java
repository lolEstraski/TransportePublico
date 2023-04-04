package com.edu.co.uniquindio.transporte.publico.dto;

import lombok.Data;

import java.io.Serializable;

@Data

public class ActualizarContrasenaRequest implements Serializable {

    private String pass;

    private String nuevaContrasena;
}
