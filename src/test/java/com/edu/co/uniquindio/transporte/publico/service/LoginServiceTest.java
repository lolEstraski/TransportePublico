package com.edu.co.uniquindio.transporte.publico.service;


import com.edu.co.uniquindio.transporte.publico.controller.AdminController;
import com.edu.co.uniquindio.transporte.publico.domain.Administrador;
import com.edu.co.uniquindio.transporte.publico.dto.LoginRequest;
import com.edu.co.uniquindio.transporte.publico.dto.PersonaDto;
import com.edu.co.uniquindio.transporte.publico.dto.Rol;
import com.edu.co.uniquindio.transporte.publico.repository.AdministradorRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Optional;

import static com.edu.co.uniquindio.transporte.publico.controller.JsonUtil.asJsonString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class LoginServiceTest {


    @Mock
    private AdministradorRepository administradorRepositoryMock;

    @InjectMocks
    private  LoginService loginService;


    @Test
    public void testDoLogin() throws Exception {
        //Given / Dado que
        LoginRequest request = new LoginRequest();
        request.setNombreUsuario("admin");
        request.setContrasena("password");

        Administrador administrador = new Administrador();
        administrador.setId(1);
        administrador.setNombre("Admin");
        administrador.setCedula("123456789");
        administrador.setEmail("admin@test.com");
        administrador.setPass("password");

        when(administradorRepositoryMock.findByEmailAndPass(any(), any())).thenReturn(Optional.of(administrador));
        var resultado =loginService.doLogin(request);

        Assertions.assertThat(resultado.getId()).isEqualTo(1);
        Assertions.assertThat(resultado.getNombre()).isEqualTo("Admin");
        Assertions.assertThat(resultado.getEmail()).isEqualTo("admin@test.com");
        Assertions.assertThat(resultado.getContrasena()).isNull();

    }

}
