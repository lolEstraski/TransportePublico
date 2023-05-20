package com.edu.co.uniquindio.transporte.publico.dto;

import com.edu.co.uniquindio.transporte.publico.domain.Horario;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.List;

@Data
public class RutaRequest implements Serializable {

    private String nombre;

    private  String sentido;

    private  long frecuencia;

    private String dia;

    private String hora;

    private List<Horario> horarios;

    private  boolean plataforma;

    private String origen;

    private String destino;

    private Integer id;

    private Integer IdHorario;




}
