package com.smtcontrolweb.loginapiaa5ev01.service;

import com.smtcontrolweb.loginapiaa5ev01.model.Cliente;
import com.smtcontrolweb.loginapiaa5ev01.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

// Servicio encargado de manejar la lógica de los clientes
@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    // Constructor para conectar el servicio con el repositorio
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    // Guardar un cliente nuevo
    public Cliente guardarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    // Listar todos los clientes registrados
    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    // Actualizar un cliente existente
    public Cliente actualizarCliente(Integer id, Cliente cliente) {

        Cliente clienteExistente = clienteRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        clienteExistente.setNombre(cliente.getNombre());
        clienteExistente.setTipo(cliente.getTipo());
        clienteExistente.setNit(cliente.getNit());
        clienteExistente.setCorreo(cliente.getCorreo());
        clienteExistente.setTelefono(cliente.getTelefono());
        clienteExistente.setDireccion(cliente.getDireccion());
        clienteExistente.setFechaInicioLicencia(
                cliente.getFechaInicioLicencia());
        clienteExistente.setFechaFinLicencia(
                cliente.getFechaFinLicencia());
        clienteExistente.setEstado(cliente.getEstado());

        return clienteRepository.save(clienteExistente);
    }
}
