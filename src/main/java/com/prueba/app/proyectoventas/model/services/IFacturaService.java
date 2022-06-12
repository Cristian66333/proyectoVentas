package com.prueba.app.proyectoventas.model.services;

import com.prueba.app.proyectoventas.model.entities.Factura;

import java.util.List;

public interface IFacturaService {
    public List<Factura> findAll();

    public void save(Factura factura);

    public Factura findById(Long id);

    public void delete(Factura factura);

    public List<Object> datosFactura();

}
