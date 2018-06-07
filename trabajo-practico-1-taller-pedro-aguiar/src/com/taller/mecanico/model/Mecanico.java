package com.taller.mecanico.model;

import java.util.Set;

public class Mecanico extends Persona {
    private Set<Habilidad> habilidades;

    public Mecanico() {
    }

    public Mecanico(Set<Habilidad> habilidades) {
        this.habilidades = habilidades;
    }

    public Mecanico(int id, String nombre, String apellido, int dni, Set<Habilidad> habilidades) {
        super(id, nombre, apellido, dni);
        this.habilidades = habilidades;
    }
}
