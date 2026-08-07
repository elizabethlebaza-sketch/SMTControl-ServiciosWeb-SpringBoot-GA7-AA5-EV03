package com.smtcontrolweb.loginapiaa5ev01.service;

import com.smtcontrolweb.loginapiaa5ev01.model.Ingreso;
import com.smtcontrolweb.loginapiaa5ev01.repository.IngresoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngresoService {

    private final IngresoRepository ingresoRepository;

    public IngresoService(IngresoRepository ingresoRepository) {
        this.ingresoRepository = ingresoRepository;
    }

    // Registrar ingreso
    public Ingreso guardarIngreso(Ingreso ingreso) {
        return ingresoRepository.save(ingreso);
    }

    // Listar ingresos
    public List<Ingreso> listarIngresos() {
        return ingresoRepository.findAll();
    }

    // Buscar ingreso por ID
    public Ingreso buscarPorId(Integer id) {
        return ingresoRepository.findById(id).orElse(null);
    }

    // Eliminar ingreso
    public void eliminarIngreso(Integer id) {
        ingresoRepository.deleteById(id);
    }
}