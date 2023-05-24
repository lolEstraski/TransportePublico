package com.edu.co.uniquindio.transporte.publico.domain;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity( name = "ADMINISTRADORES")
@Data
@NoArgsConstructor
public class Administrador implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String cedula;
    private String nombre;
    private String telefono;
    private String email;
    private  String pass;

}
