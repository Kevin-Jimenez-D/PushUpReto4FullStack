package com.example.FiltroSpringBoot.Persistence.Entity;

import jakarta.persistence.*;
import java.sql.Date;

import java.util.List;

@Entity
@Table(name = "Cuenta")
public class Cuenta {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(name = "tipo", nullable = false)
    private CuentaEnum tipo;
    
    @Column(name = "tarjeta",nullable = false)
    private String tarjeta;
    
    @Column(name = "cvv",nullable = false)
    private String cvv;
    
    @Column(name = "caducidad", nullable = false)
    private Date caducidad;
    
    //Relaciones
    //No tiene llaves foraneas, pero es llave foranea en otra tabla
    //One to many, y maneja una lista
    @OneToMany(mappedBy = "cuenta_id",cascade = CascadeType.ALL)
    private List<Factura> facturas;
    
    //Getters and Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public CuentaEnum getTipo() {
        return tipo;
    }

    public void setTipo(CuentaEnum tipo) {
        this.tipo = tipo;
    }

    public String getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(String tarjeta) {
        this.tarjeta = tarjeta;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public Date getCaducidad() {
        return caducidad;
    }

    public void setCaducidad(Date caducidad) {
        this.caducidad = caducidad;
    }

    public List<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<Factura> facturas) {
        this.facturas = facturas;
    }
    
    //To String
    @Override
    public String toString() {
        return "Cuenta{" + "id=" + id + ", tipo=" + tipo + ", tarjeta=" + tarjeta + ", cvv=" + cvv + ", caducidad=" + caducidad + ", facturas=" + facturas + '}';
    }
    

}
