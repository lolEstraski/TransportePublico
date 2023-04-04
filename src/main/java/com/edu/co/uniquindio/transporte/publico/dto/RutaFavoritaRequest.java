package com.edu.co.uniquindio.transporte.publico.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class RutaFavoritaRequest implements Serializable {

    private String nombre;

    private  String sentido;

    private  String frecuencia;
}
