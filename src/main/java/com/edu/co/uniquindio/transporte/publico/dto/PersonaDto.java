package com.edu.co.uniquindio.transporte.publico.dto;

import lombok.Data;

@Data
public class PersonaDto {

    private Integer id;
    private String nombre;

    private  String email;

    private String cedula;

    private Rol rol;

}
