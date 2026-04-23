package com.example.BrilloCar.model.entity;

import com.example.BrilloCar.model.enums.EstadoPago;
import com.example.BrilloCar.model.enums.MetodoPago;
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
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal monto;

    @Enumerated(EnumType.STRING)
    private MetodoPago metodo;

    private LocalDateTime fechaPago;

    @Enumerated(EnumType.STRING)
    private EstadoPago estado;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orden_id")
    private OrdenServicio orden;
}
