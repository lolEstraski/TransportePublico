package com.edu.co.uniquindio.transporte.publico.service;

import com.edu.co.uniquindio.transporte.publico.domain.Peticion;
import com.edu.co.uniquindio.transporte.publico.dto.PeticionRequest;
import com.edu.co.uniquindio.transporte.publico.repository.PeticionRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PeticionService {

    private PeticionRepository peticionRepository;

    public Peticion crearPeticion (PeticionRequest parametros){

        Peticion peticionCreada = null;

        var peticion = peticionRepository.findByIdOrNombre(null, parametros.getNombre());
        if (peticion.isEmpty()) {
            var peticionNueva = new Peticion();
            peticionNueva.setDescripcion(parametros.getDescripcion());
            peticionNueva.setTipo(parametros.getTipo());
            peticionNueva.setNombre(parametros.getNombre());
            peticionNueva.setEstado(parametros.getEstado());
            peticionNueva.setFecha(parametros.getFecha());
            peticionCreada = peticionRepository.save(peticionNueva);
        }
        return peticionCreada;
    }
}
