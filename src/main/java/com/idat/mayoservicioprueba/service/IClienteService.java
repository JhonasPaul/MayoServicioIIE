package com.idat.mayoservicioprueba.service;

import com.idat.mayoservicioprueba.model.Cliente;

import java.util.List;

public interface IClienteService {
    Cliente guardarCliente(Cliente cliente);
    //    void actualizarProducto(Cliente producto);
    void eliminarCliente(int idCliente);
    List<Cliente> listarCliente();
    Cliente obtenerClientePorId(int idCliente);
}
