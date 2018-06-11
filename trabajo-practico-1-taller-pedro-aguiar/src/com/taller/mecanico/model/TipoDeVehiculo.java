package com.taller.mecanico.model;

import com.taller.mecanico.model.exception.VehicleTypeNotFound;

public enum TipoDeVehiculo {
    AUTOMOVIL(1),
    MOTOCICLETA(2);

    public final int vehicleTypeId;

    TipoDeVehiculo(int vehicleTypeId) {
        this.vehicleTypeId = vehicleTypeId;
    }

    public static TipoDeVehiculo findVehicleType(int vehicleTypeId) throws VehicleTypeNotFound {
        for (TipoDeVehiculo vehicleType : TipoDeVehiculo.values()) {
            if (vehicleType.vehicleTypeId == vehicleTypeId) {
                return vehicleType;
            }
        }
        throw new VehicleTypeNotFound(String.format("There is no vehicle type with value: %d", vehicleTypeId));
    }
}
