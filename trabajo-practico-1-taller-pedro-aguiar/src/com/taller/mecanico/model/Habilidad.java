package com.taller.mecanico.model;

public enum Habilidad {
    ARREGLA_AIRBAG(1);

    public final int abilityId;

    Habilidad(int abilityId) {
        this.abilityId = abilityId;
    }

    public static Habilidad findHabilitytType(int abilityId) throws IllegalArgumentException {
        for (Habilidad ability : Habilidad.values()) {
            if (ability.abilityId == abilityId) {
                return ability;
            }
        }
        throw new IllegalArgumentException(String.format("There is no ability type with value: %d", abilityId));
    }
}
