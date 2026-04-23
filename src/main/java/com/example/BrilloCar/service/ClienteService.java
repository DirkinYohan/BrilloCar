package com.example.BrilloCar.service;

import com.example.BrilloCar.model.entity.Cliente;
import java.util.List;
import java.util.Optional;

public interface ClienteService {
    Cliente crearCliente(Cliente cliente);
    Optional<Cliente> obtenerCliente(Long id);
    List<Cliente> listarClientes();
}
