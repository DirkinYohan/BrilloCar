package com.example.BrilloCar.controller;

import com.example.BrilloCar.model.entity.Vehiculo;
import com.example.BrilloCar.service.VehiculoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/vehiculos")
@RequiredArgsConstructor
public class VehiculoController {
    private final VehiculoService vehiculoService;

    @PostMapping
    public ResponseEntity<Vehiculo> registrarVehiculo(@RequestBody Vehiculo vehiculo) {
        return ResponseEntity.ok(vehiculoService.registrarVehiculo(vehiculo));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehiculo> obtenerVehiculo(@PathVariable Long id) {
        return vehiculoService.obtenerVehiculo(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<List<Vehiculo>> listarVehiculosPorCliente(@PathVariable Long clienteId) {
        return ResponseEntity.ok(vehiculoService.listarVehiculosPorCliente(clienteId));
    }
}
