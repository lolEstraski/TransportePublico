package com.edu.co.uniquindio.transporte.publico.domain;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Data
@Entity( name = "RUTAS")
@NoArgsConstructor
public class Ruta implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String nombre;

    private  String sentido;

    private  long frecuencia;

    private boolean plataforma;

    private String origen;

    private String destino;

}
