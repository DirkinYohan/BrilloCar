package com.example.BrilloCar.model.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity
@Table(name = "items_servicio")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Representa un servicio aplicado dentro de una orden")
public class ItemServicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID único del item", example = "1")
    private Long id;

    @Schema(description = "Precio cobrado finalmente por este servicio", example = "18.00")
    private BigDecimal precioAplicado;

    @Schema(description = "Observaciones específicas del servicio en esta orden", example = "Mancha difícil en el capó")
    private String observaciones;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orden_id")
    private OrdenServicio orden;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "servicio_id")
    private Servicio servicio;
}
