package com.example.FiltroSpringBoot.Persistence.Entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "Producto")
public class Producto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(name = "nombre", nullable = true)
    private String nombre;
    
    @Column(name = "descripcion", nullable = true)
    private String descripcion;
    
    @Column(name = "imagen", nullable = true)
    private String imagen;
    
    @Column(name = "precio", nullable = true)
    private Double precio;
    
    //Relaciones
    //es llave foranea en otra tabla, One to many, y maneja una lista
    //Sin llaves foraneas propias
    @OneToMany(mappedBy = "producto_id", cascade = CascadeType.ALL)
    private List<Carrito> carritos;
    
    @OneToMany(mappedBy = "producto_id", cascade = CascadeType.ALL)
    private List<Inventario> inventarios;
    
    //Getters y Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public List<Carrito> getCarritos() {
        return carritos;
    }

    public void setCarritos(List<Carrito> carritos) {
        this.carritos = carritos;
    }

    public List<Inventario> getInventarios() {
        return inventarios;
    }

    public void setInventarios(List<Inventario> inventarios) {
        this.inventarios = inventarios;
    }
    
    //ToString
    @Override
    public String toString() {
        return "Producto{" + "id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", imagen=" + imagen + ", precio=" + precio + ", carritos=" + carritos + ", inventarios=" + inventarios + '}';
    }
    
    

}
