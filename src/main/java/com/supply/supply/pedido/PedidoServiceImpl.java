package com.supply.supply.pedido;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PedidoServiceImpl implements  PedidoService{

    private final PedidoRepository repository;

    public PedidoServiceImpl(PedidoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Pedido createPedido(Pedido pedido) {
        return repository.save(pedido);
    }

    @Override
    public Optional<Pedido> getPedidoById(Long id) {
        return repository.findById(id);
    }
}
