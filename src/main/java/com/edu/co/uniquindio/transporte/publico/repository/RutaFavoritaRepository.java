package com.edu.co.uniquindio.transporte.publico.repository;


import com.edu.co.uniquindio.transporte.publico.domain.RutaFavorita;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RutaFavoritaRepository extends CrudRepository<RutaFavorita, Integer> {


}
