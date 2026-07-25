package com.smtcontrolweb.loginapiaa5ev01.service;

import com.smtcontrolweb.loginapiaa5ev01.model.Visitante;
import com.smtcontrolweb.loginapiaa5ev01.repository.VisitanteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

// Esta clase contiene la lógica para administrar los visitantes
@Service
public class VisitanteService {

    private final VisitanteRepository visitanteRepository;

    // Constructor para inyectar el repositorio
    public VisitanteService(VisitanteRepository visitanteRepository) {
        this.visitanteRepository = visitanteRepository;
    }

    // Guarda un nuevo visitante
    public Visitante guardarVisitante(Visitante visitante) {
        return visitanteRepository.save(visitante);
    }

    // Lista todos los visitantes
    public List<Visitante> listarVisitantes() {
        return visitanteRepository.findAll();
    }
}