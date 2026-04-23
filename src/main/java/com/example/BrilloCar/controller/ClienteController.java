package com.example.BrilloCar.controller;

import com.example.BrilloCar.model.entity.Cliente;
import com.example.BrilloCar.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@RequiredArgsConstructor
@Tag(name = "Clientes", description = "Operaciones relacionadas con los clientes")
public class ClienteController {
    private final ClienteService clienteService;

    @PostMapping
    @Operation(summary = "Registrar un nuevo cliente", description = "Crea un cliente en el sistema")
    public ResponseEntity<Cliente> crearCliente(@RequestBody Cliente cliente) {
        return ResponseEntity.ok(clienteService.crearCliente(cliente));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener detalle de un cliente", description = "Busca un cliente por su ID")
    public ResponseEntity<Cliente> obtenerCliente(@PathVariable Long id) {
        return clienteService.obtenerCliente(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    @Operation(summary = "Listar todos los clientes", description = "Retorna una lista de todos los clientes registrados")
    public ResponseEntity<List<Cliente>> listarClientes() {
        return ResponseEntity.ok(clienteService.listarClientes());
    }
}
