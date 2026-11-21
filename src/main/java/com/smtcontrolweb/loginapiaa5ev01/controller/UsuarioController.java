package com.smtcontrolweb.loginapiaa5ev01.controller;

import com.smtcontrolweb.loginapiaa5ev01.model.Usuario;
import com.smtcontrolweb.loginapiaa5ev01.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import java.util.Map;

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

    // Listar todos los usuarios registrados
    @GetMapping("/listar")
    public List<Usuario> listarUsuarios() {
        return usuarioService.listarUsuarios();
    }

    // Endpoint para buscar un usuario por medio del correo
    @GetMapping("/buscar/{correo}")
    public Usuario buscarUsuario(@PathVariable String correo) {
        return usuarioService.buscarPorCorreo(correo);
    }

    // Endpoint para actualizar un usuario existente.
    @PutMapping("/{id}")
    public Usuario actualizarUsuario(
            @PathVariable Integer id,
            @RequestBody Usuario usuario) {

        return usuarioService.actualizarUsuario(id, usuario);
    }

    // Endpoint para eliminar un usuario existente.
    @DeleteMapping("/{id}")
    public Map<String, String> eliminarUsuario(@PathVariable Integer id) {

        // Eliminar el usuario mediante el servicio.
        usuarioService.eliminarUsuario(id);

        // Informar que la eliminación fue exitosa.
        return Map.of(
                "mensaje", "Usuario eliminado correctamente.");
    }

    // Endpoint para validar el inicio de sesión del usuario
    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Usuario usuario) {

        // Busca el usuario en la base de datos utilizando el correo recibido
        Usuario usuarioEncontrado = usuarioService.buscarPorCorreo(usuario.getCorreo());

        // Verifica que el usuario exista y que la contraseña sea correcta
        if (usuarioEncontrado != null &&
                usuarioEncontrado.getContrasena().equals(usuario.getContrasena())) {

            // Devuelve el mensaje de autenticación y el rol del usuario
            return Map.of(
                    "mensaje", "Autenticación satisfactoria",
                    "rol", usuarioEncontrado.getRol());
        }

        // Devuelve el mensaje cuando los datos no coinciden
        return Map.of(
                "mensaje", "Error en la autenticación",
                "rol", "");
    }
}
