package com.edu.co.uniquindio.transporte.publico.dto;


import lombok.Data;

@Data
public class ParadaDto {
    private Long id;
    private String nombre;
    private String direccion;
    private String latitud;
    private String longitud;

}
