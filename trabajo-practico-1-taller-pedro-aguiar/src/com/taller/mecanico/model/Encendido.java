package com.taller.mecanico.model;

public enum Encendido {
    MANUAL(1),
    ELECTRONICO(2);

    public final int startTypeId;

    Encendido(int startTypeId) {
        this.startTypeId = startTypeId;
    }

    public static Encendido findStartType(int startTypeId) throws IllegalArgumentException {
        for (Encendido startType : Encendido.values()) {
            if (startType.startTypeId == startTypeId) {
                return startType;
            }
        }
        throw new IllegalArgumentException(String.format("There is no start type with value: %d", startTypeId));
    }
}
