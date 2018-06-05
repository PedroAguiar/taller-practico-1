package com.taller.mecanico.model;

import java.util.List;
import java.util.UUID;

public abstract class Vehiculo {
    
    private UUID vin = UUID.randomUUID();
    private String patente;
    private List<Componente> componentes;
    private Encendido encendido;
    
    public Vehiculo() {
    }
    
    public Vehiculo(String patente, List<Componente> componentes, Encendido encendido) {
        this.patente = patente;
        this.componentes = componentes;
        this.encendido = encendido;
    }
    
    public UUID getVin() {
        return vin;
    }
    
    public String getPatente() {
        return patente;
    }
    
    public void setPatente(String patente) {
        this.patente = patente;
    }
    
    public List<Componente> getComponentes() {
        return componentes;
    }
    
    public void setComponentes(List<Componente> componentes) {
        this.componentes = componentes;
    }
    
    public Encendido getEncendido() {
        return encendido;
    }
    
    public void setEncendido(Encendido encendido) {
        this.encendido = encendido;
    }
}
