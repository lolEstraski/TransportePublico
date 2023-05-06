package com.edu.co.uniquindio.transporte.publico.repository;

import com.edu.co.uniquindio.transporte.publico.domain.Peticion;
import com.edu.co.uniquindio.transporte.publico.domain.Ruta;
import com.edu.co.uniquindio.transporte.publico.dto.RutaDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PeticionRepository  extends CrudRepository<Peticion, Integer> {

    Optional<Peticion> findByIdOrNombre(Integer id,String nombre);

    @Query(
            value = "SELECT * FROM PQRS pqr JOIN PASAJEROS pjs ON pjs.id = pqr.pasajero  WHERE pjs.nombre = ?1 ",
            nativeQuery = true)
    List<Peticion> listByNombrePasajero(String nombre);

    @Query(
            value = "SELECT * FROM PQRS pqr JOIN PASAJEROS pjs ON pjs.id = pqr.pasajero  WHERE pjs.email = ?1 ",
            nativeQuery = true)
    List<Peticion> listByEmailPasajero(String email);



}
