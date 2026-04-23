package com.example.BrilloCar.service;

import com.example.BrilloCar.model.entity.Pago;
import com.example.BrilloCar.repository.PagoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PagoServiceImpl implements PagoService {
    private final PagoRepository pagoRepository;

    @Override
    @Transactional
    public Pago registrarPago(Pago pago) {
        return pagoRepository.save(pago);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Pago> obtenerPagoPorOrden(Long ordenId) {
        return pagoRepository.findByOrdenId(ordenId);
    }
}
