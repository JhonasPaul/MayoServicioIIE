package com.idat.mayoservicioprueba.service;

import com.idat.mayoservicioprueba.model.Producto;

import java.util.List;

public interface ProductoService {
    void guardarProducto(Producto producto);
//    void actualizarProducto(Producto producto);
    void eliminarProducto(int idProducto);
    List<Producto> listarProductos();
    Producto obtenerProductisPorId(int id);
}
