package com.idat.mayoservicioprueba.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "proveedores")
public class Proveedor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProvedor;
    private String proveedor;
    private String direccion;


    @JsonIgnoreProperties({"proveedor"})
    @OneToOne
    @JoinColumn(name = "id_producto",
            nullable = false,
            unique = true)
    private Producto productos;


    private static final long serialVersionUID = 1L;
}
