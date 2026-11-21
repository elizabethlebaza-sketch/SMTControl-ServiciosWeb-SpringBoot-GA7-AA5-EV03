package com.smtcontrolweb.loginapiaa5ev01.controller;

import com.smtcontrolweb.loginapiaa5ev01.model.Cliente;
import com.smtcontrolweb.loginapiaa5ev01.service.ClienteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Controlador encargado de administrar los clientes
@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins = "*")
public class ClienteController {

    private final ClienteService clienteService;

    // Constructor para conectar con el servicio
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    // Registrar un cliente nuevo
    @PostMapping("/registrar")
    public Cliente registrarCliente(@RequestBody Cliente cliente) {
        return clienteService.guardarCliente(cliente);
    }

    // Listar todos los clientes
    @GetMapping("/listar")
    public List<Cliente> listarClientes() {
        return clienteService.listarClientes();
    }

    // Actualizar un cliente existente
    @PutMapping("/actualizar/{id}")
    public Cliente actualizarCliente(
            @PathVariable Integer id,
            @RequestBody Cliente cliente) {

        return clienteService.actualizarCliente(id, cliente);
    }

}
