package com.edu.co.uniquindio.transporte.publico.repository;

import com.edu.co.uniquindio.transporte.publico.domain.Horario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HorarioRepository extends CrudRepository<Horario,Integer> {

    Optional<Horario> findById(Integer id);

    @Query("select h from HORARIO h where h.listaRutaHorarioH =: idRuta")
    List<Horario> obtenerListaHorarios(String nombreRuta);

    Horario findBynombre(String nombreRuta);

}
