package com.edu.co.uniquindio.transporte.publico.repository;

import com.edu.co.uniquindio.transporte.publico.domain.Peticion;
import com.edu.co.uniquindio.transporte.publico.domain.Ruta;
import com.edu.co.uniquindio.transporte.publico.dto.RutaDto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PeticionRepository  extends CrudRepository<Peticion, Integer> {

    Optional<Peticion> findByIdOrNombre(Integer id,String nombre);

    Optional<Peticion> findById( Integer id);


   // List<RutaDto> findByOrigenAndDestino(Integer id,String nombre);

}
