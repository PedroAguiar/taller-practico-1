package com.taller.mecanico.model;

import com.taller.mecanico.util.Utils;

public class Cliente extends Persona {
    private Vehiculo vehiculo;
    
    public Cliente() {
    }
    
    public Cliente(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Cliente(int id, String nombre, String apellido, int dni, Vehiculo vehiculo) {
        super(id, nombre, apellido, dni);
        this.vehiculo = vehiculo;
    }
    public Cliente(int id, String nombre, String apellido, int dni, TipoDeVehiculo tipoDeVehiculo) {
        super(id, nombre, apellido, dni);
        this.vehiculo = Utils.getRandomVehicleInstance(tipoDeVehiculo);
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
}
