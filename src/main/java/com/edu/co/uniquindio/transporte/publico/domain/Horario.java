package com.edu.co.uniquindio.transporte.publico.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalTime;


@Entity( name = "HORARIO")
@Data
@NoArgsConstructor
public class Horario implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

   private LocalTime horaInicio;

   private LocalTime horaFin;

    private String dia;



}
