package com.edu.co.uniquindio.transporte.publico.controller;



import com.edu.co.uniquindio.transporte.publico.domain.Parada;
import com.edu.co.uniquindio.transporte.publico.domain.Ruta;
import com.edu.co.uniquindio.transporte.publico.dto.*;
import com.edu.co.uniquindio.transporte.publico.exception.TPublicoException;
import com.edu.co.uniquindio.transporte.publico.service.RutaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController()
@RequestMapping("/ruta")
@AllArgsConstructor
public class RutaParadaControllerController implements IRutaParadaController {

    private RutaService rutaService;


    @Override
    public ResponseEntity<Ruta> crearRuta(RutaRequest parametros) {
        var ruta = rutaService.crearRuta(parametros) ;
        return ResponseEntity.ok(ruta);
    }


    @Override
    public ResponseEntity<RutaDto> buscarRuta( Integer id) {
        var ruta = rutaService.buscarRuta(id);
        return ResponseEntity.ok(ruta);

    }

    @Override
    public Ruta actualizarRuta(RutaRequest parametros) throws TPublicoException {
       return rutaService.actualizarRuta(parametros);
    }

    @Override
    public void elimarRuta(EliminarRutaRequest parametros)throws TPublicoException {
        rutaService.eliminarRuta(parametros);
    }

    @Override
    public List<Ruta> obtenerRutas() {
            return rutaService.obtenerRutas();
        }

    @Override
    public List<RutaDto> obtenerRutas( String origen,  String destino) {
        return rutaService.buscarRutas(origen, destino);
    }

    @Override
    public List<Ruta> buscarRutasConPlataforma() {
         return rutaService.buscarRutasConPlataforma(true);
        }

    @Override
    public RutaRequest buscarRutaPorId( Integer id){
        return rutaService.getInfoRuta(id);
    }

}
