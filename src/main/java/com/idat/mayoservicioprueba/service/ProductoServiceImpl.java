package com.idat.mayoservicioprueba.service;

import com.idat.mayoservicioprueba.dto.ProductoDTOResponse;
import com.idat.mayoservicioprueba.dto.ProductoDTOResquest;
import com.idat.mayoservicioprueba.model.Producto;
import com.idat.mayoservicioprueba.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService{
    @Autowired
    private ProductoRepository repository;

    @Override
    @Transactional
    public void guardarProducto(ProductoDTOResquest productoDTOResquest) {
        Producto p = new Producto();
        p.setId(productoDTOResquest.getIdProducto());
        p.setNombre(productoDTOResquest.getNombreProducto());
        p.setDescripcion(productoDTOResquest.getDescripcionProdcuto());
        p.setPrecio(productoDTOResquest.getPrecioProdcuto());
        p.setStock(productoDTOResquest.getStockProducto());
        repository.save(p);
    }

    @Override
    public void actualizarProducto(ProductoDTOResquest productoDTOResponse) {
        Producto p = new Producto();
        p.setId(productoDTOResponse.getIdProducto());
        p.setNombre(productoDTOResponse.getNombreProducto());
        p.setDescripcion(productoDTOResponse.getDescripcionProdcuto());
        p.setPrecio(productoDTOResponse.getPrecioProdcuto());
        p.setStock(productoDTOResponse.getStockProducto());

        repository.saveAndFlush(p);
    }

    @Override
    @Transactional
    public void eliminarProducto(Integer idProducto) {
        repository.deleteById(idProducto);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductoDTOResponse> listarProductos() {
        List<ProductoDTOResponse> listar = new ArrayList<>();
        ProductoDTOResponse dto = null;
        List<Producto> p = repository.findAll();
        /*recorre lo que obtenga de la base de datos y llenar el dto*/
        for (Producto productos : p) {
            /*el objeto de la base de datos se almacena en el dto*/
            dto = new ProductoDTOResponse();
            dto.setNombreProducto(productos.getNombre());
            dto.setIdProducto(productos.getId());
            dto.setStockProducto(productos.getStock());
            dto.setPrecioProdcuto(productos.getPrecio());
            dto.setDescripcionProdcuto(productos.getDescripcion());
            /*el dto se almacena en la lista*/
            listar.add(dto);
        }
        return listar;
    }

    @Override
    @Transactional(readOnly = true)
    public ProductoDTOResponse obtenerProductisPorId(Integer id) {
        Producto productos = repository.findById(id).orElse(null);
        ProductoDTOResponse dto = new ProductoDTOResponse();

        dto.setNombreProducto(productos.getNombre());
        dto.setIdProducto(productos.getId());
        dto.setStockProducto(productos.getStock());
        dto.setPrecioProdcuto(productos.getPrecio());
        dto.setDescripcionProdcuto(productos.getDescripcion());
        return dto;
    }
}
