package com.supply.supply.producto.service;


import com.supply.supply.producto.model.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {
    Producto createProducto(Producto producto);
    List<Producto> listProducto();
    Optional<Producto> getByID(Long id);
    Optional<Producto> updateProducto(Long id, Producto producto);
    Optional<Producto> deleteProducto(Long id, Producto producto);
}
