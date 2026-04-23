package com.example.BrilloCar.service;

import com.example.BrilloCar.model.entity.Pago;
import java.util.Optional;

public interface PagoService {
    Pago registrarPago(Pago pago);
    Optional<Pago> obtenerPagoPorOrden(Long ordenId);
}
