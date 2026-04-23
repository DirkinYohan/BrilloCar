package com.example.BrilloCar.model.enums;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Estados posibles de un pago")
public enum EstadoPago {
    @Schema(description = "El pago aún no se ha procesado")
    PENDIENTE,
    @Schema(description = "El pago fue exitoso")
    COMPLETADO,
    @Schema(description = "El pago fue declinado por la entidad financiera")
    RECHAZADO,
    @Schema(description = "El dinero fue devuelto al cliente")
    REEMBOLSADO
}
