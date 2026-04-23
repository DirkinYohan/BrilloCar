package com.example.BrilloCar.controller;

import com.example.BrilloCar.model.entity.Vehiculo;
import com.example.BrilloCar.service.VehiculoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/vehiculos")
@RequiredArgsConstructor
@Tag(name = "Vehículos", description = "Gestión de vehículos de los clientes")
public class VehiculoController {
    private final VehiculoService vehiculoService;

    @PostMapping
    @Operation(summary = "Registrar un vehículo", description = "Asocia un vehículo a un cliente existente")
    public ResponseEntity<Vehiculo> registrarVehiculo(@RequestBody Vehiculo vehiculo) {
        return ResponseEntity.ok(vehiculoService.registrarVehiculo(vehiculo));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener detalle de un vehículo", description = "Busca un vehículo por su ID")
    public ResponseEntity<Vehiculo> obtenerVehiculo(@PathVariable Long id) {
        return vehiculoService.obtenerVehiculo(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/cliente/{clienteId}")
    @Operation(summary = "Listar vehículos por cliente", description = "Retorna todos los vehículos de un cliente específico")
    public ResponseEntity<List<Vehiculo>> listarVehiculosPorCliente(@PathVariable Long clienteId) {
        return ResponseEntity.ok(vehiculoService.listarVehiculosPorCliente(clienteId));
    }
}
