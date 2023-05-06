package com.edu.co.uniquindio.transporte.publico.dto;

import lombok.Data;

@Data
public class RutaFavoritaDto {

    private Integer idPersona;
    private  Integer idRuta;

    private Integer id;

    private String nombre;

    private  String sentido;

    private  long frecuencia;

    private  String origen;

    private String destino;


}
