package com.edu.co.uniquindio.transporte.publico.service;


import com.edu.co.uniquindio.transporte.publico.domain.Ruta;
import com.edu.co.uniquindio.transporte.publico.dto.EliminarRutaRequest;
import com.edu.co.uniquindio.transporte.publico.dto.ListaRutaRequest;
import com.edu.co.uniquindio.transporte.publico.dto.RutaDto;
import com.edu.co.uniquindio.transporte.publico.dto.RutaRequest;
import com.edu.co.uniquindio.transporte.publico.repository.RutaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class RutaService {

    private RutaRepository rutaRepository;


    public Ruta crearRuta (RutaRequest parametros){

        Ruta rutaCreada = null;

        var ruta = rutaRepository.findByNombreOrId(parametros.getNombre(),null);
        if (ruta.isEmpty()) {
            var rutaNueva = new Ruta();
            rutaNueva.setFrecuencia(parametros.getFrecuencia());
            rutaNueva.setSentido(parametros.getSentido());
            rutaNueva.setNombre(parametros.getNombre());
            rutaCreada = rutaRepository.save(rutaNueva);
        }
        return rutaCreada;
    }

    public RutaDto buscarRuta (String nombre, Integer id){

        RutaDto rutaDto = null;
        var ruta = rutaRepository.findByNombreOrId(nombre, id);
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

    public Ruta actualizarRuta( RutaRequest parametros) throws Exception {
        Optional<Ruta> optionalRuta = rutaRepository.findByNombreOrId(parametros.getNombre(), null);
        if (optionalRuta.isPresent()) {
            Ruta ruta = optionalRuta.get();
            ruta.setNombre(parametros.getNombre());
            ruta.setFrecuencia(parametros.getFrecuencia());
            ruta.setSentido(parametros.getSentido());
            return rutaRepository.save(ruta);
        }else{
            throw new Exception("la ruta no exite");
        }
    }

    public  void eliminarRuta (EliminarRutaRequest parametros) {
        var ruta = rutaRepository.findById(parametros.getId());
        ruta.ifPresent(ruta1 -> rutaRepository.delete(ruta1));
    }


    public RutaDto buscarRutaEspecial (ListaRutaRequest parametros){

        RutaDto rutaDto = null;
        var ruta = rutaRepository.findByNombreOrId(nombre, id);
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
}


