package com.taller.mecanico.structure;

import com.taller.mecanico.structure.exception.DesbordamientoInferior;

public class Pila {

    private Nodo top;
    private int size;

    public Pila() {
        this.top = null;
        this.size = 0;
    }

    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.top == null;
    }

    public void put(Object o) {
        this.top = new Nodo(o, this.top);
        this.size++;
    }

    public Object getTop() throws DesbordamientoInferior {
        if (isEmpty()) {
            throw new DesbordamientoInferior("La pila esta vacia.");
        }
        return top.getDato();
    }

    public Object pop() throws DesbordamientoInferior {
        if (isEmpty()) {
            throw new DesbordamientoInferior("La pila esta vacia.");
        }
        Object temp = top.getDato();
        top = top.getNext();
        size--;
        return temp;
    }
}
