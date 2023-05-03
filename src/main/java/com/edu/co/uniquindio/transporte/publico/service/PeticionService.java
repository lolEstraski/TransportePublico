package com.edu.co.uniquindio.transporte.publico.service;

import com.edu.co.uniquindio.transporte.publico.domain.Persona;
import com.edu.co.uniquindio.transporte.publico.domain.Peticion;
import com.edu.co.uniquindio.transporte.publico.dto.PeticionRequest;
import com.edu.co.uniquindio.transporte.publico.dto.RutaDto;
import com.edu.co.uniquindio.transporte.publico.repository.PasajeroRepository;
import com.edu.co.uniquindio.transporte.publico.repository.PeticionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PeticionService {

    private PeticionRepository peticionRepository;
    private PasajeroRepository pasajeroRepository;

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



    public List<Peticion> buscarPeticion(String nombre) {
        return  peticionRepository.findByNombre(nombre);

    }

    public List<Peticion> buscarPeticiones(String email, String nombre) throws Exception {
        Optional<Persona>correoExistePasajero = pasajeroRepository.findByEmail(email);
        if(correoExistePasajero.isEmpty()){
            throw new Exception("El correo ingresado no existe");
        }
        List<Peticion> pqrs = pasajeroRepository.findByNombre(nombre);
        pqrs.forEach(System.out::println);
        return pqrs;
    }


}
