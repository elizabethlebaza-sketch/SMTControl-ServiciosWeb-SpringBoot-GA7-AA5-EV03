package com.smtcontrolweb.loginapiaa5ev01.repository;

import com.smtcontrolweb.loginapiaa5ev01.model.Visitante;
import org.springframework.data.jpa.repository.JpaRepository;

// Esta interfaz permite realizar operaciones con la tabla visitantes
public interface VisitanteRepository extends JpaRepository<Visitante, Integer> {

}