package com.idat.mayoservicioprueba.repository;

import com.idat.mayoservicioprueba.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {

}
