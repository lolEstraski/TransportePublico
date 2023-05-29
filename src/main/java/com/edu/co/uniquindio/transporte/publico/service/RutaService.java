package com.edu.co.uniquindio.transporte.publico.service;


import com.edu.co.uniquindio.transporte.publico.domain.Horario;
import com.edu.co.uniquindio.transporte.publico.domain.Parada;
import com.edu.co.uniquindio.transporte.publico.domain.Ruta;
import com.edu.co.uniquindio.transporte.publico.dto.*;
import com.edu.co.uniquindio.transporte.publico.exception.ActualizarException;
import com.edu.co.uniquindio.transporte.publico.exception.TPublicoException;
import com.edu.co.uniquindio.transporte.publico.repository.HorarioRepository;
import com.edu.co.uniquindio.transporte.publico.repository.ParadaRepository;
import com.edu.co.uniquindio.transporte.publico.repository.RutaRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class RutaService {
    @Autowired
    private RutaRepository rutaRepository;

    @Autowired
    private ParadaRepository paradaRepository;

    private HorarioRepository horarioRepository;

    public Ruta crearRuta (RutaRequest parametros){

        Ruta rutaCreada = null;

        var ruta = rutaRepository.findByNombreOrId(parametros.getNombre(),null);
        if (ruta.isEmpty()) {
            var rutaNueva = new Ruta();
            rutaNueva.setFrecuencia(parametros.getFrecuencia());
            rutaNueva.setSentido(parametros.getSentido());
            rutaNueva.setOrigen(parametros.getOrigen());
            rutaNueva.setDestino(parametros.getDestino());
            rutaNueva.setPlataforma(parametros.isPlataforma());
            rutaNueva.setNombre(parametros.getNombre());
            rutaCreada = rutaRepository.save(rutaNueva);
            for (ParadaDto parada:
                 parametros.getParadas()) {
                var nuevaParada = new Parada();
                nuevaParada.setNombre(parada.getNombre());
                nuevaParada.setDireccion(parada.getDireccion());
                nuevaParada.setRuta(rutaCreada);
                paradaRepository.save(nuevaParada);
            }
        }
        return rutaCreada;
    }

    public RutaDto buscarRuta (Integer id){
        RutaDto rutaDto = null;
        var ruta = rutaRepository.findById( id);
        rutaDto = ruta.map( ruta1 ->  {
            var rutaTemporal = new RutaDto();
            rutaTemporal.setId(ruta1.getId());
            rutaTemporal.setNombre(ruta1.getNombre());
            rutaTemporal.setSentido(ruta1.getSentido());
            rutaTemporal.setFrecuencia(ruta1.getFrecuencia());
            return rutaTemporal;
        }).orElse(null);

        return rutaDto;
    }


    public Ruta actualizarRuta( RutaRequest parametros) throws  TPublicoException {
        Optional<Ruta> optionalRuta = rutaRepository.findByNombreOrId( null, parametros.getId());
        if (optionalRuta.isPresent()) {
            Ruta ruta = optionalRuta.get();
            ruta.setNombre(parametros.getNombre());
            ruta.setFrecuencia(parametros.getFrecuencia());
            ruta.setSentido(parametros.getSentido());
            ruta.setOrigen(parametros.getOrigen());
            ruta.setDestino(parametros.getDestino());
            var paradas = paradaRepository.findByIdRuta(ruta.getId());
            paradas.forEach(parada -> paradaRepository.delete(parada));
            var rutaEditada = rutaRepository.save(ruta);
            for (ParadaDto parada:
                    parametros.getParadas()) {
                var nuevaParada = new Parada();
                nuevaParada.setNombre(parada.getNombre());
                nuevaParada.setDireccion(parada.getDireccion());
                nuevaParada.setRuta(rutaEditada);
                paradaRepository.save(nuevaParada);
            }
            return rutaEditada;
        }else{
            throw new TPublicoException("la ruta no exite");
        }
    }

    public  void eliminarRuta (EliminarRutaRequest parametros) {
        var ruta = rutaRepository.findById(parametros.getId());
        ruta.ifPresent(ruta1 -> {
            var paradas = paradaRepository.findByIdRuta(ruta1.getId());
            paradas.forEach(parada -> paradaRepository.delete(parada));
            rutaRepository.delete(ruta1);
        });
    }

    public List<Ruta> obtenerRutas() {
        return (List<Ruta>) rutaRepository.findAll();
    }

    public List<RutaDto> buscarRutas(String origen, String destino) {
        return rutaRepository.findByOrigenAndDestino(origen, destino);
    }

    public List<RutaDto> buscarRutasNombre(String nombre) {
        return rutaRepository.findByNombre(nombre);
    }
    public List<Ruta> buscarRutasConPlataforma(boolean b) {
            return rutaRepository.findByPlataforma(true);
        }


    public RutaDto getInfoRuta(Integer rutaId) {
        RutaDto response = null;
       Ruta ruta= rutaRepository.findById(rutaId).orElse(null);
       //buscar horario de la ruta
        if(ruta != null) {
            response = new RutaDto();
            response.setNombre(ruta.getNombre());
            response.setOrigen(ruta.getOrigen());
            response.setSentido(ruta.getSentido());
            response.setDestino(ruta.getDestino());
            response.setId(ruta.getId());
            response.setFrecuencia(ruta.getFrecuencia());
            var paradas = paradaRepository.findByIdRuta(rutaId);
            List<String> paradaDtos = paradas.stream().map(Parada::getDireccion).collect(Collectors.toList());
            response.setParadas(paradaDtos);
        }
        return response;
    }

    public RutaRequest getParadsByRuta(Integer rutaId) {
        RutaRequest response = null;
        Ruta ruta= rutaRepository.findById(rutaId).orElse(null);
        //buscar horario de la ruta
        if(ruta != null) {
            response = new RutaRequest();
            response.setNombre(ruta.getNombre());
            response.setOrigen(ruta.getOrigen());
            response.setSentido(ruta.getSentido());
            response.setDestino(ruta.getDestino());
            response.setId(ruta.getId());
            response.setFrecuencia(ruta.getFrecuencia());
            var paradas = paradaRepository.findByIdRuta(rutaId);
            List<ParadaDto> paradaDtos = paradas.stream().map(RutaService::mapParadatoDto).collect(Collectors.toList());
            response.setParadas(paradaDtos);
        }
        return response;
    }

    public static ParadaDto mapParadatoDto(Parada parada){
        var paradaDto = new ParadaDto();
        paradaDto.setId(parada.getId());
        paradaDto.setNombre(parada.getNombre());
        paradaDto.setDireccion(parada.getDireccion());
        return paradaDto;
    }

}


