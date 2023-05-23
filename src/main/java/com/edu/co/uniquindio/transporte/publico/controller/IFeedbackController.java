package com.edu.co.uniquindio.transporte.publico.controller;

import com.edu.co.uniquindio.transporte.publico.domain.Feedback;
import com.edu.co.uniquindio.transporte.publico.dto.FeedbackRequest;
import com.edu.co.uniquindio.transporte.publico.dto.LoginRequest;
import com.edu.co.uniquindio.transporte.publico.dto.PersonaDto;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface IFeedbackController {


    @PostMapping
    @CrossOrigin(origins = "console.firebase.google.com")
    @ApiOperation("Para retroalimentacion y calificacion de la  pagina")
    @ApiResponses({
            @ApiResponse(code = 200, message = "retroalimentacion exitosa", response = FeedbackRequest.class),
            @ApiResponse(code = 400, message = "verifica por favor ", response = Exception.class)
    })
    public ResponseEntity<String> submitFeedback(@RequestBody FeedbackRequest feedbackRequest);

}

