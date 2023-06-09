package com.edu.co.uniquindio.transporte.publico.repository;


import com.edu.co.uniquindio.transporte.publico.domain.Persona;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PasajeroRepository extends CrudRepository<Persona, Integer> {
    Optional<Persona> findByEmailAndPass(String email, String contrasena);
    Optional<Persona> findByEmail(String email);

}
