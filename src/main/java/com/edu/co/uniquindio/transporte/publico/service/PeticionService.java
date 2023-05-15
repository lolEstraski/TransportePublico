package com.edu.co.uniquindio.transporte.publico.service;

import com.edu.co.uniquindio.transporte.publico.domain.Persona;
import com.edu.co.uniquindio.transporte.publico.domain.Peticion;
import com.edu.co.uniquindio.transporte.publico.dto.PeticionRequest;
import com.edu.co.uniquindio.transporte.publico.dto.RutaDto;
import com.edu.co.uniquindio.transporte.publico.repository.PasajeroRepository;
import com.edu.co.uniquindio.transporte.publico.repository.PeticionRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PeticionService {

    @Autowired
    private PeticionRepository peticionRepository;

    public Peticion crearPeticion (PeticionRequest parametros){

     Peticion peticionCreada=null;
        var peticion = peticionRepository.findByIdOrNombre(null, parametros.getNombre());
        if (peticion.isEmpty()) {
            var peticionNueva = new Peticion();
            peticionNueva.setDescripcion(parametros.getDescripcion());
            peticionNueva.setTipo(parametros.getTipo());
            peticionNueva.setNombre(parametros.getNombre());
            peticionNueva.setEstado(parametros.getEstado());
            LocalDateTime fecha = null;
            peticionNueva.setFecha(fecha);
            peticionCreada = peticionRepository.save(peticionNueva);
        }

        return peticionCreada;
    }

    public List<Peticion> listarPeticionesPorNombrePsajero(String nombre) {
        return  peticionRepository.listByNombrePasajero(nombre);

    }

    public List<Peticion> buscarPeticiones(String email) throws Exception {
        return  peticionRepository.listByEmailPasajero(email);
    }


}
