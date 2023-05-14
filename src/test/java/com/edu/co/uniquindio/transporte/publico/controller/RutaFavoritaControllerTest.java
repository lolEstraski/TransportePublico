package com.edu.co.uniquindio.transporte.publico.controller;


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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class RutaFavoritaControllerTest {


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
/**
    @Test
    @DisplayName("debe agregar una ruta favorita a una persona")
    public void agregarRutaFavoritaTest() throws Exception {
        //given /dado que
        var  rutaFavoritaValida=new RutaFavoritaDto();
        rutaFavoritaValida.setNombre("b1");
        rutaFavoritaValida.setDestino("centro");
        rutaFavoritaValida.setFrecuencia(15);
        rutaFavoritaValida.setIdRuta(1);
        rutaFavoritaValida.setIdPersona(2);
        // when / cuando
       var FavoritaResponseValido = new RutaFavoritaDto();
       var validIdRuta=(1);
       var validIdPersona=(2);
        FavoritaResponseValido.setIdPersona(validIdPersona);
        FavoritaResponseValido.setIdRuta(validIdRuta);

        Mockito.when(rutaFavoritaServiceMock.agregarRutaFavorita(eq(idPersona), eq(idRuta))).thenReturn(FavoritaResponseValido));

        //then / Entonces
        mockMvc.perform( MockMvcRequestBuilders
                        .post("/rutaFavorita")
                        .content(asJsonString(FavoritaResponseValido))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists());
    }
*/

}
