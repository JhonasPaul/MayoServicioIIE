package com.idat.mayoservicioprueba.repository;

import com.idat.mayoservicioprueba.model.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
