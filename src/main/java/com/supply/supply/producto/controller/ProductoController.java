package com.supply.supply.producto.controller;
import com.supply.supply.producto.model.Producto;
import com.supply.supply.producto.service.ProductoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @PostMapping
    public ResponseEntity<Producto> createProducto(@RequestBody Producto producto){
        return ResponseEntity.ok(productoService.createProducto(producto));
    }

    @GetMapping("/list")
    public ResponseEntity<List<Producto>> listProducto(){
        return ResponseEntity.ok(productoService.listProducto());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Producto>> getById(@PathVariable Long id){
        return ResponseEntity.ok(productoService.getByID(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Optional<Producto>> updateProducto(@PathVariable Long id, @RequestBody Producto producto) {
        try {
            Optional<Producto> updatedProducto = productoService.updateProducto(id, producto);
            return ResponseEntity.ok(updatedProducto);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/delete/{id}")
    public ResponseEntity<Optional<Producto>> deleteProducto(@PathVariable Long id, @RequestBody Producto producto) {
        try {
            Optional<Producto> updatedProducto = productoService.deleteProducto(id, producto);
            return ResponseEntity.ok(updatedProducto);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
