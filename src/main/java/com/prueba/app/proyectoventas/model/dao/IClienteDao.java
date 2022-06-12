package com.prueba.app.proyectoventas.model.dao;

import com.prueba.app.proyectoventas.model.entities.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface IClienteDao extends CrudRepository<Cliente, Long> {

}
