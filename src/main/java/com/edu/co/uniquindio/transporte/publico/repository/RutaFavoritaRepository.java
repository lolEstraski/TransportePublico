package com.edu.co.uniquindio.transporte.publico.repository;


import com.edu.co.uniquindio.transporte.publico.domain.Ruta;
import com.edu.co.uniquindio.transporte.publico.domain.RutaFavorita;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RutaFavoritaRepository extends CrudRepository<RutaFavorita, Integer> {

    Optional<RutaFavorita> findByNombreOrId(String nombre, Integer id);

    @Modifying
    @Query(value = "DELETE FROM RUTAS_FAVORITAS r WHERE r.id_ruta=:idRuta AND r.id_pasajero=:idPasajero", nativeQuery = true)
    void deleteByRutaAndPasajero(Integer idRuta, Integer idPasajero);

}
