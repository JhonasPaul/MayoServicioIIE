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


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "productos")
public class Producto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Integer id;
    private String nombre;
    private String descripcion;
    private double precio;
    private int stock;


    @OneToOne(mappedBy = "productos")
    private Proveedor proveedor;

    @JsonIgnoreProperties({"productos"})
    @ManyToMany(cascade = CascadeType.MERGE)
   @JoinTable(
            name = "productos_clientes",
            joinColumns = @JoinColumn(
                    name = "id_producto",
                    nullable = false,
                    unique = true

            ),
            inverseJoinColumns = @JoinColumn(
                    name = "id_cliente",
                    nullable = false,
                    unique = true
            )

    )
    private List<Cliente>clientes = new ArrayList<>();

    public Producto(int id) {
        this.id = id;
    }


    /*@JoinColumn agrega un campo en la tabla hijo
    * @Jointable agrega la tercera tabla de una relacion muchos a muchos.
    * Cuando la relacion es de unoa u no o mcuhos muchos, el mappedBy puede ir en cualquier clase*/

    private final static long serialVersionUID = 1L;
}
