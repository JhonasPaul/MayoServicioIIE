package com.idat.mayoservicioprueba.service;

import com.idat.mayoservicioprueba.model.Producto;
import com.idat.mayoservicioprueba.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService{
    @Autowired
    private ProductoRepository repository;

    @Override
    @Transactional
    public void guardarProducto(Producto producto) {
        repository.save(producto);
    }

    @Override
    @Transactional
    public void eliminarProducto(int idProducto) {
        repository.deleteById(idProducto);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Producto> listarProductos() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Producto obtenerProductisPorId(int id) {
        return repository.findById(id).orElse(null);
    }
}
