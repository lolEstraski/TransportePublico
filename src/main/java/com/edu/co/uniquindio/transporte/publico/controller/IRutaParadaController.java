package com.edu.co.uniquindio.transporte.publico.controller;

import com.edu.co.uniquindio.transporte.publico.domain.Ruta;
import com.edu.co.uniquindio.transporte.publico.dto.*;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface IRutaParadaController {


    @PostMapping
    @CrossOrigin(origins = "console.firebase.google.com")
    @ApiOperation("crea una ruta  ")
    @ApiResponses({
            @ApiResponse( code = 200, message = "Login exitoso", response = Ruta.class ),
            @ApiResponse( code = 400, message = "Verificar credenciales", response = Exception.class )
    })
    ResponseEntity<Ruta> crearRuta(@RequestBody RutaRequest parametros);

    @GetMapping
    @CrossOrigin(origins = "console.firebase.google.com")
    @ApiOperation("busca una ruta por  su nombre o id ")
    @ApiResponses({
            @ApiResponse( code = 200, message = "Ruta encreada exitosamente", response = RutaDto.class ),
            @ApiResponse( code = 400, message = "Verificar  datos", response = Exception.class )
    })
    ResponseEntity<RutaDto> buscarRuta(@RequestParam String nombre,Integer id);


    @PatchMapping
    @CrossOrigin(origins = "console.firebase.google.com")
    @ApiOperation("Actualiza una ruta  ")
    @ApiResponses({
            @ApiResponse( code = 200, message = "Actualizacion exitosa", response = Ruta.class ),
            @ApiResponse( code = 400, message = "Verificar Datos", response = Exception.class )
    })
    Ruta actualizarRuta(@RequestBody RutaRequest parametros) throws Exception;


    @DeleteMapping
    @CrossOrigin(origins = "console.firebase.google.com")
    @ApiOperation("Elimina una ruta dado  su nombre o id ")
    @ApiResponses({
            @ApiResponse( code = 200, message = "eliminacion exitosa"),
            @ApiResponse( code = 400, message = "no se puede puede elimar por que esta ruta no existe", response = Exception.class )
    })
    void  elimarRuta(@RequestBody EliminarRutaRequest parametros) throws Exception;


    /**
    @GetMapping
    @CrossOrigin(origins = "console.firebase.google.com")
    @ApiOperation("lista  las rutas ")
    @ApiResponses({
            @ApiResponse( code = 200, message = "listada con exito", response = Ruta.class ),
            @ApiResponse( code = 400, message = "no se puede listar", response = Exception.class )
    })
    List<Ruta> listarRutas() ;
*/



}
