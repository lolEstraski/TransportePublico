package com.edu.co.uniquindio.transporte.publico.controller;


import com.edu.co.uniquindio.transporte.publico.domain.Ruta;
import com.edu.co.uniquindio.transporte.publico.dto.EliminarRutaRequest;
import com.edu.co.uniquindio.transporte.publico.dto.RutaDto;
import com.edu.co.uniquindio.transporte.publico.dto.RutaRequest;
import com.edu.co.uniquindio.transporte.publico.service.RutaService;
import com.google.api.gax.rpc.ClientStream;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<RutaDto> buscarRuta(String nombre, Integer id) {
        var ruta = rutaService.buscarRuta(nombre,id);
        return ResponseEntity.ok(ruta);

    }

    @Override
    public Ruta actualizarRuta(RutaRequest parametros) throws Exception {
       return rutaService.actualizarRuta(parametros);
    }

    @Override
    public void elimarRuta(EliminarRutaRequest parametros) throws Exception {
        rutaService.eliminarRuta(parametros);
    }

    /**
     *
     * @return

    @Override
    public List<Ruta> listarRutas() {
            return rutaService.listarRutas();
        }
     */



}
