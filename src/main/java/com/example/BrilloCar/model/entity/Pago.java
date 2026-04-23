package com.example.BrilloCar.model.entity;

import com.example.BrilloCar.model.enums.EstadoPago;
import com.example.BrilloCar.model.enums.MetodoPago;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "pagos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Representa un pago realizado por una orden")
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID único del pago", example = "1")
    private Long id;

    @Schema(description = "Monto pagado", example = "25.50")
    private BigDecimal monto;

    @Enumerated(EnumType.STRING)
    @Schema(description = "Método de pago (EFECTIVO, TARJETA, TRANSFERENCIA)")
    private MetodoPago metodo;

    @Schema(description = "Fecha y hora del pago")
    private LocalDateTime fechaPago;

    @Enumerated(EnumType.STRING)
    @Schema(description = "Estado del pago (PENDIENTE, COMPLETADO, FALLIDO)")
    private EstadoPago estado;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orden_id")
    private OrdenServicio orden;
}
