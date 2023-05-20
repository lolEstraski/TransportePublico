package com.edu.co.uniquindio.transporte.publico.controller;

import com.edu.co.uniquindio.transporte.publico.domain.Peticion;
import com.edu.co.uniquindio.transporte.publico.dto.PeticionRequest;
import com.edu.co.uniquindio.transporte.publico.service.PeticionService;
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

import java.util.Arrays;
import java.util.List;

import static com.edu.co.uniquindio.transporte.publico.controller.JsonUtil.asJsonString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class PeticionControllerTests {

    @Mock
    private PeticionService peticionServiceMock;

    @InjectMocks
    PeticionController peticionController;

    private MockMvc mockMvc;

    @BeforeEach
    public void init() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(peticionController).build();
    }


    @Test
    @DisplayName("debe crear una nueva peticion")
    public void crearPeticionTest() throws Exception {
        // given / dado que
        var peticionRequest = new PeticionRequest();
        peticionRequest.setTipo("Reclamacion");
        peticionRequest.setDescripcion("Descripción de la petición");
        peticionRequest.setNombre("reclamacion");
        peticionRequest.setEstado("Aceptada");
        // when / Cuando
        var peticionValida = new Peticion();
        var validId = 1;
        peticionValida.setId(validId);
        Mockito.when(peticionServiceMock.crearPeticion(any())).thenReturn(peticionValida);
        // then / Entonces
        mockMvc.perform(MockMvcRequestBuilders.post("/pqrs")
                        .content(asJsonString(peticionRequest))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists());
    }

    @Test
    @DisplayName("debe listar las peticiones por nombre de persona")
    public void listarPeticionesPorNombrePersonaTest() throws Exception {
        // given / dado que
        String nombre = "Juan";
        Peticion peticion1 = new Peticion();
        peticion1.setId(1);
        peticion1.setNombre("Juan");
        Peticion peticion2 = new Peticion();
        peticion2.setId(2);
        peticion2.setNombre("Juan");
        List<Peticion> peticiones = Arrays.asList(peticion1, peticion2);
        Mockito.when(peticionServiceMock.listarPeticionesPorNombrePsajero(eq(nombre))).thenReturn(peticiones);

        // when / cuando
        mockMvc.perform( MockMvcRequestBuilders
                        .get("/pqrs/nombre/Juan")
                        .content(asJsonString(peticiones))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[1].id").value(2));
    }




}
