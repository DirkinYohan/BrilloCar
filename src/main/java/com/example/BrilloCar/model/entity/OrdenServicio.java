package com.example.BrilloCar.model.entity;

import com.example.BrilloCar.model.enums.EstadoOrden;
import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(description = "Representa una orden de servicio de lavado")
public class OrdenServicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID único de la orden", example = "1")
    private Long id;

    @Column(unique = true, nullable = false)
    @Schema(description = "Número correlativo de la orden", example = "ORD-2023-001")
    private String numeroOrden;

    @Schema(description = "Fecha y hora de recepción")
    private LocalDateTime fechaRecepcion;

    @Schema(description = "Fecha y hora de finalización")
    private LocalDateTime fechaFinalizacion;

    @Schema(description = "Monto total a pagar", example = "25.50")
    private BigDecimal total;

    @Enumerated(EnumType.STRING)
    @Schema(description = "Estado actual de la orden")
    private EstadoOrden estado;

    @Schema(description = "Observaciones adicionales", example = "Cuidado con el retrovisor derecho")
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
