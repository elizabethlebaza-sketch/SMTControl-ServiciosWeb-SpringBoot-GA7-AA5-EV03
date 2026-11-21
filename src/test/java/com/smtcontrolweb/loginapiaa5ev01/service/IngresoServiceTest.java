package com.smtcontrolweb.loginapiaa5ev01.service;

import com.smtcontrolweb.loginapiaa5ev01.model.Ingreso;
import com.smtcontrolweb.loginapiaa5ev01.repository.IngresoRepository;

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
class IngresoServiceTest {

    @Mock
    private IngresoRepository ingresoRepository;

    @InjectMocks
    private IngresoService ingresoService;

    @Test
    void probarGuardarIngreso() {

        Ingreso ingreso = mock(Ingreso.class);

        when(ingresoRepository.save(ingreso))
                .thenReturn(ingreso);

        Ingreso resultado = ingresoService.guardarIngreso(ingreso);

        assertNotNull(resultado);
        assertSame(ingreso, resultado);

        verify(ingresoRepository).save(ingreso);
    }

    @Test
    void probarListarIngresos() {

        List<Ingreso> ingresos = List.of(mock(Ingreso.class));

        when(ingresoRepository.findAll())
                .thenReturn(ingresos);

        List<Ingreso> resultado = ingresoService.listarIngresos();

        assertEquals(1, resultado.size());

        verify(ingresoRepository).findAll();
    }

    @Test
    void probarBuscarPorId() {

        Ingreso ingreso = mock(Ingreso.class);

        when(ingresoRepository.findById(1))
                .thenReturn(Optional.of(ingreso));

        Ingreso resultado = ingresoService.buscarPorId(1);

        assertNotNull(resultado);
        assertSame(ingreso, resultado);

        verify(ingresoRepository).findById(1);
    }

    @Test
    void probarEliminarIngreso() {

        doNothing().when(ingresoRepository).deleteById(1);

        ingresoService.eliminarIngreso(1);

        verify(ingresoRepository).deleteById(1);
    }
}