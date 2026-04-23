package com.example.BrilloCar.controller;

import com.example.BrilloCar.model.entity.Servicio;
import com.example.BrilloCar.service.ServicioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/servicios")
@RequiredArgsConstructor
@Tag(name = "Servicios", description = "Catálogo de servicios (Lavado, Polichado, etc.)")
public class ServicioController {
    private final ServicioService servicioService;

    @PostMapping
    @Operation(summary = "Crear un nuevo servicio", description = "Añade un tipo de servicio al catálogo")
    public ResponseEntity<Servicio> crearServicio(@RequestBody Servicio servicio) {
        return ResponseEntity.ok(servicioService.crearServicio(servicio));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener detalle de un servicio", description = "Busca un servicio por su ID")
    public ResponseEntity<Servicio> obtenerServicio(@PathVariable("id") Long id) {
        return servicioService.obtenerServicio(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    @Operation(summary = "Listar catálogo de servicios", description = "Retorna todos los servicios disponibles")
    public ResponseEntity<List<Servicio>> listarServicios() {
        return ResponseEntity.ok(servicioService.listarServicios());
    }
}
