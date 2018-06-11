package com.taller.mecanico.model;

import java.util.List;

public class Automovil extends Vehiculo {

    public Automovil() {
    }

    public Automovil(String patente, List<Componente> componentes, Encendido encendido) {
        super(patente, componentes, encendido);
    }

    @Override
    public String toString() {
        return "Automovil{" +
                "vin= " + this.getVin() + ", " +
                "patente= " + this.getPatente() + ", " +
                "componentes= " + this.getComponentes().toString() + ", " +
                "endendido= " + this.getEncendido().name() +
                "}";
    }
}
