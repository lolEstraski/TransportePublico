package com.edu.co.uniquindio.transporte.publico.controller;




import com.edu.co.uniquindio.transporte.publico.domain.Peticion;
import com.edu.co.uniquindio.transporte.publico.dto.PeticionRequest;
import com.edu.co.uniquindio.transporte.publico.dto.RutaDto;
import com.edu.co.uniquindio.transporte.publico.service.PeticionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/pqrs")
@AllArgsConstructor
public class PeticionController implements IPeticionController {

    @Autowired
    private PeticionService peticionService;

    @Override
    public ResponseEntity<Peticion> crearPeticion(PeticionRequest parametros) {
        var peticion = peticionService.crearPeticion(parametros) ;
        return ResponseEntity.ok(peticion);
    }

    @Override
    public List<Peticion> obtenerPeticion( String nombre) {
        List<Peticion> peticiones = peticionService.buscarPeticion(nombre);
        return peticiones;
    }

    @Override
    public List<Peticion> obtenerPeticionCorreo(String email,String nombre) throws Exception {
        List<Peticion> peticiones = peticionService.buscarPeticiones(email,nombre);
        return peticiones;
    }



}
