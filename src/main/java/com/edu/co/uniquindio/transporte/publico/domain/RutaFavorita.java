package com.edu.co.uniquindio.transporte.publico.domain;

import lombok.Data;

import javax.persistence.*;

@Entity( name = "RUTAS_FAVORITAS")
@Data
public class RutaFavorita {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "pasajero", referencedColumnName = "id")
    private Persona persona;

    @ManyToOne
    @JoinColumn(name = "ruta", referencedColumnName = "id")
    private Ruta ruta;
}
