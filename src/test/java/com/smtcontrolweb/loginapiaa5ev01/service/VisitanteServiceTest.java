package com.smtcontrolweb.loginapiaa5ev01.service;

import com.smtcontrolweb.loginapiaa5ev01.model.Visitante;
import com.smtcontrolweb.loginapiaa5ev01.repository.VisitanteRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class VisitanteServiceTest {

    @Mock
    private VisitanteRepository visitanteRepository;

    @InjectMocks
    private VisitanteService visitanteService;

    @Test
    void probarGuardarVisitante() {

        Visitante visitante = mock(Visitante.class);

        when(visitanteRepository.save(visitante))
                .thenReturn(visitante);

        Visitante resultado = visitanteService.guardarVisitante(visitante);

        assertNotNull(resultado);
        assertSame(visitante, resultado);

        verify(visitanteRepository).save(visitante);
    }

    @Test
    void probarListarVisitantes() {

        List<Visitante> visitantes = List.of(mock(Visitante.class));

        when(visitanteRepository.findAll())
                .thenReturn(visitantes);

        List<Visitante> resultado = visitanteService.listarVisitantes();

        assertEquals(1, resultado.size());
        verify(visitanteRepository).findAll();
    }

    @Test
    void probarActualizarVisitante() {

        Visitante visitanteExistente = mock(Visitante.class);
        Visitante visitanteActualizado = mock(Visitante.class);

        when(visitanteRepository.findById(1L))
                .thenReturn(java.util.Optional.of(visitanteExistente));

        when(visitanteRepository.save(visitanteExistente))
                .thenReturn(visitanteExistente);

        Visitante resultado = visitanteService.actualizarVisitante(1L, visitanteActualizado);

        assertNotNull(resultado);
        assertSame(visitanteExistente, resultado);

        verify(visitanteRepository).save(visitanteExistente);
    }

    @Test
    void probarEliminarVisitante() {

        doNothing().when(visitanteRepository).deleteById(1L);

        visitanteService.eliminarVisitante(1L);

        verify(visitanteRepository).deleteById(1L);
    }
}