package com.smtcontrolweb.loginapiaa5ev01.model;

import jakarta.persistence.*;

@Entity
@Table(name = "areas_comunes")
public class AreasComunes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_areas_comunes")
    private Integer idAreasComunes;

    private String nombre;

    private String descripcion;

    public Integer getIdAreasComunes() {
        return idAreasComunes;
    }

    public void setIdAreasComunes(Integer idAreasComunes) {
        this.idAreasComunes = idAreasComunes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}