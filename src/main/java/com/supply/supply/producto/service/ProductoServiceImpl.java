package com.supply.supply.producto.service;

import com.supply.supply.producto.model.Producto;
import com.supply.supply.producto.repository.ProductoRespository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRespository productoRespository;

    public ProductoServiceImpl(ProductoRespository productoRespository) {
        this.productoRespository = productoRespository;
    }

    @Override
    public Producto createProducto(Producto producto) {
        return productoRespository.save(producto);
    }

    @Override
    public List<Producto> listProducto() {
        return productoRespository.findAll();
    }

    @Override
    public Optional<Producto> getByID(Long id) {
        return productoRespository.findById(id);
    }

    @Override
    public Optional<Producto> updateProducto(Long id, Producto producto) {
        Producto productoToUpdate = productoRespository.findById(id)
                .orElseThrow(() -> new RuntimeException("Admin not found"));

        productoToUpdate.setDescripcion(producto.getDescripcion());
        productoToUpdate.setNombre(producto.getNombre());
        productoToUpdate.setUrlImage(producto.getUrlImage());
        productoToUpdate.setFechaDeActualizacion(new Date());

        return Optional.of(productoRespository.save(productoToUpdate));
    }

    @Override
    public Optional<Producto> deleteProducto(Long id, Producto producto) {
        Producto productoToUpdate = productoRespository.findById(id)
                .orElseThrow(() -> new RuntimeException("Admin not found"));

        productoToUpdate.setDescripcion(producto.getDescripcion());
        productoToUpdate.setNombre(producto.getNombre());
        productoToUpdate.setUrlImage(producto.getUrlImage());
        productoToUpdate.setFechaDeEliminacion(new Date());

        return Optional.of(productoRespository.save(productoToUpdate));
    }

    public Producto aprobarProducto(Long id) {
        Producto producto = productoRespository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        producto.setIsAprobado(true);
        return productoRespository.save(producto);
    }
}