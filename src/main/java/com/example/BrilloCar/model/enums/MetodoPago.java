package com.example.BrilloCar.model.enums;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Métodos de pago aceptados")
public enum MetodoPago {
    @Schema(description = "Pago con dinero físico")
    EFECTIVO,
    @Schema(description = "Pago con tarjeta de crédito")
    TARJETA_CREDITO,
    @Schema(description = "Pago con tarjeta de débito")
    TARJETA_DEBITO,
    @Schema(description = "Transferencia bancaria directa")
    TRANSFERENCIA,
    @Schema(description = "Billetera digital Nequi")
    NEQUI,
    @Schema(description = "Billetera digital Daviplata")
    DAVIPLATA
}
