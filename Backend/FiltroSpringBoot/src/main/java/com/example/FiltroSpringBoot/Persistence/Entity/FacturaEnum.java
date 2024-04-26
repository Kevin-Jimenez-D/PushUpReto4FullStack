package com.example.FiltroSpringBoot.Persistence.Entity;

public enum FacturaEnum {
    
    PROCESO("proceso"),
    PAGADO("pagado");
    
    private String name;
    
    //Constructor para que no arroje error
    private FacturaEnum(String name) {
        this.name = name;
    }
    
    //Getters y Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    //To String
    @Override
    public String toString() {
        return "FacturaEnum{" + "name=" + name + '}';
    }
    

}
