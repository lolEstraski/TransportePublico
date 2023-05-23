package com.edu.co.uniquindio.transporte.publico.service;

import com.edu.co.uniquindio.transporte.publico.domain.Feedback;
import com.edu.co.uniquindio.transporte.publico.dto.FeedbackRequest;
import com.edu.co.uniquindio.transporte.publico.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedbackService {

    @Autowired
    private  FeedbackRepository feedbackRepository;
        public void processFeedback(FeedbackRequest feedbackRequest) {
            String customerName = feedbackRequest.getCustomerName();
            int accuracyRating = feedbackRequest.getAccuracyRating();
            String additionalComments = feedbackRequest.getAdditionalComments();

            Feedback feedback = new Feedback(customerName, accuracyRating, additionalComments);
            feedbackRepository.save(feedback);
        }
}

