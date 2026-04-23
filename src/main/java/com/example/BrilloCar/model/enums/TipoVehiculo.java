package com.example.BrilloCar.model.enums;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Tipos de vehículos para clasificación de tarifas")
public enum TipoVehiculo {
    @Schema(description = "Motocicletas")
    MOTO,
    @Schema(description = "Automóviles tipo sedán")
    SEDAN,
    @Schema(description = "Vehículos de carga liviana o familiares")
    CAMIONETA,
    @Schema(description = "Camiones o buses")
    PESADO,
    @Schema(description = "Vehículos utilitarios deportivos")
    SUV
}
