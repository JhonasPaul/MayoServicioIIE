package com.idat.mayoservicioprueba.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "proovedores")
public class Proveedor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProvedor;
    private String proveedor;
    private String direccion;

    @OneToOne
    @JoinColumn(name = "id_producto", nullable = false, unique = true/*,
    foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_producto references productos(id_producto)")*/)
    private Producto producto;

    public Integer getIdProvedor() {
        return idProvedor;
    }

    public void setIdProvedor(Integer idProvedor) {
        this.idProvedor = idProvedor;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    private static final long serialVersionUID = 1L;
}
