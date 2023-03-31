package com.edu.co.uniquindio.transporte.publico.controller;

import com.edu.co.uniquindio.transporte.publico.domain.Ruta;
import com.edu.co.uniquindio.transporte.publico.dto.PersonaDto;
import com.edu.co.uniquindio.transporte.publico.dto.RutaDto;
import com.edu.co.uniquindio.transporte.publico.dto.RutaRequest;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


public interface IRutaParadaController {


    @PostMapping
    @CrossOrigin(origins = "console.firebase.google.com")
    @ApiOperation("crea una ruta  ")
    @ApiResponses({
            @ApiResponse( code = 200, message = "Login exitoso", response = PersonaDto.class ),
            @ApiResponse( code = 400, message = "Verificar credenciales", response = Exception.class )
    })
    ResponseEntity<Ruta> crearRuta(@RequestBody RutaRequest parametros);

    @GetMapping
    @CrossOrigin(origins = "console.firebase.google.com")
    @ApiOperation("busca una ruta por  su nombre o id ")
    @ApiResponses({
            @ApiResponse( code = 200, message = "Login exitoso", response = PersonaDto.class ),
            @ApiResponse( code = 400, message = "Verificar credenciales", response = Exception.class )
    })
    ResponseEntity<RutaDto> buscarRuta(@RequestParam String nombre,Integer id);









}
