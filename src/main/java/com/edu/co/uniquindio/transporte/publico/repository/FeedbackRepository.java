package com.edu.co.uniquindio.transporte.publico.repository;



import com.edu.co.uniquindio.transporte.publico.domain.Feedback;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepository extends CrudRepository<Feedback, Long> {



}
