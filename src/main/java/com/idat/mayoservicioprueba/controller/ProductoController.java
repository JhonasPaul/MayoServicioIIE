package com.idat.mayoservicioprueba.controller;

import com.idat.mayoservicioprueba.model.Producto;
import com.idat.mayoservicioprueba.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductoController {
    @Autowired
    ProductoService service;

    @GetMapping("/listar") //Http Method GET
    public ResponseEntity<?> listar() {
        List<Producto> itemsInstructor=service.listarProductos();
        return new ResponseEntity<>(itemsInstructor, HttpStatus.OK); //Http status code
    }

    @PostMapping("/agregar") //Http Method POST
    public ResponseEntity<?> agregar(@RequestBody Producto producto) {
        service.guardarProducto(producto);
        return new ResponseEntity<Producto>(producto,HttpStatus.CREATED); //Http status code
    }

    @GetMapping("/buscar/{id}") //Http Method GET
    public ResponseEntity<?> buscar(@PathVariable Integer id) {
        Producto producto=service.obtenerProductisPorId(id);
        if(producto!=null) {
            return new ResponseEntity<>(producto,HttpStatus.OK); //Http status code
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND); //Http status code
    }

    @DeleteMapping("/borrar/{id}") //Http Method DELETE
    public ResponseEntity<?> borrar(@PathVariable Integer id)
    {
        Producto producto=service.obtenerProductisPorId(id);

        if(producto!=null) {
            service.eliminarProducto(id);
            return new ResponseEntity<Void>(HttpStatus.OK); //Http status code
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND); //Http status code
    }

    @PutMapping("/editar/{productoId}") //Http Method PUT
    public ResponseEntity<?> editar(@PathVariable Integer productoId, @RequestBody Producto newProducto) {
        Producto productoActual=service.obtenerProductisPorId(productoId);
        if(productoActual!=null) {
            productoActual.setNombre(newProducto.getNombre());
            productoActual.setNombre(newProducto.getNombre());
            productoActual.setDescripcion(newProducto.getDescripcion());
            productoActual.setPrecio(newProducto.getPrecio());
            productoActual.setStock(newProducto.getStock());
            service.guardarProducto(productoActual);
            return new ResponseEntity<Producto>(productoActual,HttpStatus.OK); //Http status code
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND); //Http status code
    }

}
