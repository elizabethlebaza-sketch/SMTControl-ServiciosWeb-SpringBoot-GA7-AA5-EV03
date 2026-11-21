package com.smtcontrolweb.loginapiaa5ev01.controller;

import com.smtcontrolweb.loginapiaa5ev01.model.Ingreso;
import com.smtcontrolweb.loginapiaa5ev01.service.IngresoService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class IngresoControllerTest {

    @Mock
    private IngresoService ingresoService;

    @InjectMocks
    private IngresoController ingresoController;

    @Test
    void probarRegistrarIngreso() {

        Ingreso ingreso = mock(Ingreso.class);

        when(ingresoService.guardarIngreso(ingreso))
                .thenReturn(ingreso);

        Ingreso resultado = ingresoController.registrarIngreso(ingreso);

        assertNotNull(resultado);
        assertSame(ingreso, resultado);

        verify(ingresoService).guardarIngreso(ingreso);
    }

    @Test
    void probarListarIngresos() {

        List<Ingreso> ingresos = List.of(mock(Ingreso.class));

        when(ingresoService.listarIngresos())
                .thenReturn(ingresos);

        List<Ingreso> resultado = ingresoController.listarIngresos();

        assertEquals(1, resultado.size());

        verify(ingresoService).listarIngresos();
    }

    @Test
    void probarBuscarIngreso() {

        Ingreso ingreso = mock(Ingreso.class);

        when(ingresoService.buscarPorId(1))
                .thenReturn(ingreso);

        Ingreso resultado = ingresoController.buscarIngreso(1);

        assertNotNull(resultado);
        assertSame(ingreso, resultado);

        verify(ingresoService).buscarPorId(1);
    }

    @Test
    void probarEliminarIngreso() {

        doNothing().when(ingresoService).eliminarIngreso(1);

        ingresoController.eliminarIngreso(1);

        verify(ingresoService).eliminarIngreso(1);
    }
}