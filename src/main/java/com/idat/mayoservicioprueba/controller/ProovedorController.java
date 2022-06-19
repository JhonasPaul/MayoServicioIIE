package com.idat.mayoservicioprueba.controller;

import com.idat.mayoservicioprueba.model.Proveedor;
import com.idat.mayoservicioprueba.service.ProveedorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")/*url base*/

public class ProovedorController {
    @Autowired
    private ProveedorServiceImpl service;

    @GetMapping("/proveedor")
    public List<Proveedor> index() {
        return service.listarProovedor();
    }


    @GetMapping("/proveedor/{id}")
    public Proveedor show(@PathVariable Integer id) {
        return this.service.obtenerProovedorPorId(id);
    }

    @PostMapping("/proveedor")
    @ResponseStatus(HttpStatus.CREATED)
    public Proveedor create(@RequestBody Proveedor cliente) {
        this.service.guardarProovedor(cliente);
        return cliente;
    }

    @PutMapping("/proveedor/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Proveedor update(@RequestBody Proveedor cliente, @PathVariable Integer id) {
        Proveedor clienteActual = this.service.obtenerProovedorPorId(id);
        clienteActual.setProveedor(cliente.getProveedor());
        clienteActual.setDireccion(cliente.getDireccion());
        this.service.guardarProovedor(clienteActual);
        return clienteActual;
    }

    @DeleteMapping("/proveedor/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        Proveedor clienteActual = this.service.obtenerProovedorPorId(id);
        this.service.eliminarProovedor(id);
    }
}
