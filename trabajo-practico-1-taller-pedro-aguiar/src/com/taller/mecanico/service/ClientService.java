package com.taller.mecanico.service;

import com.taller.mecanico.lib.Validate;
import com.taller.mecanico.model.Cliente;
import com.taller.mecanico.view.MenuView;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class ClientService {

    public static final Map<UUID, Cliente> clientes = new ConcurrentHashMap<>();

    public static UUID registerClient() {
        MenuView.displayClientRegistrationForm();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<String> parsedInput = parseInput(input);
        String nombre = parsedInput.get(0);
        String apellido = parsedInput.get(1);
        String dni = parsedInput.get(2);
        try {
            validateRegisterClientInput(nombre, apellido, dni);
            return persistClient(nombre, apellido, Integer.valueOf(dni));
        } catch (IllegalArgumentException e) {
            registerClient();
        }
        return null;
    }

    private static void validateRegisterClientInput(String nombre, String apellido, String DNI) {
        Validate.notBlank(nombre, "Datos invalidos, Porfavor intentelo nuevamente");
        Validate.notBlank(apellido, "Datos invalidos, Porfavor intentelo nuevamente");
        Validate.notBlank(DNI, "Datos invalidos, Porfavor intentelo nuevamente");
        Validate.containsOnlyLetters(new String[]{nombre, apellido});
        Validate.isDNI(DNI);
    }

    private static List<String> parseInput(String input) {
        String[] splitInput = input.split(",");
        try {
            Validate.isTrue(splitInput.length == 3, "Datos invalidos, porfavor intentelo nuevamente.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            registerClient();
        }
        String nombre = splitInput[0].trim();
        String apellido = splitInput[1].trim();
        String dni = splitInput[2].trim();
        return Arrays.asList(nombre, apellido, dni);
    }

    private static UUID persistClient(String nombre, String appellido, int dni) {
        Cliente client = new Cliente(nombre, appellido, dni);
        clientes.putIfAbsent(client.getId(), client);
        System.out.println("Se ha registrado exitosamente: " + client.toString());
        return client.getId();
    }

    public static void showCarRepairProgress(int input) {
        Validate.isDNI(input);
        Collection<Cliente> clients = clientes.values();
        clients.forEach(client -> {
            if (client.getDni() == input) {
                System.out.println("Su vehiculo: " + client.getVehiculo().toString() + "esta siendo reparado actualmente.");
            }
        });
    }

    public static void unRegisterClient(int input) {
        clientes.values().removeIf(cliente -> cliente.getDni() == input);
    }
}
