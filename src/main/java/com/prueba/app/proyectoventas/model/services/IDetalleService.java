package com.prueba.app.proyectoventas.model.services;

import com.prueba.app.proyectoventas.model.entities.Cliente;
import com.prueba.app.proyectoventas.model.entities.Detalle;

import java.util.List;

public interface IDetalleService {
    public List<Detalle> findAll();

    public void save(Detalle detalle);

    public Detalle findById(Long id);

    public void delete(Detalle detalle);

}
