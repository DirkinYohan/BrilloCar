package com.example.BrilloCar.model.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clientes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Representa un cliente en el sistema")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID único del cliente", example = "1")
    private Long id;

    @Column(nullable = false)
    @Schema(description = "Nombre del cliente", example = "Juan")
    private String nombre;

    @Column(nullable = false)
    @Schema(description = "Apellido del cliente", example = "Perez")
    private String apellido;

    @Column(nullable = false, unique = true)
    @Schema(description = "Correo electrónico único", example = "juan.perez@example.com")
    private String email;

    @Schema(description = "Número de teléfono", example = "555-1234")
    private String telefono;

    @Schema(description = "Dirección física", example = "Calle 123 #45-67")
    private String direccion;

    @OneToMany(mappedBy = "propietario", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<Vehiculo> vehiculos = new ArrayList<>();
}
