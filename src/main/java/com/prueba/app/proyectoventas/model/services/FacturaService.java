package com.prueba.app.proyectoventas.model.services;

import com.prueba.app.proyectoventas.model.dao.IFacturaDao;
import com.prueba.app.proyectoventas.model.entities.Factura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FacturaService implements IFacturaService{

    @Autowired
    private IFacturaDao facturaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Factura> findAll() {
        return (List<Factura>) facturaDao.findAll();
    }

    @Override
    @Transactional
    public void save(Factura factura) {
        facturaDao.save(factura);
    }

    @Override
    @Transactional(readOnly = true)
    public Factura findById(Long id) {
        return facturaDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(Factura factura) {
        facturaDao.delete(factura);
    }

    @Override
    public List<Object> datosFactura() {
        return facturaDao.datosFactura();
    }
}
