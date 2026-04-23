package com.example.BrilloCar.model.entity;

import com.example.BrilloCar.model.enums.TipoServicio;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity
@Table(name = "servicios")
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Clase base para los servicios del centro de lavado")
public abstract class Servicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID único del servicio", example = "1")
    private Long id;

    @Column(nullable = false)
    @Schema(description = "Nombre del servicio", example = "Lavado Básico")
    private String nombre;

    @Schema(description = "Descripción detallada", example = "Lavado exterior con shampoo y secado")
    private String descripcion;

    @Column(nullable = false)
    @Schema(description = "Precio base del servicio", example = "15.00")
    private BigDecimal precioBase;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @Schema(description = "Categoría del servicio")
    private TipoServicio tipo;
}
