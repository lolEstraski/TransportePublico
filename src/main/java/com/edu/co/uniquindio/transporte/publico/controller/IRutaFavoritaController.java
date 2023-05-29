package com.edu.co.uniquindio.transporte.publico.controller;

import com.edu.co.uniquindio.transporte.publico.domain.Ruta;
import com.edu.co.uniquindio.transporte.publico.domain.RutaFavorita;
import com.edu.co.uniquindio.transporte.publico.dto.*;
import com.edu.co.uniquindio.transporte.publico.exception.TPublicoException;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface IRutaFavoritaController {


    @PostMapping()
    @CrossOrigin(origins = "*")
    @ApiOperation("Agrega una ruta favorita  ")
    @ApiResponses({
            @ApiResponse( code = 200, message = "Ruta agregada con  exito", response = Ruta.class ),
            @ApiResponse( code = 409, message = "Problema al agregar ruta favorita", response = String.class )
    })
    ResponseEntity<RutaFavorita> agregarRutaFavorita(@RequestBody RutaFavoritaDto request) throws TPublicoException;

    @GetMapping
    @CrossOrigin(origins = "*")
    @ApiOperation("busca una ruta por  su nombre o id ")
    @ApiResponses({
            @ApiResponse( code = 200, message = "Ruta encreada exitosamente", response = RutaDto.class ),
            @ApiResponse( code = 400, message = "Verificar  datos", response = Exception.class )
    })
    RutaFavoritaDto buscarRutaFavorita(@RequestParam String nombre, Integer id);


    @DeleteMapping
    @CrossOrigin(origins = "*")
    @ApiOperation("Elimina una ruta dado  su nombre o id ")
    @ApiResponses({
            @ApiResponse( code = 200, message = "eliminacion exitosa"),
            @ApiResponse( code = 400, message = "no se puede puede elimar por que esta ruta no existe", response = Exception.class )
    })
    void elimarRutaFavorita(@RequestBody EliminarRutaFavoritaRequest parametros) throws Exception;


    @GetMapping(path = "/pasajero/{idPersona}")
    List<Ruta> obtenerRutasFavoritas(@PathVariable Integer idPersona);
}
