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
      @DisplayName("CrearUnaRutaSiNoExisteOtraConElMismoNombre")
      void crearRutaTest() {

      RutaRequest parametros = new RutaRequest();
      parametros.setNombre("nombre de la ruta");
      parametros.setFrecuencia(2);
      parametros.setSentido("sentido de la ruta");

     when(rutaRepositoryMock.findByNombreOrId(parametros.getNombre(), null)).thenReturn(Optional.empty());

      RutaService rutaService =new RutaService();
      Ruta rutaCreada = rutaService.crearRuta(parametros);
      assertNotNull(rutaCreada);
      assertEquals(parametros.getNombre(), rutaCreada.getNombre());
      assertEquals(parametros.getFrecuencia(), rutaCreada.getFrecuencia());
      assertEquals(parametros.getSentido(), rutaCreada.getSentido());
      }


    @Test
    @DisplayName("crear ruta")
     void testCrearRuta() {
        when(rutaRepositoryMock.findByNombreOrId(anyString(), any())).thenReturn(Optional.empty());

        RutaRequest parametros = new RutaRequest();
        parametros.setNombre("nombre");
        parametros.setFrecuencia(10);
        parametros.setSentido("sentido");
        parametros.setOrigen("origen");
        parametros.setDestino("destino");

        Ruta rutaCreada = rutaService.crearRuta(parametros);

   
        assertEquals("nombre", rutaCreada.getNombre());

    }


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
    @DisplayName("Actualiza la ruta")
     void testActualizarRuta() throws Exception {
        Ruta ruta = new Ruta();
        ruta.setNombre("nombre");
        ruta.setFrecuencia(5);
        ruta.setSentido("sentido");
        ruta.setOrigen("origen");
        ruta.setDestino("destino");

        when(rutaRepositoryMock.findByNombreOrId(anyString(), any())).thenReturn(Optional.of(ruta));

        RutaRequest parametros = new RutaRequest();
        parametros.setNombre("nombre");
        parametros.setFrecuencia(10);
        parametros.setSentido("sentido");
        parametros.setOrigen("origen");
        parametros.setDestino("destino");

        Ruta rutaActualizada = rutaService.actualizarRuta(parametros);

        assertEquals("nombre", rutaActualizada.getNombre());

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
    @DisplayName("NoDebeHacerNadaSiRutaNoExiste")
    void eliminarRutaNoExiste() {
        // Arrange
        EliminarRutaRequest parametros = new EliminarRutaRequest();
        parametros.setId(1);
        when(rutaRepositoryMock.findById(parametros.getId())).thenReturn(Optional.empty());

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


