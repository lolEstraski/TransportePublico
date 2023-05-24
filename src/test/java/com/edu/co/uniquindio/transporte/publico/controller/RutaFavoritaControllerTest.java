package com.edu.co.uniquindio.transporte.publico.controller;


import com.edu.co.uniquindio.transporte.publico.domain.Persona;
import com.edu.co.uniquindio.transporte.publico.domain.Ruta;
import com.edu.co.uniquindio.transporte.publico.domain.RutaFavorita;
import com.edu.co.uniquindio.transporte.publico.dto.RutaFavoritaDto;
import com.edu.co.uniquindio.transporte.publico.service.RutaFavoritaService;
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
 class RutaFavoritaControllerTest {


    @Mock
    RutaFavoritaService rutaFavoritaServiceMock;

    @InjectMocks
    RutaFavoritaController rutaFavoritaController;
    private MockMvc mockMvc;


    @BeforeEach
    public void init(){
        this.mockMvc = MockMvcBuilders.standaloneSetup(rutaFavoritaController)
                .build();
    }

    @Test
    @DisplayName("debe agregar una ruta favorita a una persona")
     void agregarRutaFavoritaTest() throws Exception {
        //given /dado que
        var  rutaFavoritaValida=new RutaFavoritaDto();
        rutaFavoritaValida.setIdRuta(1);
        rutaFavoritaValida.setIdPersona(2);
        // when / cuando
        var validIdRuta=(1);
        var validIdPersona=(2);
        var favoritaResponseValido = new RutaFavorita();
        var validPersona = new Persona();
        validPersona.setId(validIdPersona);
        var validRuta = new Ruta();
        validRuta.setId(validIdRuta);
        favoritaResponseValido.setId(1);
        favoritaResponseValido.setPersona(validPersona);
        favoritaResponseValido.setRuta(validRuta);

        Mockito.when(rutaFavoritaServiceMock.agregarRutaFavorita((validIdPersona),(validIdRuta))).thenReturn(favoritaResponseValido);

        //then / Entonces
        mockMvc.perform( MockMvcRequestBuilders
                        .post("/ruta/favorita")
                        .content(asJsonString(rutaFavoritaValida))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists());
    }


}
