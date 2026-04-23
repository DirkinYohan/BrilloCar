package com.example.BrilloCar.service;

import com.example.BrilloCar.model.entity.OrdenServicio;
import com.example.BrilloCar.model.entity.Pago;
import com.example.BrilloCar.model.enums.EstadoOrden;
import com.example.BrilloCar.model.enums.EstadoPago;
import com.example.BrilloCar.repository.OrdenServicioRepository;
import com.example.BrilloCar.repository.PagoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PagoServiceImpl implements PagoService {

    private final PagoRepository pagoRepository;
    private final OrdenServicioRepository ordenRepository;

    @Override
    @Transactional
    public Pago registrarPago(Pago pago) {
        OrdenServicio orden = ordenRepository.findById(pago.getOrden().getId())
                .orElseThrow(() -> new RuntimeException("Orden no encontrada"));

        if (orden.getEstado() != EstadoOrden.FINALIZADA) {
            throw new IllegalStateException("Solo se puede pagar una orden en estado FINALIZADA");
        }

        if (pagoRepository.findByOrdenId(orden.getId()).isPresent()) {
            throw new IllegalStateException("La orden ya tiene un pago registrado");
        }

        pago.setOrden(orden);
        pago.setFechaPago(LocalDateTime.now());
        pago.setEstado(EstadoPago.COMPLETADO);
        return pagoRepository.save(pago);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Pago> obtenerPagoPorOrden(Long ordenId) {
        return pagoRepository.findByOrdenId(ordenId);
    }
}
