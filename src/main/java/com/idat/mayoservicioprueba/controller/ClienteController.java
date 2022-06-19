package com.idat.mayoservicioprueba.controller;

import com.idat.mayoservicioprueba.model.Cliente;
import com.idat.mayoservicioprueba.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/api")/*url base*/
public class ClienteController {
    @Autowired
    private ClienteService service;

    @GetMapping("/clientes")
    public List<Cliente> index() {
        return service.listarCliente();
    }

    @GetMapping("/clientes/{id}")
    public Cliente show(@PathVariable Integer id) {
        return this.service.obtenerClientePorId(id);
    }

    @PostMapping("/clientes")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente create(@RequestBody Cliente cliente) {
        this.service.guardarCliente(cliente);
        return cliente;
    }

    @PutMapping("/clientes/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente update(@RequestBody Cliente cliente, @PathVariable Integer id) {
        Cliente clienteActual = this.service.obtenerClientePorId(id);
        clienteActual.setCliente(cliente.getCliente());
        clienteActual.setCelular(cliente.getCelular());
        this.service.guardarCliente(clienteActual);
        return clienteActual;
    }

    @DeleteMapping("/clientes/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        Cliente clienteActual = this.service.obtenerClientePorId(id);
        this.service.eliminarCliente(id);
    }
}
