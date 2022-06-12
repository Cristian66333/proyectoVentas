package com.prueba.app.proyectoventas.model.dao;

import com.prueba.app.proyectoventas.model.entities.Detalle;
import org.springframework.data.repository.CrudRepository;

public interface IDetalleDao extends CrudRepository<Detalle, Long> {
}
