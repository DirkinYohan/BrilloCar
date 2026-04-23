package com.example.BrilloCar.repository;

import com.example.BrilloCar.model.entity.OrdenServicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdenServicioRepository extends JpaRepository<OrdenServicio, Long> {
}
