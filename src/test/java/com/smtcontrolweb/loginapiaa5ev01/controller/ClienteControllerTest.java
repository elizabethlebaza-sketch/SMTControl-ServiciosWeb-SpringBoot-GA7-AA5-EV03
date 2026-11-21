
package com.smtcontrolweb.loginapiaa5ev01.controller;

import com.smtcontrolweb.loginapiaa5ev01.model.Cliente;
import com.smtcontrolweb.loginapiaa5ev01.service.ClienteService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ClienteControllerTest {

    @Mock
    private ClienteService clienteService;

    @InjectMocks
    private ClienteController clienteController;

    @Test
    void probarRegistrarCliente() {

        Cliente cliente = mock(Cliente.class);

        when(clienteService.guardarCliente(cliente))
                .thenReturn(cliente);

        Cliente resultado = clienteController.registrarCliente(cliente);

        assertNotNull(resultado);
        assertSame(cliente, resultado);

        verify(clienteService).guardarCliente(cliente);
    }

    @Test
    void probarListarClientes() {

        List<Cliente> clientes = List.of(mock(Cliente.class));

        when(clienteService.listarClientes())
                .thenReturn(clientes);

        List<Cliente> resultado = clienteController.listarClientes();

        assertEquals(1, resultado.size());

        verify(clienteService).listarClientes();
    }

    @Test
    void probarActualizarCliente() {

        Cliente cliente = mock(Cliente.class);

        when(clienteService.actualizarCliente(1, cliente))
                .thenReturn(cliente);

        Cliente resultado = clienteController.actualizarCliente(1, cliente);

        assertNotNull(resultado);
        assertSame(cliente, resultado);

        verify(clienteService).actualizarCliente(1, cliente);
    }
}