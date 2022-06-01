package com.idat.mayoservicioprueba.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity()
@Table(name = "items")
public class Item implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idItem;
    private String item;
    private  Integer cantidad;
    private Double total;

    @ManyToOne
    @JoinColumn(
            name = "id_cliente",
            nullable = false,
            unique = true/*,
            foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (id_cliente) references clientes(id_cliente)")*/
    )
    private Cliente clientes;

    public Integer getIdItem() {
        return idItem;
    }

    public void setIdItem(Integer idItem) {
        this.idItem = idItem;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    private static final long serialVersionUID = 1L;
}
