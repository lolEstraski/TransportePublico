package com.edu.co.uniquindio.transporte.publico.controller;

import com.edu.co.uniquindio.transporte.publico.dto.LoginRequest;
import com.edu.co.uniquindio.transporte.publico.dto.PersonaDto;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


public interface IAdminController {

    @PostMapping
    @CrossOrigin(origins = "console.firebase.google.com")
    @ApiOperation("Para autenticar un usuario con nombre y contra")
    @ApiResponses({
            @ApiResponse( code = 200, message = "Login exitoso", response = PersonaDto.class ),
            @ApiResponse( code = 400, message = "Verificar credenciales", response = Exception.class )
    })
    ResponseEntity<PersonaDto> doLogin(@RequestBody LoginRequest credentials);
}
