package com.smtcontrolweb.loginapiaa5ev01.controller;

import com.smtcontrolweb.loginapiaa5ev01.model.AreasComunes;
import com.smtcontrolweb.loginapiaa5ev01.service.AreasComunesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/areas-comunes")
@CrossOrigin(origins = "*")
public class AreasComunesController {

    private final AreasComunesService areasComunesService;

    public AreasComunesController(AreasComunesService areasComunesService) {
        this.areasComunesService = areasComunesService;
    }

    // Registrar área común
    @PostMapping("/registrar")
    public AreasComunes registrarArea(@RequestBody AreasComunes area) {
        return areasComunesService.guardarArea(area);
    }

    // Listar áreas comunes
    @GetMapping("/listar")
    public List<AreasComunes> listarAreas() {
        return areasComunesService.listarAreas();
    }

    // Buscar área por ID
    @GetMapping("/{id}")
    public AreasComunes buscarArea(@PathVariable Integer id) {
        return areasComunesService.buscarPorId(id);
    }

    // Eliminar área común
    @DeleteMapping("/{id}")
    public void eliminarArea(@PathVariable Integer id) {
        areasComunesService.eliminarArea(id);
    }
}