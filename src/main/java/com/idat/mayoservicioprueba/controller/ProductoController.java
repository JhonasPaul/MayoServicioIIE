package com.idat.mayoservicioprueba.controller;

import com.idat.mayoservicioprueba.model.Producto;
import com.idat.mayoservicioprueba.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")/*url base*/
public class ProductoController {
    @Autowired
    ProductoService service;

    /*subrecurso*/
    @GetMapping("/listar") //Http Method GET
    public List<Producto> listar() {
        return service.listarProductos();
    }

    @PostMapping("/agregar") //Http Method POST
    public ResponseEntity<?> agregar(@RequestBody Producto producto) {
        Producto productoNuevo = null;
        Map<String, Object> response = new HashMap<>();
        try {
            service.guardarProducto(producto);
        }catch (DataAccessException e){
            response.put("mensaje", "Error al realizar el insert en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El producto ".concat(producto.getNombre()).concat(" ha sido creado con éxito"));
        response.put("producto", producto);
        return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED); //Http status code
    }

    @GetMapping("/buscar/{id}") //Http Method GET
    public ResponseEntity<?> buscar(@PathVariable Integer id) {
        Producto producto = null;
        Map<String, Object> response = new HashMap<>();

        try {
            producto = service.obtenerProductisPorId(id);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la consulta en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if (producto == null) {
            response.put("mensaje", "El producto con el ID: ".concat(id.toString()).concat(" no existe en la base de datos!"));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Producto>(producto, HttpStatus.OK);
    }


    @DeleteMapping("/borrar/{id}") //Http Method DELETE
    public ResponseEntity<?> borrar(@PathVariable Integer id)
    {
        Map<String, Object> response = new HashMap<>();
        try {
            Producto producto = service.obtenerProductisPorId(id);
             service.eliminarProducto(id);

        } catch (DataAccessException e) {
            response.put("mensaje", "Error al eliminar, el producto con el id " + id.toString() + " no existe en  la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);

        }
        response.put("mensaje", "Producto eliminado con éxito!");
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

    }

    @PutMapping("/editar/{productoId}") //Http Method PUT
    public ResponseEntity<?> editar(@PathVariable Integer productoId, @RequestBody Producto newProducto) {
        Producto productoActual=service.obtenerProductisPorId(productoId);
        Map<String, Object> response = new HashMap<>();
        if (productoActual == null) {
            response.put("mensaje", "Error: no se pudo editar,  el producto con el id: ".concat(productoId.toString()).concat("  no existe en la base de datos"));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        try {
            productoActual.setNombre(newProducto.getNombre());
            productoActual.setNombre(newProducto.getNombre());
            productoActual.setDescripcion(newProducto.getDescripcion());
            productoActual.setPrecio(newProducto.getPrecio());
            productoActual.setStock(newProducto.getStock());
            service.guardarProducto(productoActual);
        }catch (DataAccessException e){
            response.put("mensaje", "Error al actualizar el producto  la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "Producto " + productoActual.getNombre() + " actualizado con éxito");
        response.put("producto: ", productoActual);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

    }

}
