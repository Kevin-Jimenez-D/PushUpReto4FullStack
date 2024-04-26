package com.example.FiltroSpringBoot.Persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "CelularPersonal")
public class CelularPersonal {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Cambiado a Long para reflejar el tipo de dato autoincrementable
    
    @Column(name = "celular", nullable = false,unique = true)
    private String celular;
    
    //Relaciones
    //Llaves foraneas, manyToOne y trae objetos
    //No es llave foranea en otras tablas
    @ManyToOne
    @JoinColumn(name = "personal_id")
    @JsonIgnore
    private Personal personal_id;
    
    //Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Personal getPersonal_id() {
        return personal_id;
    }

    public void setPersonal_id(Personal personal_id) {
        this.personal_id = personal_id;
    }
    
    //ToString
    @Override
    public String toString() {
        return "CelularPersonal{" + "id=" + id + ", celular=" + celular + ", personal_id=" + personal_id + '}';
    }
    
    

}
