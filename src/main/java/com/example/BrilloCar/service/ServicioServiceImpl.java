package com.example.BrilloCar.service;

import com.example.BrilloCar.model.entity.Servicio;
import com.example.BrilloCar.repository.ServicioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ServicioServiceImpl implements ServicioService {
    private final ServicioRepository servicioRepository;

    @Override
    @Transactional
    public Servicio crearServicio(Servicio servicio) {
        return servicioRepository.save(servicio);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Servicio> obtenerServicio(Long id) {
        return servicioRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Servicio> listarServicios() {
        return servicioRepository.findAll();
    }
}
