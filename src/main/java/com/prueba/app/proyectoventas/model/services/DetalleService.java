package com.prueba.app.proyectoventas.model.services;

import com.prueba.app.proyectoventas.model.dao.IDetalleDao;
import com.prueba.app.proyectoventas.model.entities.Detalle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleService implements IDetalleService {

    @Autowired
    private IDetalleDao detalleDao;

    @Override
    public List<Detalle> findAll() {
        return (List<Detalle>) detalleDao.findAll();
    }

    @Override
    public void save(Detalle detalle) {
        detalleDao.save(detalle);
    }

    @Override
    public Detalle findById(Long id) {
        return detalleDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Detalle detalle) {
        detalleDao.delete(detalle);
    }
}
