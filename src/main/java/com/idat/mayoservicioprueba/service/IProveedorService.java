package com.idat.mayoservicioprueba.service;

import com.idat.mayoservicioprueba.model.Proveedor;

import java.util.List;

public interface IProveedorService {
    Proveedor guardarProovedor(Proveedor proveedor);
    //    void actualizarProducto(Proveedor producto);
    void eliminarProovedor(int id);
    List<Proveedor> listarProovedor();
    Proveedor obtenerProovedorPorId(int id);
}
