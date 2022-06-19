package com.idat.mayoservicioprueba.model;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "clientes")
public class Cliente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Integer idCliente;
    private String cliente;
    private String celular;



    @JsonIgnoreProperties({"clientes","productos"})
    @ManyToMany(mappedBy = "clientes", cascade ={CascadeType.PERSIST, CascadeType.MERGE})
    private List<Producto>productos = new ArrayList<>();



    @JsonIgnoreProperties({"clientes"})
    @OneToMany(mappedBy = "clientes", cascade ={CascadeType.PERSIST, CascadeType.MERGE})
    private List<Item>items = new ArrayList<>();


    public Cliente(Integer idCliente) {
        super();
        this.idCliente = idCliente;
    }

    private static final long serialVersionUID = 1L;

}
