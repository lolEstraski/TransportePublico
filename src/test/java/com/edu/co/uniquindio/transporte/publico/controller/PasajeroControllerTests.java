package com.edu.co.uniquindio.transporte.publico.controller;

import com.edu.co.uniquindio.transporte.publico.domain.Persona;
import com.edu.co.uniquindio.transporte.publico.dto.ActualizarContrasenaRequest;
import com.edu.co.uniquindio.transporte.publico.service.PasajeroService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static com.edu.co.uniquindio.transporte.publico.controller.JsonUtil.asJsonString;
import static org.mockito.ArgumentMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class PasajeroControllerTests {

@Mock
private PasajeroService pasajeroServiceMock;

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
    public void registrarPasajeroTest() throws Exception {
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
        Mockito.when(pasajeroServiceMock.registrarPasajero(any())).thenReturn(RegistrarResponseValido);
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
        public void actualizarContrasenaTest() throws Exception {
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
        Mockito.verify(pasajeroServiceMock).actualizarContrasena(eq(1), eq("passwordAntigua"), eq("passwordNueva"));
    }







}
