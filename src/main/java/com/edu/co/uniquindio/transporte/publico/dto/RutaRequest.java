package com.edu.co.uniquindio.transporte.publico.dto;

import lombok.Data;

import java.io.Serializable;
@Data
public class RutaRequest implements Serializable {

    private String nombre;

    private  String sentido;

    private  String frecuencia;

    private String dia;

    private String hora;




}
