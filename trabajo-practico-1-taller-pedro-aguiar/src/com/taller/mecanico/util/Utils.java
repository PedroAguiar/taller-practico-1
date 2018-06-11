package com.taller.mecanico.util;

import com.taller.mecanico.model.*;
import com.taller.mecanico.service.VehicleService;

public final class Utils {

    /**
     * Utility class, private constructor
     */
    private Utils() {
    }


    public static Vehiculo getRandomVehicleInstance(TipoDeVehiculo tipoDeVehiculo) {
        switch (tipoDeVehiculo) {
            case AUTOMOVIL:
                return VehicleService.getRandomCar();
            case MOTOCICLETA:
                return VehicleService.getRandomMotorbike();
            default: throw new IllegalArgumentException("Tipo de Vehiculo no soportado");
        }
    }
}
