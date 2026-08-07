package com.smtcontrolweb.loginapiaa5ev01.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ingreso")
public class Ingreso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ingreso")
    private Integer idIngreso;

    @Column(name = "fecha_ingreso")
    private String fechaIngreso;

    @Column(name = "tipo_persona")
    private String tipoPersona;

    @Column(name = "id_visitante")
    private Integer idVisitante;

    @Column(name = "id_contratista")
    private Integer idContratista;

    @Column(name = "id_usuario")
    private Integer idUsuario;

    public Integer getIdIngreso() {
        return idIngreso;
    }

    public void setIdIngreso(Integer idIngreso) {
        this.idIngreso = idIngreso;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(String tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    public Integer getIdVisitante() {
        return idVisitante;
    }

    public void setIdVisitante(Integer idVisitante) {
        this.idVisitante = idVisitante;
    }

    public Integer getIdContratista() {
        return idContratista;
    }

    public void setIdContratista(Integer idContratista) {
        this.idContratista = idContratista;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }
}
