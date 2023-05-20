package com.edu.co.uniquindio.transporte.publico.domain;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;



@Entity( name = "PASAJEROS")
@Data
@NoArgsConstructor

public class Persona implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private Integer cedula;
    private String nombre;
    private String telefono;
    private String email;
    private  String pass;


}
