package com.supply.supply.pedido;

import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/pedido")
public class PedidoController {

    private final PedidoService service;


    public PedidoController(PedidoService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public Pedido createPedido(@RequestBody Pedido pedido){
        return service.createPedido(pedido);
    }

    @GetMapping("/{id}")
    public Optional<Pedido> getPedidoById(@PathVariable Long id){
      return service.getPedidoById(id);
    }


}
