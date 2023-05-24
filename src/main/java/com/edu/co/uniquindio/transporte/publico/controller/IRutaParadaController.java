package com.edu.co.uniquindio.transporte.publico.controller;
import com.edu.co.uniquindio.transporte.publico.domain.Parada;
import com.edu.co.uniquindio.transporte.publico.domain.Ruta;
import com.edu.co.uniquindio.transporte.publico.dto.*;
import com.edu.co.uniquindio.transporte.publico.exception.TPublicoException;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

public interface IRutaParadaController {


    @PostMapping
    @CrossOrigin(origins = "*")
    @ApiOperation("crea una ruta  ")
    @ApiResponses({
            @ApiResponse(code = 200, message = "ruta creada con exito", response = Ruta.class),
            @ApiResponse(code = 400, message = "Verificar ", response = Exception.class)
    })
    ResponseEntity<Ruta> crearRuta(@RequestBody RutaRequest parametros);


    @GetMapping
    @CrossOrigin(origins = "*")
    @ApiOperation("busca una ruta por  su nombre o id ")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Ruta encreada exitosamente", response = RutaDto.class),
            @ApiResponse(code = 400, message = "Verificar  datos", response = Exception.class)
    })
    ResponseEntity<RutaDto> buscarRuta(@RequestParam Integer id);


    @PatchMapping
    @CrossOrigin(origins = "*")
    @ApiOperation("Actualiza una ruta  ")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Actualizacion exitosa", response = Ruta.class),
            @ApiResponse(code = 400, message = "Verificar Datos", response = Exception.class)
    })
    Ruta actualizarRuta(@RequestBody RutaRequest parametros) throws TPublicoException;


    @DeleteMapping
    @CrossOrigin(origins = "*")
    @ApiOperation("Elimina una ruta dado  su nombre o id ")
    @ApiResponses({
            @ApiResponse(code = 200, message = "eliminacion exitosa"),
            @ApiResponse(code = 400, message = "no se puede puede elimar por que esta ruta no existe", response = Exception.class)
    })
    void elimarRuta(@RequestBody EliminarRutaRequest parametros) throws TPublicoException;


    @GetMapping(path = "ruta")
    List<Ruta> obtenerRutas();

    @GetMapping(path = "Rutas")
    @CrossOrigin(origins = "*")
    @ApiOperation("busca una ruta por su origen destino  ")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Ruta obtenida exitosamente", response = RutaDto.class),
            @ApiResponse(code = 400, message = "no se pudo realizar  la obtencion ", response = Exception.class)
    })
    List<RutaDto> obtenerRutas(@PathVariable String origen, @PathVariable String destino);


    @GetMapping(path = "rutass")
    @CrossOrigin(origins = "*")
    @ApiOperation("busca una ruta  que contengan plataforma ")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Ruta con plataforma", response = Ruta.class),
            @ApiResponse(code = 400, message = "no existe ruta con plataforma", response = Exception.class)
    })
    List<Ruta> buscarRutasConPlataforma();


    @PostMapping(path ="/{id}/paradas")
    @CrossOrigin(origins = "console.firebase.google.com")
    @ApiOperation("busca una ruta  que contengan plataforma ")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Ruta con plataforma", response = Ruta.class),
            @ApiResponse(code = 400, message = "no existe ruta con plataforma", response = Exception.class)
    })
    ResponseEntity<Ruta> agregarParada(@PathVariable Integer id, @RequestBody Parada parada);



}