package com.example.BrilloCar.controller;

import com.example.BrilloCar.model.entity.OrdenServicio;
import com.example.BrilloCar.model.enums.EstadoOrden;
import com.example.BrilloCar.service.OrdenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ordenes")
@RequiredArgsConstructor
public class OrdenController {
    private final OrdenService ordenService;

    @PostMapping
    public ResponseEntity<OrdenServicio> crearOrden(@RequestBody OrdenServicio orden) {
        return ResponseEntity.ok(ordenService.crearOrden(orden));
    }

    @PostMapping("/{ordenId}/servicios/{servicioId}")
    public ResponseEntity<OrdenServicio> agregarServicioAOrden(
            @PathVariable Long ordenId,
            @PathVariable Long servicioId,
            @RequestParam(required = false) String observaciones) {
        return ResponseEntity.ok(ordenService.agregarServicioAOrden(ordenId, servicioId, observaciones));
    }

    @PatchMapping("/{ordenId}/estado")
    public ResponseEntity<OrdenServicio> cambiarEstadoOrden(
            @PathVariable Long ordenId,
            @RequestParam EstadoOrden nuevoEstado) {
        return ResponseEntity.ok(ordenService.cambiarEstadoOrden(ordenId, nuevoEstado));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrdenServicio> obtenerOrden(@PathVariable Long id) {
        return ordenService.obtenerOrden(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
