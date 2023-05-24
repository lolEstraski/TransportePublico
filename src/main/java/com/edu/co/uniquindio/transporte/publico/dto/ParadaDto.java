package com.edu.co.uniquindio.transporte.publico.dto;


import lombok.Data;

@Data
public class ParadaDto {
    private Long id;
    private String nombre;
    private String direccion;
    private double latitud;
    private double longitud;

}
