package com.edu.co.uniquindio.transporte.publico.service;

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


import static org.hamcrest.Matchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class RutaServiceTest {

    @Mock
    private RutaRepository rutaRepositoryMock;
    @Mock
    private HorarioRepository horarioRepositoryMock;

    @InjectMocks
    private RutaService rutaService;
    private com.edu.co.uniquindio.transporte.publico.domain.Ruta Ruta;

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

        when(rutaRepositoryMock.findById(idRuta)).thenReturn(Optional.of(rutaSimulada));
        RutaDto rutaDto = rutaService.buscarRuta(idRuta);

        assertNotNull(rutaDto);
        assertEquals(rutaSimulada.getId(), rutaDto.getId());
        assertEquals(rutaSimulada.getNombre(), rutaDto.getNombre());
        assertEquals(rutaSimulada.getSentido(), rutaDto.getSentido());
        assertEquals(rutaSimulada.getFrecuencia(), rutaDto.getFrecuencia());
    }

    /**
     * @Test public void testActualizarRuta() throws Exception {
     * <p>
     * Ruta rutaExistente = new Ruta();
     * rutaExistente.setNombre("ruta1");
     * rutaExistente.setFrecuencia(2);
     * rutaExistente.setSentido("vuelta");
     * rutaExistente.setDestino("norte");
     * rutaExistente.setOrigen("sur");
     * Optional<Ruta> optionalRuta = Optional.of(rutaExistente);
     * when(rutaRepositoryMock.findByNombreOrId(eq("ruta1"), isNull())).thenReturn(optionalRuta);
     * <p>
     * RutaRequest parametros = new RutaRequest();
     * parametros.setNombre("ruta1");
     * parametros.setFrecuencia(2);
     * parametros.setSentido("ida");
     * <p>
     * Ruta rutaActualizada = new Ruta();
     * rutaActualizada.setNombre("ruta2");
     * rutaActualizada.setFrecuencia(3);
     * rutaActualizada.setSentido("ida");
     * rutaActualizada.setDestino("sur");
     * rutaActualizada.setOrigen("norte");
     * when(rutaRepositoryMock.save(Ruta)).thenReturn(rutaActualizada);
     * <p>
     * Ruta resultado = rutaService.actualizarRuta(parametros);
     * <p>
     * verify(rutaRepositoryMock, times(1)).findByNombreOrId(eq("ruta1"), isNull());
     * verify(rutaRepositoryMock, times(1)).save(rutaExistente);
     * <p>
     * assertEquals(rutaActualizada, resultado);
     * }
     */


    @Test
    void eliminarRuta_DebeEliminarRutaExistente() {

        EliminarRutaRequest parametros = new EliminarRutaRequest();
        parametros.setId(1);

        Ruta rutaExistente = new Ruta();
        rutaExistente.setId(parametros.getId());

        when(rutaRepositoryMock.findById(parametros.getId())).thenReturn(Optional.of(rutaExistente));

        rutaService.eliminarRuta(parametros);
    }

    @Test
    void eliminarRuta_NoDebeHacerNadaSiRutaNoExiste() {
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
    void buscarRutas_DebeRetornarListaDeRutasDto() {
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
