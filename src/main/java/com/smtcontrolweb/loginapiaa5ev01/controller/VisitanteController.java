package com.smtcontrolweb.loginapiaa5ev01.controller;

import com.smtcontrolweb.loginapiaa5ev01.model.Visitante;
import com.smtcontrolweb.loginapiaa5ev01.service.VisitanteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Controlador para administrar los servicios de visitantes
@RestController
@RequestMapping("/visitantes")
@CrossOrigin(origins = "*")
public class VisitanteController {

    private final VisitanteService visitanteService;

    // Constructor para inyectar el servicio
    public VisitanteController(VisitanteService visitanteService) {
        this.visitanteService = visitanteService;
    }

    // Registrar un nuevo visitante
    @PostMapping("/registrar")
    public Visitante registrarVisitante(@RequestBody Visitante visitante) {
        return visitanteService.guardarVisitante(visitante);
    }

    // Listar todos los visitantes
    @GetMapping("/listar")
    public List<Visitante> listarVisitantes() {
        return visitanteService.listarVisitantes();
    }

    // Actualizar un visitante existente
    @PutMapping("/{id}")
    public Visitante actualizarVisitante(
            @PathVariable Long id,
            @RequestBody Visitante visitante) {

        return visitanteService.actualizarVisitante(id, visitante);
    }

    // Eliminar un visitante existente
    @DeleteMapping("/{id}")
    public void eliminarVisitante(@PathVariable Long id) {

        visitanteService.eliminarVisitante(id);
    }
}