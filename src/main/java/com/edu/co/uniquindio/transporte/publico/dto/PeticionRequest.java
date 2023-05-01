package com.edu.co.uniquindio.transporte.publico.dto;

import lombok.Data;

import java.util.Date;

@Data
public class PeticionRequest {

    private Integer id;

    //-------------------------------- Atributos de la Entidad ------------------------------------
    private String nombre;

    private String descripcion;

    private String tipo;

    private Date fecha;

    private String estado;


}
