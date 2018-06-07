package com.taller.mecanico.service;

import com.taller.mecanico.lib.Validate;
import com.taller.mecanico.model.Cliente;
import com.taller.mecanico.model.TipoDeVehiculo;
import com.taller.mecanico.util.Utils;
import com.taller.mecanico.view.MenuView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ClientService {

    private static final List<Cliente> clientes = new ArrayList<Cliente>();

    public static void registerClient() {
        MenuView.displayClientRegistrationForm();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        Validate.notBlank(input, "Datos invalidos, Porfavor intentelo nuevamente");
        String[] splitInput = input.split(",");
        String nombre = splitInput[0];
        String apellido = splitInput[1];
        String dni = splitInput[2];
        String tipoDeVehiculo = splitInput[3];
        Validate.containsOnlyLetters(new String[]{nombre, apellido, tipoDeVehiculo});
        Validate.isDNI(dni);
        persistClient(nombre, apellido, Integer.valueOf(dni), tipoDeVehiculo);
    }

    private static void persistClient(String nombre, String appellido, int dni, String tipoDeVehiculo) {
        TipoDeVehiculo tipoDeVehiculoValue = Utils.getVehicleType(tipoDeVehiculo);
        Cliente client = new Cliente(new Random().nextInt(), nombre, appellido, dni, Utils.getRandomVehicleInstance(tipoDeVehiculoValue));
        clientes.add(client);
    }
}
