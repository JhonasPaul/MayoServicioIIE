package com.idat.mayoservicioprueba.service;

import com.idat.mayoservicioprueba.model.Proveedor;
import com.idat.mayoservicioprueba.repository.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProveedorServiceImpl implements IProveedorService{
    @Autowired
    private ProveedorRepository repository;
    @Override
    public Proveedor guardarProovedor(Proveedor proveedor) {
        return repository.save(proveedor);
    }

    @Override
    public void eliminarProovedor(int id) {
        repository.deleteById(id);
    }

    @Override
    public List<Proveedor> listarProovedor() {
        return repository.findAll();
    }

    @Override
    public Proveedor obtenerProovedorPorId(int id) {
        return repository.findById(id).orElse(null);
    }
}
