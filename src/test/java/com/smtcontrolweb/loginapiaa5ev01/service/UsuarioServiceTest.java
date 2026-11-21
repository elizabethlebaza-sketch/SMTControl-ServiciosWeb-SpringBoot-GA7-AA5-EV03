
package com.smtcontrolweb.loginapiaa5ev01.service;

import com.smtcontrolweb.loginapiaa5ev01.model.Usuario;
import com.smtcontrolweb.loginapiaa5ev01.repository.UsuarioRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UsuarioServiceTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private UsuarioService usuarioService;

    @Test
    void probarGuardarUsuario() {

        Usuario usuario = mock(Usuario.class);

        when(usuarioRepository.save(usuario))
                .thenReturn(usuario);

        Usuario resultado = usuarioService.guardarUsuario(usuario);

        assertNotNull(resultado);
        assertSame(usuario, resultado);

        verify(usuarioRepository).save(usuario);
    }

    @Test
    void probarListarUsuarios() {

        List<Usuario> usuarios = List.of(mock(Usuario.class));

        when(usuarioRepository.findAll())
                .thenReturn(usuarios);

        List<Usuario> resultado = usuarioService.listarUsuarios();

        assertEquals(1, resultado.size());

        verify(usuarioRepository).findAll();
    }

    @Test
    void probarBuscarPorCorreo() {

        Usuario usuario = mock(Usuario.class);

        when(usuarioRepository.findByCorreo("prueba@smtcontrol.com"))
                .thenReturn(usuario);

        Usuario resultado = usuarioService.buscarPorCorreo("prueba@smtcontrol.com");

        assertNotNull(resultado);
        assertSame(usuario, resultado);

        verify(usuarioRepository).findByCorreo("prueba@smtcontrol.com");
    }

    @Test
    void probarActualizarUsuario() {

        Usuario usuarioExistente = mock(Usuario.class);
        Usuario usuarioActualizado = mock(Usuario.class);

        when(usuarioRepository.findById(1))
                .thenReturn(Optional.of(usuarioExistente));

        when(usuarioRepository.save(usuarioExistente))
                .thenReturn(usuarioExistente);

        Usuario resultado = usuarioService.actualizarUsuario(1, usuarioActualizado);

        assertNotNull(resultado);
        assertSame(usuarioExistente, resultado);

        verify(usuarioRepository).findById(1);
        verify(usuarioRepository).save(usuarioExistente);
    }

    @Test
    void probarActualizarUsuarioNoExistente() {

        Usuario usuario = mock(Usuario.class);

        when(usuarioRepository.findById(99))
                .thenReturn(Optional.empty());

        Usuario resultado = usuarioService.actualizarUsuario(99, usuario);

        assertNull(resultado);

        verify(usuarioRepository).findById(99);
        verify(usuarioRepository, never()).save(any(Usuario.class));
    }

    @Test
    void probarEliminarUsuario() {

        doNothing().when(usuarioRepository).deleteById(1);

        usuarioService.eliminarUsuario(1);

        verify(usuarioRepository).deleteById(1);
    }
}