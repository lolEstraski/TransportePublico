package com.edu.co.uniquindio.transporte.publico.service;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mail.javamail.JavaMailSender;

import javax.mail.Session;
import javax.mail.internet.MimeMessage;
import java.util.Properties;



@ExtendWith(MockitoExtension.class)
 class EmailServiceTests {

    @Mock
    private JavaMailSender javaMailSenderMock;

    @InjectMocks
    private EmailService emailService;


    @Test
    @DisplayName("Deberia enviar un email si los datos son correctos")
    void debeEnviarEmail(){
        //given
        var asuntoValido = "asunto";
        var contenidoValido = "Contenido valido";
        var destinatarioValido = "DestinatarioValido";
        //when
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.example.com");
        properties.put("mail.smtp.port", "25");
        Mockito.when(javaMailSenderMock.createMimeMessage()).thenReturn(new MimeMessage(Session.getDefaultInstance(properties)));
        var resultado = emailService.enviarEmail(asuntoValido, contenidoValido, destinatarioValido);
        //then
        Assertions.assertThat(resultado).isTrue();
    }

}


