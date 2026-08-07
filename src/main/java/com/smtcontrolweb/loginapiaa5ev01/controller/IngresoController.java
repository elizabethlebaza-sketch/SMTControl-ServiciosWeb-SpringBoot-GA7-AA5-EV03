package com.smtcontrolweb.loginapiaa5ev01.controller;

import com.smtcontrolweb.loginapiaa5ev01.model.Ingreso;
import com.smtcontrolweb.loginapiaa5ev01.service.IngresoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ingresos")
@CrossOrigin(origins = "*")
public class IngresoController {

    private final IngresoService ingresoService;

    public IngresoController(IngresoService ingresoService) {
        this.ingresoService = ingresoService;
    }

    // Registrar ingreso
    @PostMapping("/registrar")
    public Ingreso registrarIngreso(@RequestBody Ingreso ingreso) {
        return ingresoService.guardarIngreso(ingreso);
    }

    // Listar ingresos
    @GetMapping("/listar")
    public List<Ingreso> listarIngresos() {
        return ingresoService.listarIngresos();
    }

    // Buscar ingreso por ID
    @GetMapping("/{id}")
    public Ingreso buscarIngreso(@PathVariable Integer id) {
        return ingresoService.buscarPorId(id);
    }

    // Eliminar ingreso
    @DeleteMapping("/{id}")
    public void eliminarIngreso(@PathVariable Integer id) {
        ingresoService.eliminarIngreso(id);
    }
}