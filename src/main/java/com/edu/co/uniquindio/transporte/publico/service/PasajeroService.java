package com.edu.co.uniquindio.transporte.publico.service;

import com.edu.co.uniquindio.transporte.publico.domain.Persona;
import com.edu.co.uniquindio.transporte.publico.exception.TPublicoException;
import com.edu.co.uniquindio.transporte.publico.repository.PasajeroRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@AllArgsConstructor
public class PasajeroService {

    @Autowired
    private InMemoryUserDetailsManager inMemoryUserDetailsManager;

    @Autowired
    private PasajeroRepository pasajeroRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private EmailService emailService;


    public Persona registrarPasajero(Persona persona) throws TPublicoException {

        Persona pasajeroRegistrado;
        boolean correoExiste = esRepetido(persona.getEmail());
        if (correoExiste) {
            throw new TPublicoException("El Correo ya esta en Uso");
        }
        //cedula
        boolean cedulaExiste = cedulaRepetida(persona.getCedula());
        if (cedulaExiste) {
            throw new TPublicoException("La cedula ingresada ya existe");
        }
        var pasajeroRegistrar = new Persona();
        pasajeroRegistrar.setCedula(persona.getCedula());
        pasajeroRegistrar.setPass(persona.getPass());
        pasajeroRegistrar.setNombre(persona.getNombre());
        pasajeroRegistrar.setEmail(persona.getEmail());
        pasajeroRegistrar.setTelefono(persona.getTelefono());
        pasajeroRegistrado = pasajeroRepository.save(pasajeroRegistrar);
        var user = User.withUsername(pasajeroRegistrar.getEmail())
                .password(passwordEncoder.encode(persona.getPass()))
                .roles("USER")
                .build();
        inMemoryUserDetailsManager.createUser(user);
        emailService.enviarEmail("Registro de cuenta en Tpublico", "Hola " + pasajeroRegistrado.getNombre() + " es un gusto que haya registrado en TPublico, para activar su cuenta ingrese en el siguiente link: url", pasajeroRegistrado.getEmail());
        return pasajeroRegistrado;
    }

    boolean esRepetido(String email){
        return pasajeroRepository.findByEmail(email).orElse(null) != null;
    }
    boolean cedulaRepetida(Integer cedula) {
        return pasajeroRepository.existsById(cedula);
    }

    public void actualizarContrasena(Integer id, String contrasenaActual, String nuevaContrasena) throws TPublicoException {

        // Buscar al pasajero por el ID proporcionado
        Persona pasajero = buscarPorId(id);

        // Si no se encuentra el pasajero, lanzar una excepción de tipo PasajeroNoEncontradoException
        if (pasajero == null) {
            throw  new TPublicoException ("El pasajero con ID " + id + " no existe.");
        }
        // Verificar si la contraseña actual proporcionada en la solicitud coincide con la contraseña actual del pasajero
        if (!pasajero.getPass().equals(contrasenaActual)) {
            throw new TPublicoException("La contraseña actual no coincide.");
        }
        // Actualizar la contraseña del pasajero con la nueva contraseña proporcionada
        pasajero.setPass(nuevaContrasena);
        pasajeroRepository.save(pasajero);
    }


    public Persona buscarPorId(Integer id) throws TPublicoException {
        Optional<Persona> resultado = pasajeroRepository.findById(id);
        if (resultado.isPresent()) {
            return resultado.get();
        } else {
            throw new TPublicoException("No se encontró al pasajero con ID " + id);

        }
    }

    public void calificarfeedback(Integer calificacion, Integer id) throws TPublicoException {
      var persona=  buscarPorId(id) ;
      if (persona ==null){
          throw new TPublicoException(" no hay persona con dicho id");
      }
      if( calificacion <1 ||  calificacion>5){
          throw  new TPublicoException("la calificacion es del 1 al 5 no lo olvide");
      }
         persona.setCalificacion(calificacion);
        pasajeroRepository.save(persona);
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
