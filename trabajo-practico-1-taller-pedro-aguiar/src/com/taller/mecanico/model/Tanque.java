package com.taller.mecanico.model;

public class Tanque extends Componente {
    private int litros;

    public Tanque() {
    }

    public Tanque(int litros) {
        this.litros = litros;
    }

    public int getLitros() {
        return litros;
    }

    public void setLitros(int litros) {
        this.litros = litros;
    }

    @Override
    public String toString() {
        return "Tanque{" +
                "litros= " + this.getLitros() +
                "}";
    }
}
