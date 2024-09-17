package com.supply.supply.producto.repository;

import com.supply.supply.producto.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductoRespository extends JpaRepository<Producto,Long> {
}
