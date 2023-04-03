package com.edu.co.uniquindio.transporte.publico.controller;


import com.edu.co.uniquindio.transporte.publico.dto.LoginRequest;
import com.edu.co.uniquindio.transporte.publico.dto.PersonaDto;
import com.edu.co.uniquindio.transporte.publico.service.LoginService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController()
@RequestMapping("/pasajero")
@AllArgsConstructor
public class PasajeroController implements IPasajeroController {

    private LoginService loginService;





}
