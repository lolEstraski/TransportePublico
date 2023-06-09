package com.edu.co.uniquindio.transporte.publico.controller;


import com.edu.co.uniquindio.transporte.publico.domain.Persona;
import com.edu.co.uniquindio.transporte.publico.dto.ActualizarContrasenaRequest;
import com.edu.co.uniquindio.transporte.publico.dto.LoginRequest;
import com.edu.co.uniquindio.transporte.publico.dto.PersonaDto;
import com.edu.co.uniquindio.transporte.publico.exception.TPublicoException;
import com.edu.co.uniquindio.transporte.publico.service.LoginService;
import com.edu.co.uniquindio.transporte.publico.service.PasajeroService;
import lombok.AllArgsConstructor;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController()
@RequestMapping("/pasajero")
@CrossOrigin(origins = "http://127.0.0.1:5500/")
@AllArgsConstructor
public class PasajeroController implements IPasajeroController {

    @Autowired
    private PasajeroService pasajeroService;
    @Autowired
    private LoginService loginService;

    @Override
    public ResponseEntity<PersonaDto> doLogin(LoginRequest credentials) {
        var persona = loginService.doLogin(credentials);
        if( persona == null ){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(persona);
    }

    @Override
    public ResponseEntity<Persona> registrarPasajero(Persona persona) throws Exception {
       return ResponseEntity.ok(pasajeroService.registrarPasajero(persona));
    }

    @Override
    public ResponseEntity<String> actualizarContrasena(Integer id, ActualizarContrasenaRequest parametros) throws Exception {
        pasajeroService.actualizarContrasena(id, parametros.getPass(), parametros.getNuevaContrasena());
        return ResponseEntity.ok("Contraseña actualizada exitosamente.");
    }

    @Override
    public ResponseEntity<String> calificar(Integer calificacion , Integer id) throws  TPublicoException {
        pasajeroService.calificarfeedback(calificacion ,id);
        return ResponseEntity.ok("retroalimentacion exitosa.");
    }


    /**
    @Override
    public String recuperarContrasena(ContrasenaRequest parametros) {
        return pasajeroService.recuperarContrasena(parametros);
    }
    */
/**
    @Override
    public RutaRequest obtenerInformacionRuta(String nombre) throws Exception {
        return rutaService.obtenerInformacionRuta(nombre);
    }*/

}
