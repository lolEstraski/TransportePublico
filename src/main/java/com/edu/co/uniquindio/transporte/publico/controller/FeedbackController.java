package com.edu.co.uniquindio.transporte.publico.controller;

import com.edu.co.uniquindio.transporte.publico.domain.Feedback;
import com.edu.co.uniquindio.transporte.publico.dto.FeedbackRequest;
import com.edu.co.uniquindio.transporte.publico.service.FeedbackService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/feedback")
@AllArgsConstructor
public class FeedbackController  implements IFeedbackController{


    @Autowired
    FeedbackService feedbackService;

    @Override
    public ResponseEntity<String> submitFeedback(FeedbackRequest feedbackRequest) {
        feedbackService.processFeedback(feedbackRequest);
        return ResponseEntity.ok("Retroalimentación recibida correctamente. ¡Gracias por tu opinión!");
    }
}
