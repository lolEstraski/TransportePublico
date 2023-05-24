package com.edu.co.uniquindio.transporte.publico.service;


import com.edu.co.uniquindio.transporte.publico.domain.Persona;
import com.edu.co.uniquindio.transporte.publico.repository.PasajeroRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.Optional;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
 class PasajeroServiceTest {

    @Mock
    private PasajeroRepository pasajeroRepositoryMock;

    @Mock
    private EmailService emailServiceMock;


    @InjectMocks
    private PasajeroService pasajeroService;


    @Test
    @DisplayName("debe Registrar un Pasajero ")
    void testRegistrarPasajero() throws Exception {
        Persona persona = new Persona();
        persona.setCedula(123456789);
        persona.setNombre("Juan Perez");
        persona.setEmail("juan.perez@test.com");
        persona.setTelefono("1234567");

        when(pasajeroRepositoryMock.save(any())).thenReturn(persona);
        Persona pasajeroRegistrado = pasajeroService.registrarPasajero(persona);
        // Verificación de resultados
        assertNotNull(pasajeroRegistrado);
        assertEquals(persona.getCedula(), pasajeroRegistrado.getCedula());
        assertEquals(persona.getNombre(), pasajeroRegistrado.getNombre());
        assertEquals(persona.getEmail(), pasajeroRegistrado.getEmail());
        assertEquals(persona.getTelefono(), pasajeroRegistrado.getTelefono());
    }


    @Test
    @DisplayName("verifica si el email es repetido ")
     void testEsRepetidoTrue() {
        String email = "pedro@gmail.com";

        Persona persona = new Persona();
        persona.setEmail(email);
        when(pasajeroRepositoryMock.findByEmail(email)).thenReturn(Optional.of(persona));

        boolean resultado = pasajeroService.esRepetido(email);
        assertTrue(resultado);
        verify(pasajeroRepositoryMock).findByEmail((email));

    }
    @Test
    @DisplayName("cuando el email es reptido manda una excepcion")
     void testEsRepetidoFalse() {
        String email = "pedro@gmail.com";
        when(pasajeroRepositoryMock.findByEmail(email)).thenReturn(Optional.empty());
        boolean resultado = pasajeroService.esRepetido(email);
        assertFalse(resultado);
        verify(pasajeroRepositoryMock).findByEmail((email));
    }

    @Test
     void testCedulaRepetidaTrue() {
        Integer cedula = 123456789;

        Persona persona = new Persona();
        persona.setCedula(cedula);
        when(pasajeroRepositoryMock.existsById(cedula)).thenReturn(true);

        boolean resultado = pasajeroService.cedulaRepetida(Integer.valueOf(cedula));
        assertTrue(resultado);
    }

    @Test
     void testCedulaRepetidaFalse() {
        Integer cedula = 123456789;
        when(pasajeroRepositoryMock.existsById(cedula)).thenReturn(false);
        boolean resultado = pasajeroService.cedulaRepetida(cedula);

        assertFalse(resultado);

    }


    @Test
     void buscarPorId_personaExiste_retornaPersona() throws Exception {

        Persona persona = new Persona();
        persona.setId(1);
        persona.setNombre("pedro");
        persona.setEmail("pedro@gmail.com");
        persona.setTelefono("123456789");

        when(pasajeroRepositoryMock.findById(any())).thenReturn(Optional.of(persona));

        persona = pasajeroRepositoryMock.save(persona);
        Integer id =1;


        Persona resultado = pasajeroService.buscarPorId(id);
        assertNotNull(resultado);
        assertEquals("pedro", resultado.getNombre());
        assertEquals("pedro@gmail.com", resultado.getEmail());
        assertEquals("123456789", resultado.getTelefono());
    }

    @Test
     void buscarPorId_personaNoExiste_lanzaExcepcion() {

        when(pasajeroRepositoryMock.findById(anyInt())).thenReturn(Optional.empty());
        assertThrows(Exception.class, () -> pasajeroService.buscarPorId(1));

    }

    @Test
    void actualizarContrasena_pasajeroExisteYContrasenaActualCorrecta_actualizaContrasena() throws Exception {
        Persona persona = new Persona();
        persona.setId(1);
        persona.setPass("contrasenaActual");
        when(pasajeroRepositoryMock.findById(anyInt())).thenReturn(Optional.of(persona));

        pasajeroService.actualizarContrasena(1, "contrasenaActual", "nuevaContrasena");

        verify(pasajeroRepositoryMock).findById(1);

        verify(pasajeroRepositoryMock).save((persona));
        assertEquals("nuevaContrasena", persona.getPass());
    }

    @Test
    void actualizarContrasena_pasajeroNoExiste_lanzaExcepcion() throws Exception {
        when(pasajeroRepositoryMock.findById(anyInt())).thenReturn(Optional.empty());
        assertThrows(Exception.class, () -> pasajeroService.actualizarContrasena(1, "contrasenaActual", "nuevaContrasena"));
        verify(pasajeroRepositoryMock, never()).save(any(Persona.class));
    }

    @Test
    void actualizarContrasena_contrasenaActualIncorrecta_lanzaExcepcion() throws Exception {
        Persona persona = new Persona();
        persona.setId(1);
        persona.setPass("contrasenaActual");
        when(pasajeroRepositoryMock.findById(anyInt())).thenReturn(Optional.of(persona));
        assertThrows(Exception.class, () -> pasajeroService.actualizarContrasena(1, "otraContrasena", "nuevaContrasena"));
        verify(pasajeroRepositoryMock, never()).save(any(Persona.class));
    }


    @Test
     void testCalificarFeedback() throws Exception {

        Integer calificacion = 4;
        Integer id = 1;
        Persona persona = new Persona();
        persona.setId(id);
        persona.setCalificacion(calificacion);

        when(pasajeroService.buscarPorId(id)).thenReturn(persona);

        pasajeroService.calificarfeedback(calificacion, id);

        Assertions.assertEquals(calificacion, persona.getCalificacion());

    }
}
