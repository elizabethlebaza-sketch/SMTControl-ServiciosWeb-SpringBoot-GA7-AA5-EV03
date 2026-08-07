package com.smtcontrolweb.loginapiaa5ev01.controller;

import com.smtcontrolweb.loginapiaa5ev01.model.Reserva;
import com.smtcontrolweb.loginapiaa5ev01.service.ReservaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Controlador encargado de administrar las reservas
@RestController
@RequestMapping("/reservas")
@CrossOrigin(origins = "*")
public class ReservaController {

    private final ReservaService reservaService;

    // Constructor
    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    // Registrar una nueva reserva
    @PostMapping("/registrar")
    public Reserva registrarReserva(@RequestBody Reserva reserva) {
        return reservaService.guardarReserva(reserva);
    }

    // Listar todas las reservas
    @GetMapping("/listar")
    public List<Reserva> listarReservas() {
        return reservaService.listarReservas();
    }
}