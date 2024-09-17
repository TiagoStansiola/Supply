package com.supply.supply.cliente.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Setter
@Getter
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private String telefono;
    @Column(name = "tipo_cliente", columnDefinition = "VARCHAR(45)")
    private String tipoCliente;
    @Column(name = "fecha_nacimiento", columnDefinition = "DATE")
    private Date fechaNacimiento;
    @Column(name = "is_aprobado", columnDefinition = "TINYINT")
    private Boolean isAprobado;
    private String password;

}
