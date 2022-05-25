package com.idat.mayoservicioprueba.repository;

import com.idat.mayoservicioprueba.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {

}
