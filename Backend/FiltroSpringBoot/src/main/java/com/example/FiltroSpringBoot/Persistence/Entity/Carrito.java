package com.example.FiltroSpringBoot.Persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "Carrito")
public class Carrito {
    
    @Column(name = "cantidad", nullable = false)
    private long cantidad;
    
    //Relaciones
    //Llaves foraneas, manyToOne y trae objetos
    //No es llave foranea en otras tablas
    @ManyToOne
    @JoinColumn(name = "producto_id")
    @JsonIgnore
    private Producto producto_id;
    
    @Id
    @ManyToOne
    @JoinColumn(name = "factura_id")
    @JsonIgnore
    private Factura factura_id;
    
    //Getters y Setters
    public long getCantidad() {
        return cantidad;
    }

    public void setCantidad(long cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getProducto_id() {
        return producto_id;
    }

    public void setProducto_id(Producto producto_id) {
        this.producto_id = producto_id;
    }

    public Factura getFactura_id() {
        return factura_id;
    }

    public void setFactura_id(Factura factura_id) {
        this.factura_id = factura_id;
    }
    
    //ToString
    @Override
    public String toString() {
        return "Carrito{" + "cantidad=" + cantidad + ", producto_id=" + producto_id + ", factura_id=" + factura_id + '}';
    }
    
    
}
