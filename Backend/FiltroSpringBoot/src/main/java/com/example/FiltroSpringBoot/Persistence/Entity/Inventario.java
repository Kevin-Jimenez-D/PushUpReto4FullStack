package com.example.FiltroSpringBoot.Persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "Inventario")
public class Inventario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Cambiado a Long para reflejar el tipo de dato autoincrementable
    
    @Column(name = "cantidad", nullable = false)
    private long cantidad;
    
    //Relaciones
    //Llaves foraneas, manyToOne y trae objetos
    //No es llave foranea en otras tablas
    @ManyToOne
    @JoinColumn(name = "producto_id")
    @JsonIgnore
    private Producto producto_id;
    
    //Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
    
    //To String
    @Override
    public String toString() {
        return "Inventario{" + "id=" + id + ", cantidad=" + cantidad + ", producto_id=" + producto_id + '}';
    }
    
    
}
