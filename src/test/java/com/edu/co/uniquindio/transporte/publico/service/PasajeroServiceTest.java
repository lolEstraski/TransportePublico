package com.edu.co.uniquindio.transporte.publico.service;


import com.edu.co.uniquindio.transporte.publico.repository.PasajeroRepository;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PasajeroServiceTest {

    @Mock
    private PasajeroRepository pasajeroRepositoryMock;


    @InjectMocks
    private PasajeroService pasajeroService;
}
