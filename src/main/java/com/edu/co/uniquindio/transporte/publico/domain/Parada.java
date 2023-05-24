package com.edu.co.uniquindio.transporte.publico.domain;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity( name = "PARADAS")
@Data
@NoArgsConstructor

public class Parada implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String nombre;
    private String direccion;
    private String latitud;
    private String longitud;

    @OneToOne
    @JoinColumn(name = "id_ruta", referencedColumnName = "id")
    private Ruta ruta;
}
