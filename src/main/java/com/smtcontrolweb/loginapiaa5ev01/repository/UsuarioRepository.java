package com.smtcontrolweb.loginapiaa5ev01.repository;

import com.smtcontrolweb.loginapiaa5ev01.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Esta interfaz permite realizar operaciones con la tabla usuario en la base de datos
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    // Busca un usuario en la base de datos utilizando su correo
    Usuario findByCorreo(String correo);

}
