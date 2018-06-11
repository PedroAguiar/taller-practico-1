package com.taller.mecanico.initializer;

import com.taller.mecanico.service.ClientService;
import com.taller.mecanico.service.VehicleService;
import com.taller.mecanico.view.MenuView;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.UUID;

/**
 * Program Executor, defines application business logic
 */
public class AppInitializer {
    
    /**
     * Executes the application business logic
     */
    public static void init() {
        MenuView.displayWelcomeForm();
        Scanner scanner = new Scanner(System.in);
        try {
            int input = scanner.nextInt();
            if (input == 1) {
                UUID clientId = ClientService.registerClient();
                VehicleService.registerVehicle(clientId);
            } else if (input != 0) {
                MenuView.displayRegistratedClientForm();
                Scanner scanner1 = new Scanner(System.in);
                int chosenOption = scanner1.nextInt();
                if (chosenOption == 1) {
                    ClientService.showCarRepairProgress(input);
                } else if (chosenOption == 2) {
                    ClientService.unRegisterClient(input);
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Datos invalidos, porfavor intentelo nuevamente");
            System.gc();
            init();
        }
    }
}
