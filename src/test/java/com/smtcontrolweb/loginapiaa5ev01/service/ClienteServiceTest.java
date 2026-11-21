
package com.smtcontrolweb.loginapiaa5ev01.service;

import com.smtcontrolweb.loginapiaa5ev01.model.Cliente;
import com.smtcontrolweb.loginapiaa5ev01.repository.ClienteRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ClienteServiceTest {

    @Mock
    private ClienteRepository clienteRepository;

    @InjectMocks
    private ClienteService clienteService;

    @Test
    void probarGuardarCliente() {

        Cliente cliente = mock(Cliente.class);

        when(clienteRepository.save(cliente))
                .thenReturn(cliente);

        Cliente resultado = clienteService.guardarCliente(cliente);

        assertNotNull(resultado);
        assertSame(cliente, resultado);

        verify(clienteRepository).save(cliente);
    }

    @Test
    void probarListarClientes() {

        List<Cliente> clientes = List.of(mock(Cliente.class));

        when(clienteRepository.findAll())
                .thenReturn(clientes);

        List<Cliente> resultado = clienteService.listarClientes();

        assertEquals(1, resultado.size());

        verify(clienteRepository).findAll();
    }

    @Test
    void probarActualizarCliente() {

        Cliente clienteExistente = mock(Cliente.class);
        Cliente clienteNuevo = mock(Cliente.class);

        when(clienteRepository.findById(1))
                .thenReturn(Optional.of(clienteExistente));

        when(clienteRepository.save(clienteExistente))
                .thenReturn(clienteExistente);

        Cliente resultado = clienteService.actualizarCliente(1, clienteNuevo);

        assertNotNull(resultado);
        assertSame(clienteExistente, resultado);

        verify(clienteRepository).findById(1);
        verify(clienteRepository).save(clienteExistente);
    }

    @Test
    void probarActualizarClienteNoExistente() {

        Cliente cliente = mock(Cliente.class);

        when(clienteRepository.findById(99))
                .thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> clienteService.actualizarCliente(99, cliente));

        verify(clienteRepository).findById(99);
        verify(clienteRepository, never()).save(any(Cliente.class));
    }
}