package com.example.BrilloCar.model.enums;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Categorías de servicios ofrecidos")
public enum TipoServicio {
    @Schema(description = "Lavado exterior e interior básico")
    LAVADO_BASICO,
    @Schema(description = "Lavado profundo con encerado")
    LAVADO_PREMIUM,
    @Schema(description = "Polichado y brillo de carrocería")
    PULIDO,
    @Schema(description = "Tratamiento de ozono o químicos internos")
    DESINFECCION,
    @Schema(description = "Lavado técnico de motor")
    LAVADO_MOTOR
}
