package com.edu.co.uniquindio.transporte.publico.dto;

import lombok.Data;

import java.util.List;

@Data
public class InformacionRuta {

    private String dias;

    private List<String> horarios;

    private String infoDiscapacitados;
}
