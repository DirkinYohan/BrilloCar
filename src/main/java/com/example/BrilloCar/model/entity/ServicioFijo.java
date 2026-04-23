package com.example.BrilloCar.model.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity
@Table(name = "servicios_fijos")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Servicio con un precio único independientemente del vehículo")
public class ServicioFijo extends Servicio {
    @Schema(description = "Precio fijo del servicio", example = "20.00")
    private BigDecimal precio;
}
