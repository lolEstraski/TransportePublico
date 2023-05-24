package com.edu.co.uniquindio.transporte.publico.service;


import com.edu.co.uniquindio.transporte.publico.domain.Peticion;
import com.edu.co.uniquindio.transporte.publico.repository.PeticionRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
 class PeticionServiceTest {


    @Mock
    private PeticionRepository peticionRepositoryMock;

    @InjectMocks
    private PeticionService peticionService;

/*
    @Test
    public void testCrearPeticion() {

        PeticionRequest parametros = new PeticionRequest();
        parametros.setNombre("nombre de la peticion");
        parametros.setDescripcion("descripcion de la peticion");
        parametros.setTipo("tipo de la peticion");
        parametros.setEstado("estado de la peticion");

        // Simular que no hay ninguna peticion con el mismo nombre en el repositorio
        when(peticionRepositoryMock.findByIdOrNombre(isNull(), eq(parametros.getNombre()))).thenReturn(Optional.empty());

        // Act
        PeticionService peticionService = new PeticionService(peticionRepositoryMock);
        Peticion peticionCreada = peticionService.crearPeticion(parametros);

        // Assert
        assertEquals(parametros.getNombre(), peticionCreada.getNombre());
        assertEquals(parametros.getDescripcion(), peticionCreada.getDescripcion());
        assertEquals(parametros.getTipo(), peticionCreada.getTipo());
        assertEquals(parametros.getEstado(), peticionCreada.getEstado());
    }
 */

    @Test
    @DisplayName("_deberia Retornar Lista De Peticiones Del Pasajero")
    void listarPeticionesPorNombrePasajero() {
        String nombre = "nombre del pasajero";

        List<Peticion> peticionesPasajero = new ArrayList<>();
        peticionesPasajero.add(new Peticion());
        peticionesPasajero.add(new Peticion());

        when(peticionRepositoryMock.listByNombrePasajero(nombre)).thenReturn(peticionesPasajero);

        PeticionService peticionService = new PeticionService(peticionRepositoryMock);
        List<Peticion> peticionesObtenidas = peticionService.listarPeticionesPorNombrePsajero(nombre);

        assertNotNull(peticionesObtenidas);
        assertEquals(peticionesPasajero.size(), peticionesObtenidas.size());


    }

    @Test
    @DisplayName("_deberia Retornar Lista Vacia")
    void noListarPeticionesPorNombrePasajero() {
        // Arrange
        String nombre = "nombre del pasajero";

        when(peticionRepositoryMock.listByNombrePasajero(nombre)).thenReturn(new ArrayList<>());

        PeticionService peticionService = new PeticionService(peticionRepositoryMock);
        List<Peticion> peticionesObtenidas = peticionService.listarPeticionesPorNombrePsajero(nombre);

        assertNotNull(peticionesObtenidas);
        assertTrue(peticionesObtenidas.isEmpty());

    }


    @Test
    @DisplayName("deberia Retornar Lista De Peticiones Del Pasajero")
    void buscarPeticiones() throws Exception {
        String email = "email del pasajero";

        List<Peticion> peticionesPasajero = new ArrayList<>();
        peticionesPasajero.add(new Peticion());
        peticionesPasajero.add(new Peticion());

        when(peticionRepositoryMock.listByEmailPasajero(email)).thenReturn(peticionesPasajero);

        PeticionService peticionService = new PeticionService(peticionRepositoryMock);
        List<Peticion> peticionesObtenidas = peticionService.buscarPeticiones(email);

        assertNotNull(peticionesObtenidas);
        assertEquals(peticionesPasajero.size(), peticionesObtenidas.size());

        verify(peticionRepositoryMock, times(1)).listByEmailPasajero(email);
    }
}