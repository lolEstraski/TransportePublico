package com.edu.co.uniquindio.transporte.publico.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity( name = "PQRS")
@Data
@NoArgsConstructor
public class Peticion implements Serializable  {
    // Esta es la PK de esta entidad
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //-------------------------------- Atributos de la Entidad ------------------------------------
    private  String nombre;

    private String descripcion;

    private String tipo;

    private LocalDateTime fecha;

    private String estado;

    @ManyToOne
    @JoinColumn(name = "pasajero", referencedColumnName = "id")
    private Persona persona;


}
