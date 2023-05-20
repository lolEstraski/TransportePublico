package com.edu.co.uniquindio.transporte.publico.service;


import com.edu.co.uniquindio.transporte.publico.domain.Persona;
import com.edu.co.uniquindio.transporte.publico.domain.Ruta;
import com.edu.co.uniquindio.transporte.publico.domain.RutaFavorita;
import com.edu.co.uniquindio.transporte.publico.dto.EliminarRutaFavoritaRequest;
import com.edu.co.uniquindio.transporte.publico.dto.RutaFavoritaDto;
import com.edu.co.uniquindio.transporte.publico.exception.TPublicoException;
import com.edu.co.uniquindio.transporte.publico.repository.PasajeroRepository;
import com.edu.co.uniquindio.transporte.publico.repository.RutaFavoritaRepository;
import com.edu.co.uniquindio.transporte.publico.repository.RutaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RutaFavoritaService {

    private RutaFavoritaRepository rutaFavoritaRepository;
    private RutaRepository rutaRepository;
    private PasajeroRepository pasajeroRepository;


    public RutaFavorita agregarRutaFavorita(Integer idPersona, Integer idRuta) throws TPublicoException {
        Persona persona=pasajeroRepository.findById(idPersona)
                .orElseThrow(() -> new TPublicoException("No se pudo encontrar la persona con el ID: " + idPersona));
        Ruta ruta= rutaRepository.findById(idRuta)
                .orElseThrow(() -> new TPublicoException("No se pudo encontrar la persona con el ID: " + idRuta));
        var rutaFavorita = new RutaFavorita();
        rutaFavorita.setRuta(ruta);
        rutaFavorita.setPersona(persona);
        rutaFavorita.setNombre(ruta.getNombre());
        return rutaFavoritaRepository.save(rutaFavorita);
    }


    public RutaFavoritaDto buscarRutaFavorita(String nombre, Integer id) {
        RutaFavoritaDto rutaFavoritaDto = null;
        var ruta = rutaFavoritaRepository.findByNombreOrId(nombre, id);
        rutaFavoritaDto = ruta.map( ruta1 ->  {
            var rutaFavoritaTemporal = new RutaFavoritaDto();
            rutaFavoritaTemporal.setIdRuta(rutaFavoritaTemporal.getIdRuta());
            rutaFavoritaTemporal.setNombre(rutaFavoritaTemporal.getNombre());
            rutaFavoritaTemporal.setSentido(rutaFavoritaTemporal.getSentido());
            rutaFavoritaTemporal.setFrecuencia(rutaFavoritaTemporal.getFrecuencia());
            rutaFavoritaTemporal.setDestino(rutaFavoritaTemporal.getDestino());

            return rutaFavoritaTemporal;
        }).orElse(null);
        return rutaFavoritaDto;
    }

    public void eliminarRutaFavorita(EliminarRutaFavoritaRequest parametros) {
        var ruta = rutaFavoritaRepository.findById(parametros.getId());
        ruta.ifPresent(ruta1 -> rutaFavoritaRepository.delete(ruta1));
    }

    public List<RutaFavorita> obtenerRutasFavoritasPorPersona(Integer idPersona) {
        return rutaFavoritaRepository.findByIdPersona(idPersona);
    }

}
