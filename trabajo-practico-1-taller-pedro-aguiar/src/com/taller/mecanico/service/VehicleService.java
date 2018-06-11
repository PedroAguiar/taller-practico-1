package com.taller.mecanico.service;

import com.taller.mecanico.lib.Validate;
import com.taller.mecanico.model.*;
import com.taller.mecanico.model.exception.VehicleTypeNotFound;
import com.taller.mecanico.view.MenuView;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;


public class VehicleService {

    private static UUID currentClient = null;

    public static final List<Vehiculo> vehiculos = new ArrayList<>();

    public static Automovil getRandomCar() {
        throw new NotImplementedException();
    }

    public static Motocicleta getRandomMotorbike() {
        throw new NotImplementedException();
    }

    public static void registerVehicle(UUID clientId) {
        currentClient = clientId;
        MenuView.displayVehicleRegistrationForm();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<String> parsedInput = parseInput(input);
        validateInput(parsedInput);
        Cliente cliente = ClientService.clientes.get(clientId);
        persistVehicle(cliente, parsedInput);
    }

    private static void persistVehicle(Cliente cliente, List<String> vehicleAttributes) {
        int vehicleTypeId = Integer.valueOf(vehicleAttributes.get(5));
        TipoDeVehiculo tipoDeVehiculo = null;
        try {
            tipoDeVehiculo = TipoDeVehiculo.findVehicleType(vehicleTypeId);
        } catch (VehicleTypeNotFound e) {
            System.out.println(e.getMessage());
            return;
        }
        String patente = vehicleAttributes.get(0);
        int cantidadDeCilindros = Integer.valueOf(vehicleAttributes.get(1));
        int litrosDelTanque = Integer.valueOf(vehicleAttributes.get(2));
        Encendido tipoDeEncendido = Encendido.findStartType(Integer.valueOf(vehicleAttributes.get(3)));
        boolean tieneAirbag = Boolean.valueOf(vehicleAttributes.get(4));
        List<Componente> componentes = getComponents(cantidadDeCilindros, litrosDelTanque);
        if (tieneAirbag) {
            componentes.add(new Airbag());
        }
        switch (tipoDeVehiculo) {
            case AUTOMOVIL:
                Automovil auutomovil = new Automovil(patente, componentes, tipoDeEncendido);
                System.out.println("Vehiculo registrado exitosamente" + auutomovil.toString());
                cliente.setVehiculo(auutomovil);
                vehiculos.add(auutomovil);
              break;
            case MOTOCICLETA:
                Motocicleta motocicleta = new Motocicleta(patente, componentes, tipoDeEncendido);
                System.out.println("Vehiculo registrado exitosamete" + motocicleta.toString());
                cliente.setVehiculo(motocicleta);
                vehiculos.add(motocicleta);
              break;
            default:
                throw new IllegalArgumentException(
                        String.format(
                                "Could not persist vehicle with attributes: patente= %s, cilindrada=%d, litrosDelTanque=%d, encendido= %d, airbag= %b",
                                patente, cantidadDeCilindros, litrosDelTanque, tipoDeEncendido.startTypeId, tieneAirbag
                        )
                );
        }

    }

    private static List<Componente> getComponents(int cantidadDeCilindros, int litrosDelTanque) {
        return Arrays.asList(new Motor(cantidadDeCilindros), new Tanque(litrosDelTanque));
    }

    private static void validateInput(List<String> input) {
        try {
            Validate.isValidPlate(input.get(0));
            Validate.containsOnlyNumbers(input.get(1));
            Validate.containsOnlyNumbers(input.get(2));
            Encendido.findStartType(Integer.valueOf(input.get(3)));
            Validate.isBoolean(input.get(4));
            TipoDeVehiculo.findVehicleType(Integer.valueOf(input.get(5)));
        } catch (IllegalArgumentException | VehicleTypeNotFound e) {
            System.out.println(e.getMessage());
            registerVehicle(currentClient);
        }
    }

    private static List<String> parseInput(String input) {
        String[] splitInput = input.split(",");
        try {
            Validate.isTrue(splitInput.length == 6);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            registerVehicle(currentClient);
        }
        String numeroDePatente = splitInput[0].trim();
        String cantidadDeCilindros = splitInput[1].trim();
        String cantidadDeListrosDelTanque = splitInput[2].trim();
        String tipoDeEncendido = splitInput[3].trim();
        String arreglarAirBags = splitInput[4].trim();
        String veihcleType = splitInput[5].trim();
        return Arrays.asList(numeroDePatente, cantidadDeCilindros, cantidadDeListrosDelTanque, tipoDeEncendido, arreglarAirBags, veihcleType);
    }

}
