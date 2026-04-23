package com.example.BrilloCar.model.entity;

import com.example.BrilloCar.model.enums.TipoVehiculo;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.util.Map;

@Entity
@Table(name = "servicios_precio_variable")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Servicio cuyo precio varía según el tipo de vehículo")
public class ServicioPrecioVariable extends Servicio {
    
    @ElementCollection
    @CollectionTable(name = "servicio_tarifas", joinColumns = @JoinColumn(name = "servicio_id"))
    @MapKeyEnumerated(EnumType.STRING)
    @MapKeyColumn(name = "tipo_vehiculo")
    @Column(name = "tarifa")
    @Schema(description = "Mapa de tarifas por tipo de vehículo")
    private Map<TipoVehiculo, BigDecimal> tarifas;
}
