package com.idat.mayoservicioprueba.service;

import com.idat.mayoservicioprueba.model.Item;

import java.util.List;

public interface iItemService {
    Item guardarItem(Item item);
    //    void actualizarProducto(Item producto);
    void eliminarItem(int id);
    List<Item> listarItem();
    Item obtenerItemPorId(int id);
}
