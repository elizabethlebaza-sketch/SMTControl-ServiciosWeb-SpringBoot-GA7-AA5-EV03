
package com.smtcontrolweb.loginapiaa5ev01.controller;

import com.smtcontrolweb.loginapiaa5ev01.model.Reserva;
import com.smtcontrolweb.loginapiaa5ev01.service.ReservaService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ReservaControllerTest {

    @Mock
    private ReservaService reservaService;

    @InjectMocks
    private ReservaController reservaController;

    @Test
    void probarRegistrarReserva() {

        Reserva reserva = mock(Reserva.class);

        when(reservaService.guardarReserva(reserva))
                .thenReturn(reserva);

        Reserva resultado = reservaController.registrarReserva(reserva);

        assertNotNull(resultado);
        assertSame(reserva, resultado);

        verify(reservaService).guardarReserva(reserva);
    }

    @Test
    void probarListarReservas() {

        List<Reserva> reservas = List.of(mock(Reserva.class));

        when(reservaService.listarReservas())
                .thenReturn(reservas);

        List<Reserva> resultado = reservaController.listarReservas();

        assertEquals(1, resultado.size());

        verify(reservaService).listarReservas();
    }
}