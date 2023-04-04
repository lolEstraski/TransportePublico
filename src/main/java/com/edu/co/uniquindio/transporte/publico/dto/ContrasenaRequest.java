package com.edu.co.uniquindio.transporte.publico.dto;

import lombok.Data;

import java.io.Serializable;


@Data
public class ContrasenaRequest implements Serializable {

    private String email;

    private String pass;
}
