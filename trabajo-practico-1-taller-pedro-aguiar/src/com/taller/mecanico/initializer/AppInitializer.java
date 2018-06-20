package com.taller.mecanico.initializer;

import com.taller.mecanico.service.ClientService;
import com.taller.mecanico.service.VehicleService;
import com.taller.mecanico.view.MenuView;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Program Executor, defines application business logic
 */
public class AppInitializer {
    
    /**
     * Executes the application business logic
     */
    public static void init() {
        while (true) {
            MenuView.displayWelcomeForm();
            Scanner scanner = new Scanner(System.in);
            try {
                int input = scanner.nextInt();
                if (input == 1) {
                    Integer clientDni = ClientService.registerClient();
                    VehicleService.registerVehicle(clientDni);
                } else if (input != 0) {
                    MenuView.displayRegistratedClientForm();
                    Scanner scanner1 = new Scanner(System.in);
                    int chosenOption = scanner1.nextInt();
                    if (chosenOption == 1) {
                        ClientService.showCarRepairProgress(input);
                    } else if (chosenOption == 2) {
                        ClientService.unRegisterClient(input);
                    }
                } else if (input == 0) {
                    System.exit(0);
                }
            } catch (InputMismatchException e) {
                System.out.println("Datos invalidos, porfavor intentelo nuevamente");
            }
        }
    }
}
