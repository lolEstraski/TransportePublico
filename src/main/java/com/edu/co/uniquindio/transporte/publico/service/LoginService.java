package com.edu.co.uniquindio.transporte.publico.service;

import com.edu.co.uniquindio.transporte.publico.dto.LoginRequest;
import com.edu.co.uniquindio.transporte.publico.dto.PersonaDto;
import com.edu.co.uniquindio.transporte.publico.dto.Rol;
import com.edu.co.uniquindio.transporte.publico.repository.AdministradorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LoginService {

    private AdministradorRepository administradorRepository;

    public PersonaDto doLogin(LoginRequest credentials) {
        PersonaDto personaDto = null;

        var admin = administradorRepository.findByEmailAndPass(credentials.getNombreUsuario(), credentials.getContrasena());
        personaDto = admin.map( administrador -> {
            var persona = new PersonaDto();
            persona.setId(administrador.getId());
            persona.setNombre(administrador.getNombre());
            persona.setCedula(administrador.getCedula());
            persona.setEmail(administrador.getEmail());
            persona.setRol(Rol.ADMIN);
            return persona;
        }).orElse(null);

        return personaDto;
    }
}
