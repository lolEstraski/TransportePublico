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

    private Integer idHorario;

    private String nombre;

    private  String sentido;

    private  long frecuencia;

    private boolean plataforma;

    private String origen;

    private String destino;


    @OneToMany
    @JoinColumn(name = "parada", referencedColumnName = "id")
    private List<Parada> paradas;



    public void agregarParada(Parada parada) {
        if (paradas == null) {
            paradas = new ArrayList<>();
        }
        paradas.add(parada);
    }

}
