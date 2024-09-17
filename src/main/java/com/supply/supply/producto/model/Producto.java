package com.supply.supply.producto.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Setter
@Getter
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String descripcion;
    @Column(name = "url_image",columnDefinition = "VARCHAR(100)")
    private String urlImage;
    @Column(name = "fecha_de_creacion",columnDefinition = "DATE")
    private Date fechaDeCreacion;
    @Column(name = "fecha_de_actualizacion",columnDefinition = "DATE")
    private Date fechaDeActualizacion;
    @Column(name = "fecha_de_eliminacion",columnDefinition = "DATE")
    private Date fechaDeEliminacion;
    @Column(name = "is_aprobado",columnDefinition = "TINYINT")
    private Boolean isAprobado;


}
