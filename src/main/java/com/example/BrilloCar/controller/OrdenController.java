package com.example.BrilloCar.controller;

import com.example.BrilloCar.model.entity.OrdenServicio;
import com.example.BrilloCar.model.enums.EstadoOrden;
import com.example.BrilloCar.service.OrdenService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ordenes")
@RequiredArgsConstructor
@Tag(name = "Órdenes de Servicio", description = "Gestión del ciclo de vida de las órdenes")
public class OrdenController {
    private final OrdenService ordenService;

    @PostMapping
    @Operation(summary = "Crear una nueva orden", description = "Inicia una orden de servicio para un vehículo")
    public ResponseEntity<OrdenServicio> crearOrden(@RequestBody OrdenServicio orden) {
        return ResponseEntity.ok(ordenService.crearOrden(orden));
    }

    @PostMapping("/{ordenId}/servicios/{servicioId}")
    @Operation(summary = "Agregar servicio a la orden", description = "Añade un servicio específico a una orden existente")
    public ResponseEntity<OrdenServicio> agregarServicioAOrden(
            @PathVariable Long ordenId,
            @PathVariable Long servicioId,
            @RequestParam(required = false) String observaciones) {
        return ResponseEntity.ok(ordenService.agregarServicioAOrden(ordenId, servicioId, observaciones));
    }

    @PatchMapping("/{ordenId}/estado")
    @Operation(summary = "Cambiar estado de la orden", description = "Actualiza el estado (REGISTRADA, EN_PROCESO, FINALIZADA, etc.)")
    public ResponseEntity<OrdenServicio> cambiarEstadoOrden(
            @PathVariable Long ordenId,
            @RequestParam EstadoOrden nuevoEstado) {
        return ResponseEntity.ok(ordenService.cambiarEstadoOrden(ordenId, nuevoEstado));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener detalle completo de la orden", description = "Retorna la orden con todos sus servicios y pago")
    public ResponseEntity<OrdenServicio> obtenerOrden(@PathVariable Long id) {
        return ordenService.obtenerOrden(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
