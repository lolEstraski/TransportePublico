package com.edu.co.uniquindio.transporte.publico.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;


@Data
@Entity( name = "RUTAS")
@NoArgsConstructor
public class Ruta implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private Integer IdHorario;

    private String nombre;

    private  String sentido;

    private  long frecuencia;

    private boolean plataforma;

    private String origen;

    private String destino;





}
