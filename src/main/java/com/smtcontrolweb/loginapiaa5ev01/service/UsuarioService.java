package com.smtcontrolweb.loginapiaa5ev01.service;

import com.smtcontrolweb.loginapiaa5ev01.model.Usuario;
import com.smtcontrolweb.loginapiaa5ev01.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

// Esta clase contiene la lógica de los servicios relacionados con los usuarios
@Service
public class UsuarioService {

    // Permite acceder a las operaciones de la base de datos
    private final UsuarioRepository usuarioRepository;

    // Constructor que recibe el repositorio de usuarios
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    // Guarda un nuevo usuario en la base de datos
    public Usuario guardarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // Obtener todos los usuarios
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    // Busca un usuario registrado mediante su correo
    public Usuario buscarPorCorreo(String correo) {
        return usuarioRepository.findByCorreo(correo);
    }

    // Actualiza la información de un usuario existente.
    public Usuario actualizarUsuario(Integer id, Usuario usuarioActualizado) {

        // Buscar el usuario existente por su ID.
        Usuario usuarioExistente = usuarioRepository.findById(id).orElse(null);

        // Verificar que el usuario exista.
        if (usuarioExistente == null) {
            return null;
        }

        // Actualizar los datos del usuario.
        usuarioExistente.setNombre(usuarioActualizado.getNombre());
        usuarioExistente.setCorreo(usuarioActualizado.getCorreo());
        usuarioExistente.setContrasena(usuarioActualizado.getContrasena());
        usuarioExistente.setRol(usuarioActualizado.getRol());

        // Guardar los cambios en la base de datos.
        return usuarioRepository.save(usuarioExistente);
    }

    // Elimina un usuario existente mediante su ID.
    public void eliminarUsuario(Integer id) {

        // Eliminar el usuario de la base de datos.
        usuarioRepository.deleteById(id);
    }
}