package com.edu.co.uniquindio.transporte.publico.controller;


import com.edu.co.uniquindio.transporte.publico.domain.Persona;
import com.edu.co.uniquindio.transporte.publico.dto.*;
import com.edu.co.uniquindio.transporte.publico.exception.TPublicoException;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface IPasajeroController {


    @PostMapping( path = "/auth")
    @ApiOperation("Para autenticar un usuario con nombre y contra")
    @ApiResponses({
            @ApiResponse( code = 200, message = "Login exitoso", response = PersonaDto.class ),
            @ApiResponse( code = 400, message = "Verificar credenciales", response = Exception.class )
    })
    ResponseEntity<PersonaDto> doLogin(@RequestBody LoginRequest credentials);

    @PostMapping
    @CrossOrigin(origins = "*")
    @ApiOperation("Registrar Pasajeros")
    @ApiResponses({
            @ApiResponse( code = 200, message = "se registro con exito", response = Persona.class ),
            @ApiResponse( code = 400, message = "Verificar Datos", response = Exception.class )
    })
    ResponseEntity<Persona> registrarPasajero(@RequestBody Persona persona) throws Exception;

/**
    @PostMapping
    @CrossOrigin(origins = "console.firebase.google.com")
    @ApiOperation(" Recuperar contraseña")
    @ApiResponses({
            @ApiResponse( code = 200, message = " revisar su correo", response = Pasajero.class ),
            @ApiResponse( code = 400, message = "Verificar Datos", response = Exception.class )
    })
    String recuperarContrasena(@RequestBody ContrasenaRequest parametros);
*/

    @PatchMapping(path = "{id}/contrasena")
    @CrossOrigin(origins = "console.firebase.google.com")
    @ApiOperation("Actualizar contraseña")
    @ApiResponses({
            @ApiResponse( code = 200, message = "Actualizacion exitosa", response = Persona.class ),
            @ApiResponse( code = 400, message = " No se pudo actualizar por favor verifica", response = Exception.class )
    })
    ResponseEntity<String> actualizarContrasena(@PathVariable Integer id,@RequestBody ActualizarContrasenaRequest parametros) throws Exception;

    @PostMapping( path = "/calificar")
    @CrossOrigin(origins = "console.firebase.google.com")
    @ApiOperation("calificacion feedback")
    @ApiResponses({
            @ApiResponse( code = 200, message = "retroalimentacionexitosa", response = Persona.class ),
            @ApiResponse( code = 400, message = "Verificar", response = Exception.class )
    })

    ResponseEntity<String> calificar(@PathVariable Integer calificacion, Integer id) throws  TPublicoException;



}
