package com.edu.co.uniquindio.transporte.publico.controller;

import com.edu.co.uniquindio.transporte.publico.domain.Ruta;
import com.edu.co.uniquindio.transporte.publico.dto.*;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface IRutaFavoritaController {


    @PostMapping("{id}/favorita/ruta/{id}")
    @CrossOrigin(origins = "console.firebase.google.com")
    @ApiOperation("Agrega una ruta favorita  ")
    @ApiResponses({
            @ApiResponse( code = 200, message = "Ruta agregada con  exito", response = Ruta.class ),
            @ApiResponse( code = 400, message = "no se puede agregar", response = Exception.class )
    })
    void agregarRutaFavorita(@RequestParam Integer idPersona,Integer idRuta);

    @GetMapping
    @CrossOrigin(origins = "console.firebase.google.com")
    @ApiOperation("busca una ruta por  su nombre o id ")
    @ApiResponses({
            @ApiResponse( code = 200, message = "Ruta encreada exitosamente", response = RutaDto.class ),
            @ApiResponse( code = 400, message = "Verificar  datos", response = Exception.class )
    })
    ResponseEntity<RutaDto> buscarRutaFavorita(@RequestParam String nombre, Integer id);


    @PatchMapping
    @CrossOrigin(origins = "console.firebase.google.com")
    @ApiOperation("Actualiza una ruta  ")
    @ApiResponses({
            @ApiResponse( code = 200, message = "Actualizacion exitosa", response = Ruta.class ),
            @ApiResponse( code = 400, message = "Verificar Datos", response = Exception.class )
    })
    Ruta actualizarRutaFavorita(@RequestBody RutaFavoritaRequest parametros) throws Exception;


    @DeleteMapping
    @CrossOrigin(origins = "console.firebase.google.com")
    @ApiOperation("Elimina una ruta dado  su nombre o id ")
    @ApiResponses({
            @ApiResponse( code = 200, message = "eliminacion exitosa"),
            @ApiResponse( code = 400, message = "no se puede puede elimar por que esta ruta no existe", response = Exception.class )
    })
    void elimarRutaFavorita(EliminarRutaFavoritaRequest parametros) throws Exception;
}
