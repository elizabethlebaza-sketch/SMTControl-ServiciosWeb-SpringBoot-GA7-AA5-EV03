package com.smtcontrolweb.loginapiaa5ev01.model;

import jakarta.persistence.*;
import java.time.LocalDate;

// Esta clase representa el cliente que adquiere la licencia del sistema SMTControl.
@Entity
@Table(name = "cliente")
public class Cliente {

    // Llave primaria de la tabla cliente.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Integer idCliente;

    // Nombre de la empresa o conjunto residencial.
    private String nombre;

    // Tipo de organización.
    private String tipo;

    // Número de identificación tributaria.
    private String nit;

    // Correo electrónico principal.
    private String correo;

    // Teléfono de contacto.
    private String telefono;

    // Dirección de la organización.
    private String direccion;

    // Fecha de inicio de la licencia.
    @Column(name = "fecha_inicio_licencia")
    private LocalDate fechaInicioLicencia;

    // Fecha de finalización de la licencia.
    @Column(name = "fecha_fin_licencia")
    private LocalDate fechaFinLicencia;

    // Estado de la licencia.
    private String estado;

    public Cliente() {
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public LocalDate getFechaInicioLicencia() {
        return fechaInicioLicencia;
    }

    public void setFechaInicioLicencia(LocalDate fechaInicioLicencia) {
        this.fechaInicioLicencia = fechaInicioLicencia;
    }

    public LocalDate getFechaFinLicencia() {
        return fechaFinLicencia;
    }

    public void setFechaFinLicencia(LocalDate fechaFinLicencia) {
        this.fechaFinLicencia = fechaFinLicencia;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
