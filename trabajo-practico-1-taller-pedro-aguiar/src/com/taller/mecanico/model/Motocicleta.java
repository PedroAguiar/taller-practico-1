package com.taller.mecanico.model;

import java.util.List;

public class Motocicleta extends Vehiculo {

    public Motocicleta() {
    }

    public Motocicleta(String patente, List<Componente> componentes, Encendido tipoDeEncendido) {
        super(patente, componentes, tipoDeEncendido);
    }

    @Override
    public String toString() {
        return "Motocicleta{" +
                "vin= " + this.getVin() + ", " +
                "patente= " + this.getPatente() + ", " +
                "componentes= " + this.getComponentes().toString() + ", " +
                "endendido= " + this.getEncendido().name() +
                "}";
    }
}
