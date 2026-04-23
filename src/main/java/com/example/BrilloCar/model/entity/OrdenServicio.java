package com.example.BrilloCar.model.entity;

import com.example.BrilloCar.model.enums.EstadoOrden;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ordenes_servicio")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrdenServicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String numeroOrden;

    private LocalDateTime fechaRecepcion;
    private LocalDateTime fechaFinalizacion;
    private BigDecimal total;

    @Enumerated(EnumType.STRING)
    private EstadoOrden estado;

    private String observaciones;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehiculo_id")
    private Vehiculo vehiculo;

    @OneToOne(mappedBy = "orden", cascade = CascadeType.ALL)
    private Pago pago;

    @OneToMany(mappedBy = "orden", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<ItemServicio> items = new ArrayList<>();
}
