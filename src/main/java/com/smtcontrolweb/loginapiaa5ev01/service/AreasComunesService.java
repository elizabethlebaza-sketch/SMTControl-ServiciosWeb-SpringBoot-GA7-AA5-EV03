package com.smtcontrolweb.loginapiaa5ev01.service;

import com.smtcontrolweb.loginapiaa5ev01.model.AreasComunes;
import com.smtcontrolweb.loginapiaa5ev01.repository.AreasComunesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreasComunesService {

    private final AreasComunesRepository areasComunesRepository;

    public AreasComunesService(AreasComunesRepository areasComunesRepository) {
        this.areasComunesRepository = areasComunesRepository;
    }

    // Guardar un área común
    public AreasComunes guardarArea(AreasComunes area) {
        return areasComunesRepository.save(area);
    }

    // Listar áreas comunes
    public List<AreasComunes> listarAreas() {
        return areasComunesRepository.findAll();
    }

    // Buscar por ID
    public AreasComunes buscarPorId(Integer id) {
        return areasComunesRepository.findById(id).orElse(null);
    }

    // Eliminar área común
    public void eliminarArea(Integer id) {
        areasComunesRepository.deleteById(id);
    }
}