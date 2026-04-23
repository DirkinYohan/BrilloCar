package com.example.BrilloCar.controller;

import com.example.BrilloCar.model.entity.Pago;
import com.example.BrilloCar.service.PagoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pagos")
@RequiredArgsConstructor
@Tag(name = "Pagos", description = "Gestión de pagos de las órdenes")
public class PagoController {
    private final PagoService pagoService;

    @PostMapping
    @Operation(summary = "Registrar un pago", description = "Almacena el pago realizado para una orden específica")
    public ResponseEntity<Pago> registrarPago(@RequestBody Pago pago) {
        return ResponseEntity.ok(pagoService.registrarPago(pago));
    }

    @GetMapping("/orden/{ordenId}")
    @Operation(summary = "Consultar pago por orden", description = "Busca la información del pago de una orden dada")
    public ResponseEntity<Pago> obtenerPagoPorOrden(@PathVariable Long ordenId) {
        return pagoService.obtenerPagoPorOrden(ordenId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
