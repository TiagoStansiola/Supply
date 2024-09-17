package com.supply.supply.producto.dto;

import lombok.Setter;
import lombok.Getter;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Setter
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoDto {

    private Long id;
    private String nombre;
    private String descripcion;
    private String urlImage;
    private Boolean isAprobado;
}
