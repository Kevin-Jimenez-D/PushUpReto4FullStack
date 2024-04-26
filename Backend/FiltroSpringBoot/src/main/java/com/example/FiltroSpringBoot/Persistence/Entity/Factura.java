package com.example.FiltroSpringBoot.Persistence.Entity;

import jakarta.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Factura")
public class Factura {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(name = "fecha", nullable = false)
    private Date fecha;
    
    @Column(name = "estado", nullable = false)
    private CuentaEnum estado;
    
    //Relaciones
    //Llaves foraneas, manyToOne y trae objetos
    @ManyToOne
    @JoinColumn(name = "personal_ID")
    @JsonIgnore
    private Personal personal_ID;
    
    @ManyToOne
    @JoinColumn(name = "cliente_ID")
    @JsonIgnore
    private Cliente cliente_ID;
    
    @ManyToOne
    @JoinColumn(name = "cuenta_id")
    @JsonIgnore
    private Cuenta cuenta_id;
    
    //Muchos a muchos relación
    //es llave foranea en otra tabla, One to many, y maneja una lista
    @OneToMany(mappedBy = "factura_id", cascade = CascadeType.ALL)
    private List<Carrito> carritos;
    
//NOTA: Falta cantidad que esta en la base de datos y debo agregarlo    
//    @JoinTable(
//        name = "Carrito",
//        joinColumns = @JoinColumn(name = "factura_id",nullable = false),
//        inverseJoinColumns = @JoinColumn(name = "producto_id",nullable = false)
//        )
//    @ManyToMany(cascade = CascadeType.ALL)
//    private List<Producto> productos;
//    
//    //Agregar un producto en la tabla muchos a muchos
//    public void addProductos(Producto producto){
//        if(this.productos == null){
//            this.productos = new ArrayList<>();
//        }
//        this.productos.add(producto);
//    }
    
    //Getters y Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public CuentaEnum getEstado() {
        return estado;
    }

    public void setEstado(CuentaEnum estado) {
        this.estado = estado;
    }

    public Personal getPersonal_ID() {
        return personal_ID;
    }

    public void setPersonal_ID(Personal personal_ID) {
        this.personal_ID = personal_ID;
    }

    public Cliente getCliente_ID() {
        return cliente_ID;
    }

    public void setCliente_ID(Cliente cliente_ID) {
        this.cliente_ID = cliente_ID;
    }

    public Cuenta getCuenta_id() {
        return cuenta_id;
    }

    public void setCuenta_id(Cuenta cuenta_id) {
        this.cuenta_id = cuenta_id;
    }

    public List<Carrito> getCarritos() {
        return carritos;
    }

    public void setCarritos(List<Carrito> carritos) {
        this.carritos = carritos;
    }

    //ToString
    @Override
    public String toString() {
        return "Factura{" + "id=" + id + ", fecha=" + fecha + ", estado=" + estado + ", personal_ID=" + personal_ID + ", cliente_ID=" + cliente_ID + ", cuenta_id=" + cuenta_id + ", carritos=" + carritos + '}';
    }
    
    
}
