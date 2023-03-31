package com.edu.co.uniquindio.transporte.publico.dto;

import lombok.Data;

@Data
public class RutaDto {

    private Integer id;

    private String nombre;

    private  String sentido;

    private  String frecuencia;
}
