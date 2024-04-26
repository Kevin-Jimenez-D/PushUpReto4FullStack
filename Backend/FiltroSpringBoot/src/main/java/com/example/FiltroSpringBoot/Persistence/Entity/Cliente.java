package com.example.FiltroSpringBoot.Persistence.Entity;

import jakarta.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "Cliente")
public class Cliente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(name = "identificacion", nullable = false, unique = true)
    private String identificacion;
    
    @Column(name = "celular", nullable = false, unique = true)
    private String celular;
    
    @Column(name = "correo", nullable = false, unique = true)
    private String correo;
    
    @Column(name = "nombre2", nullable = true)
    private String nombre2;
    
    @Column(name = "apellido2", nullable = true)
    private String apellido2;
    
    @Column(name = "nombre1", nullable = false)
    private String nombre1;
    
    @Column(name = "apellido1", nullable = false)
    private String apellido1;
    
    @Column(name = "nacimiento", nullable = false)
    private Date nacimiento;
    
    @Column(name = "sexo", nullable = false)
    private String sexo;
    
    @Column(name = "direccion", nullable = false)
    private String direccion;
    
    //Relaciones
    //es llave foranea en otra tabla, One to many, y maneja una lista
    //Sin llaves foraneas propias
    @OneToMany(mappedBy = "cliente_ID", cascade = CascadeType.ALL)
    private List<Factura> facturas;
    
    //Getters y Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre2() {
        return nombre2;
    }

    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getNombre1() {
        return nombre1;
    }

    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public Date getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(Date nacimiento) {
        this.nacimiento = nacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<Factura> facturas) {
        this.facturas = facturas;
    }
    
    //ToString
    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", identificacion=" + identificacion + ", celular=" + celular + ", correo=" + correo + ", nombre2=" + nombre2 + ", apellido2=" + apellido2 + ", nombre1=" + nombre1 + ", apellido1=" + apellido1 + ", nacimiento=" + nacimiento + ", sexo=" + sexo + ", direccion=" + direccion + ", facturas=" + facturas + '}';
    }
    

}
