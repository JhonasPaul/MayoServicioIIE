package com.idat.mayoservicioprueba.service;

import com.idat.mayoservicioprueba.model.Producto;
import com.idat.mayoservicioprueba.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService{
    @Autowired
    private ProductoRepository repository;

    @Override
    public void guardarProducto(Producto producto) {
        repository.save(producto);
    }

    @Override
    public void eliminarProducto(int idProducto) {
        repository.deleteById(idProducto);
    }

    @Override
    public List<Producto> listarProductos() {
        return repository.findAll();
    }

    @Override
    public Producto obtenerProductisPorId(int id) {
        return repository.findById(id).orElse(null);
    }
}
