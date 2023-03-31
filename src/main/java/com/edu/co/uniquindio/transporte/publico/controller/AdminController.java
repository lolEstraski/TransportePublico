package com.edu.co.uniquindio.transporte.publico.controller;

import com.edu.co.uniquindio.transporte.publico.service.LoginService;
import com.edu.co.uniquindio.transporte.publico.dto.LoginRequest;
import com.edu.co.uniquindio.transporte.publico.dto.PersonaDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/admin")
@AllArgsConstructor
public class AdminController implements IAdminController{

    private LoginService loginService;

    @Override
    public ResponseEntity<PersonaDto> doLogin(LoginRequest credentials) {
        var persona = loginService.doLogin(credentials);
        if( persona == null ){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(persona);
    }

}
