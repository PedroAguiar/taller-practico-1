package com.taller.mecanico.structure;

public class Nodo {

    private Object dato;
    private Nodo next;

    public Nodo() {
        this.dato = null;
        this.next = null;
    }

    public Nodo(Object dato) {
        this.dato = dato;
    }
    public Nodo(Object dato, Nodo nodo) {
        this.dato = dato;
        this.next = nodo;
    }

    public Object getDato() {
        return this.dato;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }

    public Nodo getNext() {
        return this.next;
    }

    public void setNext(Nodo node) {
        this.next = node;
    }

}
