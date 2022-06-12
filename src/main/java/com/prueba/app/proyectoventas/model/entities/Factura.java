package com.prueba.app.proyectoventas.model.entities;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "FACTURA")
public class Factura implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numero_factura", nullable = false, updatable = false)
    private long numeroFactura;

    @JoinColumn(name = "id_cliente", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Cliente cliente;

    @Temporal(TemporalType.DATE)
    private Date fecha;

    public long getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(long numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
