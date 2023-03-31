package com.edu.co.uniquindio.transporte.publico.repository;

import com.edu.co.uniquindio.transporte.publico.domain.Administrador;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdministradorRepository extends CrudRepository<Administrador, Long> {

    Optional<Administrador> findByEmailAndPass(String email, String pass);
}
