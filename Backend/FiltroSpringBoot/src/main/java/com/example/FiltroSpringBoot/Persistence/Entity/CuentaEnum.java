package com.example.FiltroSpringBoot.Persistence.Entity;

public enum CuentaEnum {

    DEBITO("debito"),
    CREDITO("credito");

    private String name;

    //Constructor para que no de error
    private CuentaEnum(String name) {
        this.name = name;
    }
    
    //Getters y Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    //ToString por si acaso
    @Override
    public String toString() {
        return "CuentaEnum{" + "name=" + name + '}';
    }
    
    

}
