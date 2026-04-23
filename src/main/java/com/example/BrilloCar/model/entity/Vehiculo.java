package com.example.BrilloCar.model.entity;

import com.example.BrilloCar.model.enums.TipoVehiculo;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "vehiculos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Representa un vehículo registrado en el sistema")
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID único del vehículo", example = "1")
    private Long id;

    @Column(nullable = false, unique = true)
    @Schema(description = "Placa o matrícula del vehículo", example = "ABC-123")
    private String placa;

    @Schema(description = "Marca del fabricante", example = "Mazda")
    private String marca;

    @Schema(description = "Modelo o línea", example = "CX-5")
    private String modelo;

    @Schema(description = "Año de fabricación", example = "2023")
    private Integer anio;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @Schema(description = "Tipo de vehículo (SEDAN, SUV, MOTO, etc.)")
    private TipoVehiculo tipo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id")
    private Cliente propietario;
}
