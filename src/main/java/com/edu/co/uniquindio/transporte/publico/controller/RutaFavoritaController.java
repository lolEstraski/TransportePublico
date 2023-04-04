package com.edu.co.uniquindio.transporte.publico.controller;



import com.edu.co.uniquindio.transporte.publico.domain.Ruta;
import com.edu.co.uniquindio.transporte.publico.dto.*;
import com.edu.co.uniquindio.transporte.publico.service.RutaFavoritaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/ruta")
@AllArgsConstructor
public class RutaFavoritaController   implements IRutaFavoritaController{


    private RutaFavoritaService rutaFavoritaService;


    @Override
    public ResponseEntity<Ruta> agregarRutaFavorita(RutaFavoritaRequest parametros) {
        var ruta = rutaFavoritaService.AgregarRutaFavorita(parametros) ;
        return ResponseEntity.ok(ruta);
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

