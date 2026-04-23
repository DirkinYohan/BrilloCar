package com.example.BrilloCar.service;

import com.example.BrilloCar.model.entity.Vehiculo;
import java.util.List;
import java.util.Optional;

public interface VehiculoService {
    Vehiculo registrarVehiculo(Vehiculo vehiculo);
    Optional<Vehiculo> obtenerVehiculo(Long id);
    List<Vehiculo> listarVehiculosPorCliente(Long clienteId);
}
