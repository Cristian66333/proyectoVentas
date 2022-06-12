package com.prueba.app.proyectoventas.controller;

import com.prueba.app.proyectoventas.model.entities.*;
import com.prueba.app.proyectoventas.model.services.IClienteService;
import com.prueba.app.proyectoventas.model.services.IDetalleService;
import com.prueba.app.proyectoventas.model.services.IFacturaService;
import com.prueba.app.proyectoventas.model.services.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectSerializer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class VentasRestController {

    public long facturaActual;
    public long clienteActual=235215;

    @Autowired
    private IClienteService clienteService;
    @Autowired
    private IProductoService productoService;
    @Autowired
    private IFacturaService facturaService;
    @Autowired
    private IDetalleService detalleService;

    //Petición para visualizar todos los clientes
    @GetMapping("/clientes")
    public List<Cliente> index(){
        return clienteService.findAll();
    }

    //Petición para visualizar todos los productos
    @GetMapping("/productos")
    public List<Producto> getProductos(){
        return productoService.findAll();
    }

    //Petición para visualizar todas las facturas existentes
    @GetMapping("/facturas")
    public List<Factura> getFacturas(){
        return facturaService.findAll();
    }

    //petición para crear una nueva factura
    @PutMapping("/nuevaFactura")
    public Factura crearFactura(){
        Factura factura=new Factura();
        factura.setNumeroFactura(0);
        factura.setCliente(clienteService.findById(clienteActual));
        factura.setFecha(new Date());

        facturaService.save(factura);
        this.facturaActual=factura.getNumeroFactura();
        return factura;
    }

    //Petición para crear detalles
    @PostMapping(path = "/crearDetalle")
    public ResponseEntity<Detalle> createDetalle(@RequestBody String[] datos){
        Producto producto=productoService.findById(Long.valueOf(datos[1]));
        System.out.println(facturaActual);
        this.clienteActual=clienteService.findById(Long.valueOf(datos[0])).getIdCliente();
        Factura factura= facturaService.findById(facturaActual)==null? crearFactura() : facturaService.findById(facturaActual);

        Detalle detalle= new Detalle();
        detalle.setCantidad(Integer.parseInt(datos[2]));
        detalle.setProducto(producto);
        detalle.setFactura(factura);
        detalle.setPrecio(Integer.parseInt(datos[2])*producto.getPrecio());
        detalle.setNumeroDetalle(0);
        producto.setStock(producto.getStock()-Integer.parseInt(datos[2]));
        detalleService.save(detalle);
        return new ResponseEntity<>(detalle, HttpStatus.CREATED);
    }

    //petición para devolver información de los detalles de una factura
    @GetMapping("/detallesFactura")
    public List<Object> detallesFactura(){

        return facturaService.datosFactura();
    }



}
