package com.edu.co.uniquindio.transporte.publico.repository;

import com.edu.co.uniquindio.transporte.publico.domain.Horario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface HorarioRepository extends CrudRepository<Horario,Integer> {

    @Query( value = "select * from HORARIOS h where h.idRuta =:idRuta"
    , nativeQuery = true)
    List<Horario> obtenerHorariosPorIdRuta(Integer idRuta);

    @Query( value = "select h.* from HORARIOS h join Rutas r on h.idRuta = r.id where r.nombre =:nombreRuta"
    , nativeQuery = true)
    List<Horario> obtenerHorariosPorNombreRuta(String nombreRuta);

}
