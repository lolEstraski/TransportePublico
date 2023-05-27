package com.edu.co.uniquindio.transporte.publico.repository;


import com.edu.co.uniquindio.transporte.publico.domain.Ruta;
import com.edu.co.uniquindio.transporte.publico.dto.RutaDto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RutaRepository extends CrudRepository<Ruta, Integer> {

    Optional<Ruta> findByNombreOrId(String nombre, Integer id);

    List<RutaDto> findByNombre(String nombre);

    List<RutaDto> findByOrigenAndDestino(String origen, String destino);

    List<Ruta> findByPlataforma(boolean plataforma);






}
