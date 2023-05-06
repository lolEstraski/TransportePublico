package com.edu.co.uniquindio.transporte.publico.controller;


import com.edu.co.uniquindio.transporte.publico.domain.Ruta;
import com.edu.co.uniquindio.transporte.publico.dto.EliminarRutaFavoritaRequest;
import com.edu.co.uniquindio.transporte.publico.dto.RutaDto;
import com.edu.co.uniquindio.transporte.publico.dto.RutaFavoritaRequest;
import com.edu.co.uniquindio.transporte.publico.service.RutaFavoritaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/pqrs")
@AllArgsConstructor
public class RutaFavoritaController implements IRutaFavoritaController {

    private RutaFavoritaService rutaFavoritaService;

    @Override
    public void agregarRutaFavorita(Integer idPersona, Integer idRuta) {
        rutaFavoritaService.agregarRutaFavorita(idPersona,idRuta);
    }

    @Override
    public ResponseEntity<RutaDto> buscarRutaFavorita(String nombre, Integer id) {
        return null;
    }

    @Override
    public Ruta actualizarRutaFavorita(RutaFavoritaRequest parametros) throws Exception {
        return null;
    }

    @Override
    public void elimarRutaFavorita(EliminarRutaFavoritaRequest parametros) throws Exception {

    }
}
