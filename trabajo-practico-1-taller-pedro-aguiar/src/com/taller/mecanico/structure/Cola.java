package com.taller.mecanico.structure;

import com.taller.mecanico.structure.exception.DesbordamientoInferior;

public class Cola {

    private Nodo first;
    private Nodo last;

    public Cola() {
        first = new Nodo();
        last = new Nodo();
    }

    public Cola(Nodo first, Nodo last) {
        this.first = null;
        this.last = null;
    }

    public void put(Object x) {
        Nodo nuevo = new Nodo(x);
        if (first.getNext() == null) {
            first.setNext(nuevo);
        } else {
            last.getNext().setNext(nuevo);
        }
        last.setNext(nuevo);
    }

    public boolean isEmpty() {
        boolean aux = false;
        if (first.getNext() == null) {
            aux = true;
        }
        return aux;
    }

    public void clear() {
        first.setNext(null);
        last.setNext(null);
    }

    public Object getFirst() throws DesbordamientoInferior {
        if (isEmpty()) {
            throw new DesbordamientoInferior("La cola está vacía.");
        }
        return first.getNext().getDato();
    }

    public Object removeFirst() throws DesbordamientoInferior {
        if (isEmpty()) {
            throw new DesbordamientoInferior("La cola está vacía.");
        } else {
            first.setNext(first.getNext().getNext());
            if (first.getNext() == null) {
                last.setNext(null);
            }
        }
        return first.getNext().getDato();
    }
}
