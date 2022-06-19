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
@Table(name = "items")
public class Item implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idItem;
    private String item;
    private  Integer cantidad;
    private Double total;

    @JsonIgnoreProperties({"items"})
    @ManyToOne
    @JoinColumn(name = "id_cliente",
    nullable = false,
    unique = true)
    private Cliente clientes;

    private static final long serialVersionUID = 1L;
}
