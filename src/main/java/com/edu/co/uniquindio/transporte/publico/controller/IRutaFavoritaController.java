package com.edu.co.uniquindio.transporte.publico.controller;

import com.edu.co.uniquindio.transporte.publico.domain.Ruta;
import com.edu.co.uniquindio.transporte.publico.domain.RutaFavorita;
import com.edu.co.uniquindio.transporte.publico.dto.*;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface IRutaFavoritaController {


    @PostMapping("{idPersona}/favorita/ruta/{idRuta}")
    @CrossOrigin(origins = "console.firebase.google.com")
    @ApiOperation("Agrega una ruta favorita  ")
    @ApiResponses({
            @ApiResponse( code = 200, message = "Ruta agregada con  exito", response = Ruta.class ),
            @ApiResponse( code = 400, message = "no se puede agregar", response = Exception.class )
    })
    void agregarRutaFavorita(@PathVariable Integer idPersona,@PathVariable Integer idRuta);

    @GetMapping
    @CrossOrigin(origins = "console.firebase.google.com")
    @ApiOperation("busca una ruta por  su nombre o id ")
    @ApiResponses({
            @ApiResponse( code = 200, message = "Ruta encreada exitosamente", response = RutaDto.class ),
            @ApiResponse( code = 400, message = "Verificar  datos", response = Exception.class )
    })
    RutaFavoritaDto buscarRutaFavorita(@RequestParam String nombre, Integer id);


    @DeleteMapping
    @CrossOrigin(origins = "console.firebase.google.com")
    @ApiOperation("Elimina una ruta dado  su nombre o id ")
    @ApiResponses({
            @ApiResponse( code = 200, message = "eliminacion exitosa"),
            @ApiResponse( code = 400, message = "no se puede puede elimar por que esta ruta no existe", response = Exception.class )
    })
    void elimarRutaFavorita(EliminarRutaFavoritaRequest parametros) throws Exception;


    @GetMapping(path = "RutaFavorita")
    List<RutaFavorita> obtenerRutasFavoritas();
}
