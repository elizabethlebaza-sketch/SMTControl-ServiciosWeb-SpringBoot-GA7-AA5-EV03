package com.smtcontrolweb.loginapiaa5ev01.controller;

import com.smtcontrolweb.loginapiaa5ev01.model.Usuario;
import com.smtcontrolweb.loginapiaa5ev01.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

// Esta clase controla las peticiones relacionadas con los usuarios
@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {

    // Servicio encargado de manejar las operaciones de usuarios
    private final UsuarioService usuarioService;

    // Constructor que recibe el servicio de usuarios
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    // Endpoint para registrar un nuevo usuario
    @PostMapping("/registro")
    public Usuario registrarUsuario(@RequestBody Usuario usuario) {
        return usuarioService.guardarUsuario(usuario);
    }

    // Endpoint para buscar un usuario por medio del correo
    @GetMapping("/buscar/{correo}")
    public Usuario buscarUsuario(@PathVariable String correo) {
        return usuarioService.buscarPorCorreo(correo);
    }

    // Endpoint para validar el inicio de sesión del usuario
    @PostMapping("/login")
    public String login(@RequestBody Usuario usuario) {

        // Busca el usuario en la base de datos utilizando el correo recibido
        Usuario usuarioEncontrado = usuarioService.buscarPorCorreo(usuario.getCorreo());

        // Verifica que el usuario exista y que la contraseña sea correcta
        if (usuarioEncontrado != null &&
                usuarioEncontrado.getContrasena().equals(usuario.getContrasena())) {

            return "Autenticación satisfactoria";
        }

        // Mensaje cuando los datos ingresados no coinciden
        return "Error en la autenticación";
    }
}