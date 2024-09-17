package com.supply.supply.cliente.dto;

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
public class ClienteDto {

    private Long id;
    private String nombre;
    private String apellido;
    private String telefono;


}
