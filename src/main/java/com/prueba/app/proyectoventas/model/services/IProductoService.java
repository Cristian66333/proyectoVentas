package com.prueba.app.proyectoventas.model.services;

import com.prueba.app.proyectoventas.model.entities.Cliente;
import com.prueba.app.proyectoventas.model.entities.Producto;

import java.util.List;

public interface IProductoService {
    public List<Producto> findAll();

    public void save(Producto producto);

    public Producto findById(Long id);

    public void delete(Producto producto);

}
