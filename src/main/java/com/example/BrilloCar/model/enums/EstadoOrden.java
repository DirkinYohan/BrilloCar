package com.example.BrilloCar.model.enums;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Estados posibles de una orden de servicio")
public enum EstadoOrden {
    @Schema(description = "Orden recién creada")
    REGISTRADA,
    @Schema(description = "El vehículo está siendo atendido")
    EN_PROCESO,
    @Schema(description = "El servicio ha terminado")
    FINALIZADA,
    @Schema(description = "El vehículo ha sido devuelto al cliente")
    ENTREGADA,
    @Schema(description = "La orden fue anulada")
    CANCELADA
}
