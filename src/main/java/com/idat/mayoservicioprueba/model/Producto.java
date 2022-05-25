package com.idat.mayoservicioprueba.model;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "productos")
public class Producto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String descripcion;
    private double precio;
    private int stock;

/*//    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoria_id" *//*, nullable = false,
    foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(instructor_id) references categorias (id)")*//*)
//    private Categoria categoria;*/
    private final static long serialVersionUID = 1L;
}
