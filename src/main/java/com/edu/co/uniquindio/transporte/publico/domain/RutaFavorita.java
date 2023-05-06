package com.edu.co.uniquindio.transporte.publico.domain;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class RutaFavorita {

    private String nombre;

    @ManyToOne
    @JoinColumn(name = "pasajero", referencedColumnName = "id")
    private Persona persona;

    @ManyToOne
    @JoinColumn(name = "ruta", referencedColumnName = "id")
    private Ruta ruta;
}
