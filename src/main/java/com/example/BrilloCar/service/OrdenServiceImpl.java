package com.example.BrilloCar.service;

import com.example.BrilloCar.model.entity.*;
import com.example.BrilloCar.model.enums.EstadoOrden;
import com.example.BrilloCar.model.enums.TipoVehiculo;
import com.example.BrilloCar.repository.ClienteRepository;
import com.example.BrilloCar.repository.OrdenServicioRepository;
import com.example.BrilloCar.repository.ServicioRepository;
import com.example.BrilloCar.repository.VehiculoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrdenServiceImpl implements OrdenService {
    private final OrdenServicioRepository ordenRepository;
    private final ServicioRepository servicioRepository;
    private final VehiculoRepository vehiculoRepository;
    private final ClienteRepository clienteRepository;

    @Override
    @Transactional
    public OrdenServicio crearOrden(OrdenServicio orden) {
        if (orden.getVehiculo() == null || orden.getVehiculo().getId() == null) {
            throw new IllegalArgumentException("La orden debe estar asociada a un vehículo existente");
        }
        
        Vehiculo vehiculo = vehiculoRepository.findById(orden.getVehiculo().getId())
                .orElseThrow(() -> new RuntimeException("Vehículo no encontrado"));
        
        if (orden.getCliente() == null || orden.getCliente().getId() == null) {
            throw new IllegalArgumentException("La orden debe estar asociada a un cliente existente");
        }

        Cliente cliente = clienteRepository.findById(orden.getCliente().getId())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        orden.setVehiculo(vehiculo);
        orden.setCliente(cliente);
        orden.setEstado(EstadoOrden.REGISTRADA);
        orden.setTotal(BigDecimal.ZERO);
        orden.setFechaRecepcion(LocalDateTime.now());
        
        return ordenRepository.save(orden);
    }

    @Override
    @Transactional
    public OrdenServicio agregarServicioAOrden(Long ordenId, Long servicioId, String observaciones) {
        OrdenServicio orden = ordenRepository.findById(ordenId)
                .orElseThrow(() -> new RuntimeException("Orden no encontrada"));
        Servicio servicio = servicioRepository.findById(servicioId)
                .orElseThrow(() -> new RuntimeException("Servicio no encontrado"));

        BigDecimal precioAplicado = calcularPrecio(servicio, orden.getVehiculo().getTipo());

        ItemServicio item = ItemServicio.builder()
                .servicio(servicio)
                .orden(orden)
                .precioAplicado(precioAplicado)
                .observaciones(observaciones)
                .build();

        orden.getItems().add(item);
        orden.setTotal(orden.getTotal().add(precioAplicado));

        return ordenRepository.save(orden);
    }

    private BigDecimal calcularPrecio(Servicio servicio, TipoVehiculo tipoVehiculo) {
        if (servicio instanceof ServicioFijo sf) {
            return sf.getPrecio();
        } else if (servicio instanceof ServicioPrecioVariable spv) {
            return spv.getTarifas().getOrDefault(tipoVehiculo, servicio.getPrecioBase());
        }
        return servicio.getPrecioBase();
    }

    @Override
    @Transactional
    public OrdenServicio cambiarEstadoOrden(Long ordenId, EstadoOrden nuevoEstado) {
        OrdenServicio orden = ordenRepository.findById(ordenId)
                .orElseThrow(() -> new RuntimeException("Orden no encontrada"));
        
        if ((nuevoEstado == EstadoOrden.FINALIZADA || nuevoEstado == EstadoOrden.ENTREGADA) 
                && orden.getItems().isEmpty()) {
            throw new IllegalStateException("No se puede finalizar una orden sin servicios registrados");
        }

        if (nuevoEstado == EstadoOrden.FINALIZADA && orden.getFechaFinalizacion() == null) {
            orden.setFechaFinalizacion(LocalDateTime.now());
        }

        orden.setEstado(nuevoEstado);
        return ordenRepository.save(orden);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<OrdenServicio> obtenerOrden(Long id) {
        return ordenRepository.findById(id);
    }
}
