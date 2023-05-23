package com.edu.co.uniquindio.transporte.publico.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity( name = "feedback")
@Data
@NoArgsConstructor

public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerName;
    private int accuracyRating;
    private String additionalComments;

    @ManyToOne
    @JoinColumn(name = "pasajero", referencedColumnName = "id")
    private Persona persona;


    public Feedback(String customerName, int accuracyRating, String additionalComments) {

    }
}