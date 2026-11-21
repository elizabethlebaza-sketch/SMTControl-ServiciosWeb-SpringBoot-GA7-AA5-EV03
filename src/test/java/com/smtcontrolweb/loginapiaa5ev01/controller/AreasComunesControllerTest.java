package com.smtcontrolweb.loginapiaa5ev01.controller;

import com.smtcontrolweb.loginapiaa5ev01.model.AreasComunes;
import com.smtcontrolweb.loginapiaa5ev01.service.AreasComunesService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AreasComunesControllerTest {

    @Mock
    private AreasComunesService areasComunesService;

    @InjectMocks
    private AreasComunesController areasComunesController;

    @Test
    void probarRegistrarArea() {

        AreasComunes area = mock(AreasComunes.class);

        when(areasComunesService.guardarArea(area))
                .thenReturn(area);

        AreasComunes resultado = areasComunesController.registrarArea(area);

        assertNotNull(resultado);
        assertSame(area, resultado);

        verify(areasComunesService).guardarArea(area);
    }

    @Test
    void probarListarAreas() {

        List<AreasComunes> areas = List.of(mock(AreasComunes.class));

        when(areasComunesService.listarAreas())
                .thenReturn(areas);

        List<AreasComunes> resultado = areasComunesController.listarAreas();

        assertEquals(1, resultado.size());

        verify(areasComunesService).listarAreas();
    }

    @Test
    void probarBuscarArea() {

        AreasComunes area = mock(AreasComunes.class);

        when(areasComunesService.buscarPorId(1))
                .thenReturn(area);

        AreasComunes resultado = areasComunesController.buscarArea(1);

        assertNotNull(resultado);
        assertSame(area, resultado);

        verify(areasComunesService).buscarPorId(1);
    }

    @Test
    void probarEliminarArea() {

        doNothing().when(areasComunesService).eliminarArea(1);

        areasComunesController.eliminarArea(1);

        verify(areasComunesService).eliminarArea(1);
    }
}