package com.example.FiltroSpringBoot.Persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "CorreosPersonal")
public class CorreosPersonal {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Cambiado a Long para reflejar el tipo de dato autoincrementable

    @Column(name = "correoElectronico", nullable = false,unique = true)
    private String correoElectronico;
    
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

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
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
        return "CorreosPersonal{" + "id=" + id + ", correoElectronico=" + correoElectronico + ", personal_id=" + personal_id + '}';
    }
    

}
