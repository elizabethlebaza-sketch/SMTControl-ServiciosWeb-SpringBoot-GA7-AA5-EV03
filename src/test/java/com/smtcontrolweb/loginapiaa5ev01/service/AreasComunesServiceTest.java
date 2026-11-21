package com.smtcontrolweb.loginapiaa5ev01.service;

import com.smtcontrolweb.loginapiaa5ev01.model.AreasComunes;
import com.smtcontrolweb.loginapiaa5ev01.repository.AreasComunesRepository;

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
class AreasComunesServiceTest {

    @Mock
    private AreasComunesRepository areasComunesRepository;

    @InjectMocks
    private AreasComunesService areasComunesService;

    @Test
    void probarGuardarArea() {

        AreasComunes area = mock(AreasComunes.class);

        when(areasComunesRepository.save(area))
                .thenReturn(area);

        AreasComunes resultado = areasComunesService.guardarArea(area);

        assertNotNull(resultado);
        assertSame(area, resultado);

        verify(areasComunesRepository).save(area);
    }

    @Test
    void probarListarAreas() {

        List<AreasComunes> areas = List.of(mock(AreasComunes.class));

        when(areasComunesRepository.findAll())
                .thenReturn(areas);

        List<AreasComunes> resultado = areasComunesService.listarAreas();

        assertEquals(1, resultado.size());

        verify(areasComunesRepository).findAll();
    }

    @Test
    void probarBuscarPorId() {

        AreasComunes area = mock(AreasComunes.class);

        when(areasComunesRepository.findById(1))
                .thenReturn(Optional.of(area));

        AreasComunes resultado = areasComunesService.buscarPorId(1);

        assertNotNull(resultado);
        assertSame(area, resultado);

        verify(areasComunesRepository).findById(1);
    }

    @Test
    void probarEliminarArea() {

        doNothing().when(areasComunesRepository).deleteById(1);

        areasComunesService.eliminarArea(1);

        verify(areasComunesRepository).deleteById(1);
    }
}