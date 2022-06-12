package com.prueba.app.proyectoventas.model.dao;

import com.prueba.app.proyectoventas.model.entities.Producto;
import org.springframework.data.repository.CrudRepository;

public interface IProductoDao extends CrudRepository<Producto, Long> {
}
