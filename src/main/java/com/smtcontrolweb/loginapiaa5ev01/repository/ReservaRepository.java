package com.smtcontrolweb.loginapiaa5ev01.repository;

import com.smtcontrolweb.loginapiaa5ev01.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

// Repositorio encargado de acceder a la tabla reserva
public interface ReservaRepository extends JpaRepository<Reserva, Integer> {

}