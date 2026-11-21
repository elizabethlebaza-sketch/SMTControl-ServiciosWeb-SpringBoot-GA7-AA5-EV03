package com.smtcontrolweb.loginapiaa5ev01.model;

import jakarta.persistence.*;
import java.time.LocalDate;

// Entidad que representa una reserva en el sistema
@Entity
@Table(name = "reserva")
public class Reserva {

    // Llave primaria autoincremental
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reserva")
    private Integer idReserva;

    // Nombre del residente que realiza la reserva
    private String residente;

    // Nombre del visitante
    private String visitante;

    // Fecha de la reserva
    @Column(name = "fecha_reserva")
    private LocalDate fechaReserva;

    // Hora de la reserva
    @Column(name = "hora_reserva")
    private String horaReserva;

    // Estado de la reserva
    private String estado;

    // Área común seleccionada para la reserva
    @Column(name = "id_areas_comunes")
    private Integer idAreasComunes;

    // Constructor vacío
    public Reserva() {
    }

    // Getters y Setters

    public Integer getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Integer idReserva) {
        this.idReserva = idReserva;
    }

    public String getResidente() {
        return residente;
    }

    public void setResidente(String residente) {
        this.residente = residente;
    }

    public String getVisitante() {
        return visitante;
    }

    public void setVisitante(String visitante) {
        this.visitante = visitante;
    }

    public LocalDate getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(LocalDate fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public String getHoraReserva() {
        return horaReserva;
    }

    public void setHoraReserva(String horaReserva) {
        this.horaReserva = horaReserva;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getIdAreasComunes() {
        return idAreasComunes;
    }

    public void setIdAreasComunes(Integer idAreasComunes) {
        this.idAreasComunes = idAreasComunes;
    }
}