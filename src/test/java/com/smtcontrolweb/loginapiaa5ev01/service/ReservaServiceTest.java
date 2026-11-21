
package com.smtcontrolweb.loginapiaa5ev01.service;

import com.smtcontrolweb.loginapiaa5ev01.model.Reserva;
import com.smtcontrolweb.loginapiaa5ev01.repository.ReservaRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ReservaServiceTest {

    @Mock
    private ReservaRepository reservaRepository;

    @InjectMocks
    private ReservaService reservaService;

    @Test
    void probarGuardarReserva() {

        Reserva reserva = mock(Reserva.class);

        when(reservaRepository.save(reserva))
                .thenReturn(reserva);

        Reserva resultado = reservaService.guardarReserva(reserva);

        assertNotNull(resultado);
        assertSame(reserva, resultado);

        verify(reservaRepository).save(reserva);
    }

    @Test
    void probarListarReservas() {

        List<Reserva> reservas = List.of(mock(Reserva.class));

        when(reservaRepository.findAll())
                .thenReturn(reservas);

        List<Reserva> resultado = reservaService.listarReservas();

        assertEquals(1, resultado.size());

        verify(reservaRepository).findAll();
    }
}