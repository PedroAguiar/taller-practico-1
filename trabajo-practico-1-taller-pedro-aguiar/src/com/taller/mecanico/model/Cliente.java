package com.taller.mecanico.model;

public class Cliente extends Persona {
    private Vehiculo vehiculo;
    
    public Cliente() {
    }
    
    public Cliente(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
    
    public Cliente(int id, String nombre, String apellido, Vehiculo vehiculo) {
        super(id, nombre, apellido);
        this.vehiculo = vehiculo;
    }
    
    public Vehiculo getVehiculo() {
        return vehiculo;
    }
    
    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
}
