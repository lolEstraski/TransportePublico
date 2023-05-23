package com.edu.co.uniquindio.transporte.publico.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class FeedbackRequest  implements Serializable {

    private String customerName;
    private int accuracyRating;
    private String additionalComments;
}
