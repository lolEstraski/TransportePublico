package com.edu.co.uniquindio.transporte.publico.dto;


import lombok.Data;

@Data
public class RegistrarPasajeroRequest {

    private String cedula;

    private String nombre;

    private String telefono;

    private String email;

    private  String pass;

}
