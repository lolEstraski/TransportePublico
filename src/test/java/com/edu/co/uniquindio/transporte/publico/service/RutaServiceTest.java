package com.edu.co.uniquindio.transporte.publico.service;

import com.edu.co.uniquindio.transporte.publico.domain.Ruta;
import com.edu.co.uniquindio.transporte.publico.dto.RutaDto;
import com.edu.co.uniquindio.transporte.publico.dto.RutaRequest;
import com.edu.co.uniquindio.transporte.publico.repository.HorarioRepository;
import com.edu.co.uniquindio.transporte.publico.repository.RutaRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;


import static org.hamcrest.Matchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class RutaServiceTest {

    @Mock
    private RutaRepository rutaRepositoryMock;
    @Mock
    private HorarioRepository horarioRepositoryMock;

    @InjectMocks
    private RutaService rutaService;

    /**
     * @Test
     * @DisplayName("CrearUnaRutaSiNoExisteOtraConElMismoNombre") void crearRutaTest() {
     * <p>
     * RutaRequest parametros = new RutaRequest();
     * parametros.setNombre("nombre de la ruta");
     * parametros.setFrecuencia(2);
     * parametros.setSentido("sentido de la ruta");
     * <p>
     * <p>
     * when(rutaRepositoryMock.findByNombreOrId(parametros.getNombre(), null)).thenReturn(Optional.empty());
     * <p>
     * RutaService rutaService =new RutaService();
     * Ruta rutaCreada = rutaService.crearRuta(parametros);
     * <p>
     * assertNotNull(rutaCreada);
     * assertEquals(parametros.getNombre(), rutaCreada.getNombre());
     * assertEquals(parametros.getFrecuencia(), rutaCreada.getFrecuencia());
     * assertEquals(parametros.getSentido(), rutaCreada.getSentido());
     * }
     */

    @Test
    @DisplayName("_deberia Retornar RutaDto Cuando SeEncuentra LaRuta")
    void buscarRuta() {

        String nombreRuta = "2E";
        Integer idRuta = 1;

        Ruta rutaSimulada = new Ruta();
        rutaSimulada.setId(idRuta);
        rutaSimulada.setNombre(nombreRuta);
        rutaSimulada.setSentido("sentido de la ruta");
        rutaSimulada.setFrecuencia(312);

        when(rutaRepositoryMock.findByNombreOrId(nombreRuta, idRuta)).thenReturn(Optional.of(rutaSimulada));
        RutaDto rutaDto = rutaService.buscarRuta(nombreRuta, idRuta);

        assertNotNull(rutaDto);
        assertEquals(rutaSimulada.getId(), rutaDto.getId());
        assertEquals(rutaSimulada.getNombre(), rutaDto.getNombre());
        assertEquals(rutaSimulada.getSentido(), rutaDto.getSentido());
        assertEquals(rutaSimulada.getFrecuencia(), rutaDto.getFrecuencia());
    }



    @Test
    void actualizarRuta_deberiaLanzarExcepcionSiLaRutaNoExiste() {

        RutaRequest parametros = new RutaRequest();
        parametros.setNombre("nombre de la ruta");
        parametros.setFrecuencia(4);
        parametros.setSentido("nuevo sentido");
        when(rutaRepositoryMock.findByNombreOrId(parametros.getNombre(), null)).thenReturn(Optional.empty());

        Exception exception = assertThrows(Exception.class, () -> {
            rutaService.actualizarRuta(parametros);
        });

        assertEquals("la ruta no existe", exception.getMessage());

    }

}
