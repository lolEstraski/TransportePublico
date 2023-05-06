package com.edu.co.uniquindio.transporte.publico.dto;

import com.edu.co.uniquindio.transporte.publico.domain.Persona;
import com.edu.co.uniquindio.transporte.publico.domain.Ruta;
import lombok.Data;


import java.io.Serializable;

@Data
public class RutaFavoritaRequest implements Serializable {


    private  Integer idPersona;

    private  Integer idRuta;

}
