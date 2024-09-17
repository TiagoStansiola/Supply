package com.supply.supply.pedido;

import java.util.Optional;

public interface PedidoService  {

    Pedido createPedido(Pedido pedido);

    Optional<Pedido> getPedidoById(Long id);
}
