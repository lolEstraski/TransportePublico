package com.edu.co.uniquindio.transporte.publico.repository;

import com.edu.co.uniquindio.transporte.publico.domain.Administrador;
import com.edu.co.uniquindio.transporte.publico.domain.Pasajero;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PasajeroRepository extends CrudRepository<Pasajero, Integer> {

    Optional<Pasajero> findByEmailAndPass(String email, String pass);
}
