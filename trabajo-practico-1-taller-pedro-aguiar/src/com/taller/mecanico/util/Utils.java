package com.taller.mecanico.util;

import com.taller.mecanico.model.*;
import com.taller.mecanico.service.VehicleService;

public final class Utils {

    /**
     * Utility class, private constructor
     */
    private Utils() {
    }

    /**
     * Returns a {@link Vehiculo} instance depending on the method argument
     * @param tipoDeVehiculo string that represents a {@link TipoDeVehiculo}
     * @return
     */
    public static TipoDeVehiculo getVehicleType(String tipoDeVehiculo) {
        return TipoDeVehiculo.valueOf(tipoDeVehiculo.toLowerCase());
    }

    public static Vehiculo getRandomVehicleInstance(TipoDeVehiculo tipoDeVehiculo) {
        switch (tipoDeVehiculo) {
            case AUTOMOVIL:
                return VehicleService.getRandomCar();
                break;
            case MOTOCICLETA:
                return VehicleService.getRandomMotorbike();
                break;
            default: throw new IllegalArgumentException("Tipo de Vehiculo no soportado");
        }
    }
}
