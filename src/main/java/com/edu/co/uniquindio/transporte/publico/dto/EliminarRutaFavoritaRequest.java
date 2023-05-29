package com.edu.co.uniquindio.transporte.publico.dto;

import lombok.Data;

@Data
public class EliminarRutaFavoritaRequest {

    private Integer idRuta;
    private Integer idPasajero;
}
