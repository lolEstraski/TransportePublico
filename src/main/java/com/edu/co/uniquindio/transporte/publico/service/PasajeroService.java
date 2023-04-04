package com.edu.co.uniquindio.transporte.publico.service;

import com.edu.co.uniquindio.transporte.publico.domain.Pasajero;
import com.edu.co.uniquindio.transporte.publico.dto.RegistrarPasajeroRequest;
import com.edu.co.uniquindio.transporte.publico.repository.PasajeroRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@AllArgsConstructor
public class PasajeroService {


    private PasajeroRepository pasajeroRepository;



    public Pasajero registrarPasajero(RegistrarPasajeroRequest parametros) {

            Pasajero pasajero = new Pasajero();
            pasajero.setCedula(parametros.getCedula());
            pasajero.setPass(parametros.getNombre());
            pasajero.setNombre(parametros.getNombre());
            pasajero.setEmail(parametros.getEmail());
            pasajero.setTelefono(parametros.getTelefono());
            return pasajeroRepository.save(pasajero);
        }

    public void actualizarContrasena(Integer id, String contrasenaActual, String nuevaContrasena) throws Exception {

        // Buscar al pasajero por el ID proporcionado
        Pasajero pasajero = buscarPorId(id);

        // Si no se encuentra el pasajero, lanzar una excepción de tipo PasajeroNoEncontradoException
        if (pasajero == null) {
            throw new Exception ("El pasajero con ID " + id + " no existe.");
        }
        // Verificar si la contraseña actual proporcionada en la solicitud coincide con la contraseña actual del pasajero
        if (!pasajero.getPass().equals(contrasenaActual)) {
            throw new Exception("La contraseña actual no coincide.");
        }
        // Actualizar la contraseña del pasajero con la nueva contraseña proporcionada
        pasajero.setPass(nuevaContrasena);
        pasajeroRepository.save(pasajero);
    }


    public Pasajero buscarPorId(Integer id) throws Exception {
        Optional<Pasajero> resultado = pasajeroRepository.findById(id);
        if (resultado.isPresent()) {
            return resultado.get();
        } else {
        throw new Exception("No se encontró al pasajero con ID " + id);

        }
    }




/**
    public String recuperarContrasena(ContrasenaRequest parametros) {

        Optional<Pasajero> optionalPasajero = pasajeroRepository.findByEmail(parametros.getEmail());
        Pasajero pasajero = new Pasajero();
        // Generar nueva contraseña aleatoria
        String nuevoPass = generarNuevoPass();

        // Actualizar la contraseña del pasajero en la base de datos
        pasajero.setPass(nuevoPass);
        pasajeroRepository.save(pasajero);

        // Enviar correo electrónico al pasajero con la nueva contraseña
        String mensaje = "Su nueva contraseña es: " + nuevoPass;
        enviarCorreoElectronico(pasajero.getPass(), "Recuperación de contraseña", mensaje);
        return nuevoPass;
    }

    private void enviarCorreoElectronico(String destinatario, String asunto, String mensaje) {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(destinatario);
        mail.setSubject(asunto);
        mail.setText(mensaje);
        javaMailSender.send(mail);
    }

    private String generarNuevoPass() {
        int length = 10;
        boolean useLetters = true;
        boolean useNumbers = true;
        String nuevaContrasena = RandomStringUtils.random(length, useLetters, useNumbers);
        return nuevaContrasena;
    }
 */


}
