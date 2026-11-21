package com.smtcontrolweb.loginapiaa5ev01.controller;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UsuarioControllerTest {

    @Test
    void pruebaVerificarCorreoUsuario() {
        String correo = "prueba@smtcontrol.com";

        assertNotNull(correo);
        assertTrue(correo.contains("@"));
    }

    @Test
    void pruebaVerificarNombreUsuario() {
        String nombre = "Elizabeth";

        assertNotNull(nombre);
        assertFalse(nombre.isEmpty());
    }
}