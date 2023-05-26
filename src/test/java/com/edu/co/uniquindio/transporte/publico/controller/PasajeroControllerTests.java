package com.edu.co.uniquindio.transporte.publico.controller;

import com.edu.co.uniquindio.transporte.publico.domain.Persona;
import com.edu.co.uniquindio.transporte.publico.dto.ActualizarContrasenaRequest;
import com.edu.co.uniquindio.transporte.publico.dto.LoginRequest;
import com.edu.co.uniquindio.transporte.publico.dto.PersonaDto;
import com.edu.co.uniquindio.transporte.publico.exception.TPublicoException;
import com.edu.co.uniquindio.transporte.publico.service.LoginService;
import com.edu.co.uniquindio.transporte.publico.service.PasajeroService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static com.edu.co.uniquindio.transporte.publico.controller.JsonUtil.asJsonString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
 class PasajeroControllerTests {

@Mock
private PasajeroService pasajeroServiceMock;
@Mock
private LoginService loginServiceMock;



@InjectMocks
PasajeroController pasajeroController;

    private MockMvc mockMvc;

    @BeforeEach
    public void init(){
        this.mockMvc = MockMvcBuilders.standaloneSetup(pasajeroController)
                .build();
    }


    @Test
    @DisplayName("debe registrar a  un nuevo  usuario")
     void registrarPasajeroTest() throws Exception {
        //given /dado que
        var Personavalida= new Persona();
        Personavalida.setNombre("carlos");
        Personavalida.setPass("123452");
        Personavalida.setEmail("carlos1@gmail.com");
        Personavalida.setCedula(6351211);
        Personavalida.setTelefono("31123467");
        //when / Cuando
        var RegistrarResponseValido = new Persona();
        var validId = 1;
        var validNombre=("carlos");
        var valiPass=("123452");
        var valiEmail=("carlos1@gmail.com");
        var valiCedula=(6351211);
        var valiTelefono=("31123467");
        RegistrarResponseValido.setId(validId);
        RegistrarResponseValido.setNombre(validNombre);
        RegistrarResponseValido.setPass(valiPass);
        RegistrarResponseValido.setEmail(valiEmail);
        RegistrarResponseValido.setCedula(valiCedula);
        RegistrarResponseValido.setTelefono(valiTelefono);
        when(pasajeroServiceMock.registrarPasajero(any())).thenReturn(RegistrarResponseValido);
        //then / Entonces
        mockMvc.perform( MockMvcRequestBuilders
                        .post("/pasajero")
                        .content(asJsonString(RegistrarResponseValido))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists());
    }

    @Test
    @DisplayName("debe actualizar  la contraseña de un usuario")
         void actualizarContrasenaTest() throws Exception {
         // given
        ActualizarContrasenaRequest request = new ActualizarContrasenaRequest();
        request.setPass("passwordAntigua");
        request.setNuevaContrasena("passwordNueva");

        Mockito.doNothing().when(pasajeroServiceMock).actualizarContrasena(anyInt(), anyString(), anyString());

        // when
        mockMvc.perform(MockMvcRequestBuilders
                        .patch("/pasajero/1/contrasena")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(request)))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Contraseña actualizada exitosamente."));;


        // then
        Mockito.verify(pasajeroServiceMock).actualizarContrasena((1), ("passwordAntigua"), ("passwordNueva"));
    }

    @Test
    public void testDoLogin() {
        // Datos de prueba
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setNombreUsuario("andres");
        loginRequest.setContrasena("1234");
        PersonaDto personaDto = new PersonaDto();
        personaDto.setNombre("andres");
        personaDto.setContrasena("1234");



        when(loginServiceMock.doLogin(loginRequest)).thenReturn(personaDto);


        ResponseEntity<PersonaDto> response = pasajeroController.doLogin(loginRequest);


        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(personaDto, response.getBody());

    }

    @Test
    public void testDoLoginNullPersona() {
        // Datos de prueba
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setNombreUsuario("andres");
        loginRequest.setContrasena("1234");

        // Mockear el servicio para devolver null
        when(loginServiceMock.doLogin(loginRequest)).thenReturn(null);
        // Llamar al método del controlador
        ResponseEntity<PersonaDto> response = pasajeroController.doLogin(loginRequest);
        // Verificar el resultado
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals(null, response.getBody());

    }


    @Test
    public void testCalificar() throws TPublicoException {
        Integer calificacion = 4;
        Integer id = 123;
        ResponseEntity<String> response = pasajeroController.calificar(calificacion, id);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("retroalimentacion exitosa.", response.getBody());

    }




}
