package com.idat.mayoservicioprueba.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clientes")
public class Cliente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCliente;
    private String cliente;
    private String celular;

    @ManyToMany(mappedBy = "clientes", cascade = CascadeType.MERGE)
    private List<Producto>productos = new ArrayList<>();

    @OneToMany(mappedBy = "clientes")
    private List<Item>items = new ArrayList<>();

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    private static final long serialVersionUID = 1L;
}
