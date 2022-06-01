package com.idat.mayoservicioprueba.service;

import com.idat.mayoservicioprueba.model.Item;
import com.idat.mayoservicioprueba.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService implements iItemService{
    @Autowired
    private ItemRepository repository;
    @Override
    public Item guardarItem(Item item) {
        return repository.save(item);
    }

    @Override
    public void eliminarItem(int id) {
        repository.deleteById(id);
    }

    @Override
    public List<Item> listarItem() {
        return repository.findAll();
    }

    @Override
    public Item obtenerItemPorId(int id) {
        return repository.findById(id).orElse(null);
    }
}
