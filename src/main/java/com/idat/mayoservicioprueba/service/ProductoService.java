package com.idat.mayoservicioprueba.service;

import com.idat.mayoservicioprueba.dto.ProductoDTOResponse;
import com.idat.mayoservicioprueba.dto.ProductoDTOResquest;
import com.idat.mayoservicioprueba.model.Producto;

import java.util.List;

public interface ProductoService {
    void guardarProducto(ProductoDTOResquest productoDTOResponse);
    void actualizarProducto(ProductoDTOResquest productoDTOResponse);
    void eliminarProducto(Integer idProducto);
    List<ProductoDTOResponse> listarProductos();
    ProductoDTOResponse obtenerProductisPorId(Integer id);
}
