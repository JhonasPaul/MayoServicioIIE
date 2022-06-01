package com.idat.mayoservicioprueba.repository;

import com.idat.mayoservicioprueba.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {

}
