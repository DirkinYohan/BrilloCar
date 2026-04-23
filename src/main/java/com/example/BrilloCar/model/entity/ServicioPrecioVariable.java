package com.example.BrilloCar.model.entity;

import com.example.BrilloCar.model.enums.TipoVehiculo;
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
public class ServicioPrecioVariable extends Servicio {
    
    @ElementCollection
    @CollectionTable(name = "servicio_tarifas", joinColumns = @JoinColumn(name = "servicio_id"))
    @MapKeyEnumerated(EnumType.STRING)
    @MapKeyColumn(name = "tipo_vehiculo")
    @Column(name = "tarifa")
    private Map<TipoVehiculo, BigDecimal> tarifas;
}
