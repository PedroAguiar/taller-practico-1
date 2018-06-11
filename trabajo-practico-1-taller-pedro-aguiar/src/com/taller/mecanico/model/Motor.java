package com.taller.mecanico.model;

public class Motor extends Componente {
    private int cilindros;
    
    public Motor() {
    }
    
    public Motor(int cilindros) {
        this.cilindros = cilindros;
    }
    
    public int getCilindros() {
        return cilindros;
    }
    
    public void setCilindros(int cilindros) {
        this.cilindros = cilindros;
    }

    @Override
    public String toString() {
        return "Motor{" +
                "cilindros= " + this.getCilindros() +
                "}";
    }
}
