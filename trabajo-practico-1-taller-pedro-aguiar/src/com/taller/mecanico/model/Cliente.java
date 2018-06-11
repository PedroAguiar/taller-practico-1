package com.taller.mecanico.model;

import com.taller.mecanico.util.Utils;

import java.util.UUID;

public class Cliente extends Persona {
    private Vehiculo vehiculo;
    
    public Cliente() {
    }
    
    public Cliente(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Cliente(String nombre, String apellido, int dni, Vehiculo vehiculo) {
        super(nombre, apellido, dni);
        this.vehiculo = vehiculo;
    }
    public Cliente(UUID id, String nombre, String apellido, int dni, TipoDeVehiculo tipoDeVehiculo) {
        super(nombre, apellido, dni);
        this.vehiculo = Utils.getRandomVehicleInstance(tipoDeVehiculo);
    }

    public Cliente(String nombre, String appellido, int dni) {
        super(nombre, appellido, dni);
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id= " + this.getId() + ", " +
                "nombre= " + this.getNombre() + ", " +
                "apellido= " + this.getApellido() + ", " +
                "dni= " + this.getDni() + ", " +
                "vehiculo= " + this.getVehiculo() +
                "} ";
    }
}
