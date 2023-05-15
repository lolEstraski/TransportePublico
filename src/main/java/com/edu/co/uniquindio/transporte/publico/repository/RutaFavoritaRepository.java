package com.edu.co.uniquindio.transporte.publico.repository;


import com.edu.co.uniquindio.transporte.publico.domain.RutaFavorita;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RutaFavoritaRepository extends CrudRepository<RutaFavorita, Integer> {

    Optional<RutaFavorita> findByNombreOrId(String nombre, Integer id);

    @Query( value = "SELECT * FROM RUTAS_FAVORITAS r WHERE r.pasajero = ?1",
            nativeQuery = true)
    List<RutaFavorita> findByIdPersona(Integer idPersona);
}
