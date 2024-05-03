package com.jhons.proyectoFinalviernes.repository;

import com.jhons.proyectoFinalviernes.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepo extends JpaRepository<Producto, Long> {
}
