package com.edu.co.uniquindio.transporte.publico.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalTime;


@Entity( name = "HORARIOS")
@Data
@NoArgsConstructor
public class Horario implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

   private LocalTime horaInicio;

   private LocalTime horaFin;

    private String dia;

    @ManyToOne
    @JoinColumn(name = "idRuta", referencedColumnName = "id")
    private Ruta ruta;


}
