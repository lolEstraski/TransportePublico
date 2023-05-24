package com.edu.co.uniquindio.transporte.publico.service;

import com.edu.co.uniquindio.transporte.publico.domain.Parada;
import com.edu.co.uniquindio.transporte.publico.domain.Ruta;
import com.edu.co.uniquindio.transporte.publico.dto.EliminarRutaRequest;
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

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
    class RutaServiceTest {

    @Mock
    private RutaRepository rutaRepositoryMock;
    @Mock
    private HorarioRepository horarioRepositoryMock;

    @InjectMocks
    private RutaService rutaService;
    private com.edu.co.uniquindio.transporte.publico.domain.Ruta Ruta;



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

        when(rutaRepositoryMock.findById(idRuta)).thenReturn(Optional.of(rutaSimulada));
        RutaDto rutaDto = rutaService.buscarRuta(idRuta);

        assertNotNull(rutaDto);
        assertEquals(rutaSimulada.getId(), rutaDto.getId());
        assertEquals(rutaSimulada.getNombre(), rutaDto.getNombre());
        assertEquals(rutaSimulada.getSentido(), rutaDto.getSentido());
        assertEquals(rutaSimulada.getFrecuencia(), rutaDto.getFrecuencia());
    }



    @Test
    @DisplayName("DebeEliminarRutaExistente")
    void eliminarRutaEliminarExistente() {

        EliminarRutaRequest parametros = new EliminarRutaRequest();
        parametros.setId(1);

        Ruta rutaExistente = new Ruta();
        rutaExistente.setId(parametros.getId());

        when(rutaRepositoryMock.findById(parametros.getId())).thenReturn(Optional.of(rutaExistente));

        rutaService.eliminarRuta(parametros);
    }


    @Test
    @DisplayName("DebeRetornarListaDeRutas")
    void obtenerRutas() {
        // Arrange
        Ruta ruta1 = new Ruta();
        ruta1.setId(2);
        ruta1.setNombre("Ruta 1");
        ruta1.setFrecuencia(3);
        ruta1.setSentido("Ida");

        Ruta ruta2 = new Ruta();
        ruta2.setId(2);
        ruta2.setNombre("Ruta 2");
        ruta2.setFrecuencia(8);
        ruta2.setSentido("Vuelta");

        List<Ruta> rutas = Arrays.asList(ruta1, ruta2);

        when(rutaRepositoryMock.findAll()).thenReturn(rutas);

        List<Ruta> resultado = rutaService.obtenerRutas();
        assertEquals(rutas, resultado);
    }


    @Test
    @DisplayName("DebeRetornarListaDeRutasDto")
    void buscarRutas() {
        // Arrange
        String origen = "Origen";
        String destino = "Destino";

        RutaDto ruta1 = new RutaDto();
        ruta1.setId(2);
        ruta1.setNombre("Ruta 1");
        ruta1.setFrecuencia(3);
        ruta1.setSentido("Ida");

        RutaDto ruta2 = new RutaDto();
        ruta2.setId(2);
        ruta2.setNombre("Ruta 2");
        ruta2.setFrecuencia(8);
        ruta2.setSentido("Vuelta");
        List<RutaDto> rutas = Arrays.asList(ruta1, ruta2);

        when(rutaRepositoryMock.findByOrigenAndDestino(origen, destino)).thenReturn((rutas));
        List<RutaDto> resultado = rutaService.buscarRutas(origen, destino);
        assertEquals(rutas.size(), resultado.size());
    }


}


