package com.example.BrilloCar.service;

import com.example.BrilloCar.model.entity.Servicio;
import java.util.List;
import java.util.Optional;

public interface ServicioService {
    Servicio crearServicio(Servicio servicio);
    Optional<Servicio> obtenerServicio(Long id);
    List<Servicio> listarServicios();
}
