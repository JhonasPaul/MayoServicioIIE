package com.idat.mayoservicioprueba.service;

import com.idat.mayoservicioprueba.model.Cliente;
import com.idat.mayoservicioprueba.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements IClienteService{
    @Autowired
    private ClienteRepository repository;
    @Override
    public Cliente guardarCliente(Cliente cliente) {
        return repository.save(cliente);
    }

    @Override
    public void eliminarCliente(int idCliente) {
        repository.deleteById(idCliente);
    }

    @Override
    public List<Cliente> listarCliente() {
        return repository.findAll();
    }

    @Override
    public Cliente obtenerClientePorId(int idCliente) {
        return repository.findById(idCliente).orElse(null);
    }
}
