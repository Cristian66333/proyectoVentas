package com.prueba.app.proyectoventas.model.dao;

import com.prueba.app.proyectoventas.model.entities.Factura;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IFacturaDao extends CrudRepository<Factura, Long> {
    @Query(value = "select c.id_cliente,CONCAT(c.nombre,' ',c.apellido), factura.numero_factura, sum(d.cantidad), sum(d.precio) from cliente c right join factura on c.id_cliente = factura.id_cliente right join detalle d on factura.numero_factura = d.id_factura group by factura.numero_factura ;", nativeQuery = true)
    List<Object> datosFactura();
}
