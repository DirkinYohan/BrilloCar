package com.example.BrilloCar.service;

import com.example.BrilloCar.model.entity.Vehiculo;
import com.example.BrilloCar.repository.VehiculoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VehiculoServiceImpl implements VehiculoService {
    private final VehiculoRepository vehiculoRepository;

    @Override
    @Transactional
    public Vehiculo registrarVehiculo(Vehiculo vehiculo) {
        return vehiculoRepository.save(vehiculo);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Vehiculo> obtenerVehiculo(Long id) {
        return vehiculoRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Vehiculo> listarVehiculosPorCliente(Long clienteId) {
        return vehiculoRepository.findByPropietarioId(clienteId);
    }
}
