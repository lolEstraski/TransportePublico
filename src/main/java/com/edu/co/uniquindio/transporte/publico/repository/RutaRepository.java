package com.edu.co.uniquindio.transporte.publico.repository;


import com.edu.co.uniquindio.transporte.publico.domain.Administrador;
import com.edu.co.uniquindio.transporte.publico.domain.Ruta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RutaRepository extends CrudRepository<Ruta, Integer> {


    Optional<Ruta> findByNombreOrId(String nombre, Integer id);


}
