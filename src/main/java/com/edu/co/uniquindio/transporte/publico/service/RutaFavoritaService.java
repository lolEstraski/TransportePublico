package com.edu.co.uniquindio.transporte.publico.service;


import com.edu.co.uniquindio.transporte.publico.domain.Ruta;
import com.edu.co.uniquindio.transporte.publico.dto.RutaFavoritaRequest;
import com.edu.co.uniquindio.transporte.publico.repository.RutaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RutaFavoritaService {

    private RutaRepository rutaRepository;

    /** esta malo
    public Ruta AgregarRutaFavorita(RutaFavoritaRequest parametros) {

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
*/
}
