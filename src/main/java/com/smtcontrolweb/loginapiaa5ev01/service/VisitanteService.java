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

    // Actualiza la información de un visitante existente.
    public Visitante actualizarVisitante(Long id, Visitante visitanteActualizado) {

       // Buscar el visitante existente por su ID.
       Visitante visitanteExistente =
         visitanteRepository.findById(id).orElse(null);

       // Verificar que el visitante exista.
       if (visitanteExistente == null) {
          return null;
       }
 
       // Actualizar los datos del visitante.
       visitanteExistente.setNombre(visitanteActualizado.getNombre());
       visitanteExistente.setDocumento(visitanteActualizado.getDocumento());
       visitanteExistente.setTelefono(visitanteActualizado.getTelefono());
       visitanteExistente.setMotivo(visitanteActualizado.getMotivo());
       visitanteExistente.setFechaIngreso(visitanteActualizado.getFechaIngreso());

       // Guardar los cambios en MySQL.
       return visitanteRepository.save(visitanteExistente);
    } 

    // Elimina un visitante existente mediante su ID.
    public void eliminarVisitante(Long id) {

        // Eliminar el visitante de la base de datos.
        visitanteRepository.deleteById(id);
    }
}