package com.smtcontrolweb.loginapiaa5ev01.service;

import com.smtcontrolweb.loginapiaa5ev01.model.Reserva;
import com.smtcontrolweb.loginapiaa5ev01.repository.ReservaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

// Esta clase contiene la lógica para administrar las reservas
@Service
public class ReservaService {

    // Permite acceder a las operaciones de la base de datos
    private final ReservaRepository reservaRepository;

    // Constructor
    public ReservaService(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    // Guarda una nueva reserva
    public Reserva guardarReserva(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    // Lista todas las reservas
    public List<Reserva> listarReservas() {
        return reservaRepository.findAll();
    }
}