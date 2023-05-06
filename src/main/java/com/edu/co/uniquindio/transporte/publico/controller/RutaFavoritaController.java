package com.edu.co.uniquindio.transporte.publico.controller;


import com.edu.co.uniquindio.transporte.publico.domain.RutaFavorita;
import com.edu.co.uniquindio.transporte.publico.dto.EliminarRutaFavoritaRequest;
import com.edu.co.uniquindio.transporte.publico.dto.RutaFavoritaDto;
import com.edu.co.uniquindio.transporte.publico.service.RutaFavoritaService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/RutaFavorita")
@AllArgsConstructor
public class RutaFavoritaController implements IRutaFavoritaController {

    private RutaFavoritaService rutaFavoritaService;

    @Override
    public void agregarRutaFavorita(Integer idPersona, Integer idRuta) {
        rutaFavoritaService.agregarRutaFavorita(idPersona,idRuta);
    }

    @Override
    public RutaFavoritaDto buscarRutaFavorita(String nombre, Integer id) {
        var ruta= rutaFavoritaService.buscarRutaFavorita(nombre,id);
        return ruta;
    }


    @Override
    public void elimarRutaFavorita(EliminarRutaFavoritaRequest parametros) throws Exception {
        rutaFavoritaService.eliminarRutaFavorita(parametros);

    }

    @Override
    public List<RutaFavorita> obtenerRutasFavoritas() {
        return rutaFavoritaService.obtenerRutasFavoritas();
    }
}
