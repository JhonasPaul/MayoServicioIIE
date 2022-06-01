package com.idat.mayoservicioprueba.controller;

import com.idat.mayoservicioprueba.model.Item;
import com.idat.mayoservicioprueba.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")/*url base*/
public class ItemController {
    @Autowired
    private ItemService service;

    @GetMapping("/items")
    public List<Item> index() {
        return service.listarItem();
    }


    @GetMapping("/items/{id}")
    public Item show(@PathVariable Integer id) {
        return this.service.obtenerItemPorId(id);
    }

    @PostMapping("/items")
    @ResponseStatus(HttpStatus.CREATED)
    public Item create(@RequestBody Item cliente) {
        this.service.guardarItem(cliente);
        return cliente;
    }

    @PutMapping("/items/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Item update(@RequestBody Item cliente, @PathVariable Integer id) {
        Item clienteActual = this.service.obtenerItemPorId(id);
        clienteActual.setIdItem(cliente.getIdItem());
        clienteActual.setCantidad(cliente.getCantidad());
        clienteActual.setTotal(cliente.getTotal());
        this.service.guardarItem(clienteActual);
        return clienteActual;
    }

    @DeleteMapping("/items/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        Item clienteActual = this.service.obtenerItemPorId(id);
        this.service.eliminarItem(id);
    }
}
