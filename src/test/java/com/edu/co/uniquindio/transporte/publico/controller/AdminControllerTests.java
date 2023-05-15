package com.edu.co.uniquindio.transporte.publico.controller;


import com.edu.co.uniquindio.transporte.publico.dto.LoginRequest;
import com.edu.co.uniquindio.transporte.publico.dto.PersonaDto;
import com.edu.co.uniquindio.transporte.publico.service.LoginService;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class AdminControllerTests {

    @Mock
    private LoginService loginServiceMock;

    @InjectMocks
    private AdminController adminController;

    private MockMvc mockMvc;

    @BeforeEach
    public void init(){
        this.mockMvc = MockMvcBuilders.standaloneSetup(adminController)
                .build();
    }

    @Test
    @DisplayName("Debe conectar un admin si las credenciales son validas")
    public void doLoginTest() throws Exception{
        //Given / Dado que
        var loginRequestValido = new LoginRequest();
        loginRequestValido.setContrasena("Valida");
        loginRequestValido.setNombreUsuario("usuario-valido");
        //when / Cuando
        var loginResponseValido = new PersonaDto();
        var validId = 1;
        loginResponseValido.setId(validId);
        Mockito.when(loginServiceMock.doLogin(any())).thenReturn(loginResponseValido);
        //then / Entonces
        mockMvc.perform( MockMvcRequestBuilders
                        .post("/admin")
                        .content(asJsonString(loginRequestValido))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists());
    }

    @Test
    @DisplayName("No debe conectar un admin si las credenciales son incorrectas")
    public void doLoginTestFail() throws Exception{
        //Given / Dado que
        var loginRequestValido = new LoginRequest();
        loginRequestValido.setContrasena("no valida");
        loginRequestValido.setNombreUsuario("usuario-no-valido");
        //when / Cuando
        Mockito.when(loginServiceMock.doLogin(any())).thenReturn(null);
        //then / Entonces
        mockMvc.perform( MockMvcRequestBuilders
                        .post("/admin")
                        .content(asJsonString(loginRequestValido))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }



}
