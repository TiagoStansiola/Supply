package com.supply.supply.pedido;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Data
@Table(name = "pedidos")
public class Pedido {
    @Id
    private Long id;
    private Long idComprador;
    private Long idProveedor;
    private Long idListaProductos;
    private Double montoTotal;
    private Date fechaCreacion;
    private Date fechaActualizacion;
    private Date fechaCancelacion;
    private String estadoPedido;
}
