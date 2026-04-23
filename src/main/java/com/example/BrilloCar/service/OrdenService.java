package com.example.BrilloCar.service;

import com.example.BrilloCar.model.entity.OrdenServicio;
import com.example.BrilloCar.model.enums.EstadoOrden;
import java.util.Optional;

public interface OrdenService {
    OrdenServicio crearOrden(OrdenServicio orden);
    OrdenServicio agregarServicioAOrden(Long ordenId, Long servicioId, String observaciones);
    OrdenServicio cambiarEstadoOrden(Long ordenId, EstadoOrden nuevoEstado);
    Optional<OrdenServicio> obtenerOrden(Long id);
}
