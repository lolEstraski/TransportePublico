package com.edu.co.uniquindio.transporte.publico.controller;

import com.edu.co.uniquindio.transporte.publico.domain.Peticion;
import com.edu.co.uniquindio.transporte.publico.domain.Ruta;
import com.edu.co.uniquindio.transporte.publico.dto.PeticionRequest;
import com.edu.co.uniquindio.transporte.publico.dto.RutaRequest;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface IPeticionController {

    @PostMapping
    @CrossOrigin(origins = "console.firebase.google.com")
    @ApiOperation("crea una peticion  ")
    @ApiResponses({
            @ApiResponse( code = 200, message = "peticion creada con exito", response = Peticion.class ),
            @ApiResponse( code = 400, message = "Verificar ", response = Exception.class )
    })
    ResponseEntity<Peticion> crearPeticion(@RequestBody PeticionRequest parametros);

/**
    @GetMapping
    @CrossOrigin(origins = "console.firebase.google.com")
    @ApiOperation("obtiene una peticion dado  su id  ")
    @ApiResponses({
            @ApiResponse( code = 200, message = "la peticion con id es ", response = Peticion.class ),
            @ApiResponse( code = 400, message = "no se encuentran peticiones  ", response = Exception.class )
    })
    List<Peticion> obtenerPeticion(@PathVariable Integer id,@PathVariable String nombre);

*/





}
