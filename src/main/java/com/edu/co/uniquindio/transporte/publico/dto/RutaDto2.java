package com.edu.co.uniquindio.transporte.publico.dto;

import lombok.Data;

import java.util.List;


@Data
public class RutaDto2 {

    private String id;
    private String nombre;

    private List<ParadaDto> paradas;


}
