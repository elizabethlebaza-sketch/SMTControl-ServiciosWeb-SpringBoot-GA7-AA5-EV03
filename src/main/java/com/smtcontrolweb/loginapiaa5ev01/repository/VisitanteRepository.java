package com.smtcontrolweb.loginapiaa5ev01.repository;

import com.smtcontrolweb.loginapiaa5ev01.model.Visitante;
import org.springframework.data.jpa.repository.JpaRepository;

// Repositorio encargado de realizar operaciones con la tabla visitante.
public interface VisitanteRepository extends JpaRepository<Visitante, Long> {

}