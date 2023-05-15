package com.edu.co.uniquindio.transporte.publico.service;

import com.edu.co.uniquindio.transporte.publico.domain.Ruta;
import com.edu.co.uniquindio.transporte.publico.dto.RutaRequest;
import com.edu.co.uniquindio.transporte.publico.repository.HorarioRepository;
import com.edu.co.uniquindio.transporte.publico.repository.RutaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class RutaServiceTest {

    @Mock
    private RutaRepository rutaRepositoryMock;
    @Mock
    private HorarioRepository horarioRepositoryMock;

    @InjectMocks
    private RutaService rutaService;

    @Test
    void crearRuta_deberiaCrearUnaRutaSiNoExisteOtraConElMismoNombre() {

        RutaRequest parametros = new RutaRequest();
        parametros.setNombre("nombre de la ruta");
        parametros.setFrecuencia(2);
        parametros.setSentido("sentido de la ruta");


        when(rutaRepositoryMock.findByNombreOrId(parametros.getNombre(), null)).thenReturn(Optional.empty());

        RutaService rutaService = new RutaService(rutaRepositoryMock);
        Ruta rutaCreada = rutaService.crearRuta(parametros);

        assertNotNull(rutaCreada);
        assertEquals(parametros.getNombre(), rutaCreada.getNombre());
        assertEquals(parametros.getFrecuencia(), rutaCreada.getFrecuencia());
        assertEquals(parametros.getSentido(), rutaCreada.getSentido());
    }


}
