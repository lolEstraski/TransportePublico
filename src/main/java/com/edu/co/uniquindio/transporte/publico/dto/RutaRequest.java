package com.edu.co.uniquindio.transporte.publico.dto;

import com.edu.co.uniquindio.transporte.publico.domain.Horario;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class RutaRequest implements Serializable {

    private String nombre;

    private  String sentido;

    private  String frecuencia;

    private String dia;

    private String hora;

    private List<Horario> horarios;

    private  boolean plataforma;




}
