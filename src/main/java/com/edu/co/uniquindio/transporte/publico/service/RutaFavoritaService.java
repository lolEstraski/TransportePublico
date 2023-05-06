package com.edu.co.uniquindio.transporte.publico.service;


import com.edu.co.uniquindio.transporte.publico.domain.Persona;
import com.edu.co.uniquindio.transporte.publico.domain.Ruta;
import com.edu.co.uniquindio.transporte.publico.dto.RutaFavoritaDto;
import com.edu.co.uniquindio.transporte.publico.repository.PasajeroRepository;
import com.edu.co.uniquindio.transporte.publico.repository.RutaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@AllArgsConstructor
public class RutaFavoritaService {

    private RutaRepository rutaRepository;

    private PasajeroRepository pasajeroRepository;


    public void agregarRutaFavorita(Integer idPersona, Integer idRuta) {
        Persona persona=pasajeroRepository.findById(idPersona).orElseThrow(() -> new EntityNotFoundException("No se pudo encontrar la persona con el ID: " + idPersona));
        Ruta ruta= rutaRepository.findById(idRuta).orElseThrow(() -> new EntityNotFoundException("No se pudo encontrar la persona con el ID: " + idRuta));
        List<Ruta> RutaFavorita=persona.getRutaFavorita();
        RutaFavorita.add(ruta);
        persona.setRutaFavorita(RutaFavorita);
        pasajeroRepository.save(persona);
    }






}
