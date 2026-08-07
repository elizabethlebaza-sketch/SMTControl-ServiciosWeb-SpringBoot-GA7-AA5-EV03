package com.smtcontrolweb.loginapiaa5ev01.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

// Esta clase representa la entidad Usuario que se almacena en la tabla usuario de MySQL
@Entity
public class Usuario {

    // Identificador único del usuario generado automáticamente por la base de datos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer idUsuario;

    // Nombre completo del usuario
    private String nombre;

    // Correo utilizado para el registro y autenticación
    private String correo;

    // Rol asignado al usuario dentro del sistema
    private String rol;

    // Contraseña del usuario para validar el inicio de sesión
    private String contrasena;

    // Cliente al que pertenece el usuario
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    // Método para obtener el identificador del usuario
    public Integer getIdUsuario() {
        return idUsuario;
    }

    // Método para asignar el identificador del usuario
    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    // Método para obtener el nombre del usuario
    public String getNombre() {
        return nombre;
    }

    // Método para asignar el nombre del usuario
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Método para obtener el correo del usuario
    public String getCorreo() {
        return correo;
    }

    // Método para asignar el correo del usuario
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    // Método para obtener el rol del usuario
    public String getRol() {
        return rol;
    }

    // Método para asignar el rol del usuario
    public void setRol(String rol) {
        this.rol = rol;
    }

    // Método para obtener la contraseña del usuario
    public String getContrasena() {
        return contrasena;
    }

    // Método para asignar la contraseña del usuario
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    // Obtener el cliente asociado al usuario
    public Cliente getCliente() {
        return cliente;
    }

    // Asignar el cliente al usuario
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}