package com.edu.co.uniquindio.transporte.publico.controller;


import com.edu.co.uniquindio.transporte.publico.domain.Pasajero;
import com.edu.co.uniquindio.transporte.publico.domain.Ruta;
import com.edu.co.uniquindio.transporte.publico.dto.ActualizarContrasenaRequest;
import com.edu.co.uniquindio.transporte.publico.dto.ContrasenaRequest;
import com.edu.co.uniquindio.transporte.publico.dto.RegistrarPasajeroRequest;
import com.edu.co.uniquindio.transporte.publico.dto.RutaRequest;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface IPasajeroController {


    @PostMapping
    @CrossOrigin(origins = "console.firebase.google.com")
    @ApiOperation("Registrar Pasajeros")
    @ApiResponses({
            @ApiResponse( code = 200, message = "se registro con exito", response = Pasajero.class ),
            @ApiResponse( code = 400, message = "Verificar Datos", response = Exception.class )
    })
    Pasajero registrarPasajero(@RequestBody RegistrarPasajeroRequest parametros) ;

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

    @PatchMapping
    @PostMapping
    @CrossOrigin(origins = "console.firebase.google.com")
    @ApiOperation("Actualizar contraseña")
    @ApiResponses({
            @ApiResponse( code = 200, message = "Actualizacion exitosa", response = Pasajero.class ),
            @ApiResponse( code = 400, message = " No se pudo actualizar por favor verifica", response = Exception.class )
    })
    ResponseEntity<String> actualizarContrasena(@PathVariable Integer id,@RequestBody ActualizarContrasenaRequest parametros) throws Exception;


    RutaRequest obtenerInformacionRuta(@RequestBody String nombre)throws Exception;




}
