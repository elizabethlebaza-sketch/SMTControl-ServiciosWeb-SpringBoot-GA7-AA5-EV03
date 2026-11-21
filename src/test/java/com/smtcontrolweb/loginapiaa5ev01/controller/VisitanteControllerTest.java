package com.smtcontrolweb.loginapiaa5ev01.controller;

import com.smtcontrolweb.loginapiaa5ev01.model.Visitante;
import com.smtcontrolweb.loginapiaa5ev01.service.VisitanteService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class VisitanteControllerTest {

    @Mock
    private VisitanteService visitanteService;

    @InjectMocks
    private VisitanteController visitanteController;

    @Test
    void probarRegistrarVisitante() {

        Visitante visitante = mock(Visitante.class);

        when(visitanteService.guardarVisitante(visitante))
                .thenReturn(visitante);

        Visitante resultado = visitanteController.registrarVisitante(visitante);

        assertNotNull(resultado);
        assertSame(visitante, resultado);

        verify(visitanteService).guardarVisitante(visitante);
    }

    @Test
    void probarListarVisitantes() {

        List<Visitante> visitantes = List.of(mock(Visitante.class));

        when(visitanteService.listarVisitantes())
                .thenReturn(visitantes);

        List<Visitante> resultado = visitanteController.listarVisitantes();

        assertEquals(1, resultado.size());

        verify(visitanteService).listarVisitantes();
    }

    @Test
    void probarActualizarVisitante() {

        Visitante visitante = mock(Visitante.class);

        when(visitanteService.actualizarVisitante(1L, visitante))
                .thenReturn(visitante);

        Visitante resultado = visitanteController.actualizarVisitante(1L, visitante);

        assertNotNull(resultado);

        verify(visitanteService).actualizarVisitante(1L, visitante);
    }

    @Test
    void probarEliminarVisitante() {

        doNothing().when(visitanteService).eliminarVisitante(1L);

        visitanteController.eliminarVisitante(1L);

        verify(visitanteService).eliminarVisitante(1L);
    }
}