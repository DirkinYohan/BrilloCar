package com.example.BrilloCar.controller;

import com.example.BrilloCar.model.entity.Pago;
import com.example.BrilloCar.service.PagoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pagos")
@RequiredArgsConstructor
public class PagoController {
    private final PagoService pagoService;

    @PostMapping
    public ResponseEntity<Pago> registrarPago(@RequestBody Pago pago) {
        return ResponseEntity.ok(pagoService.registrarPago(pago));
    }

    @GetMapping("/orden/{ordenId}")
    public ResponseEntity<Pago> obtenerPagoPorOrden(@PathVariable Long ordenId) {
        return pagoService.obtenerPagoPorOrden(ordenId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
