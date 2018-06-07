package com.taller.mecanico.initializer;

import com.taller.mecanico.lib.Validate;
import com.taller.mecanico.service.ClientService;
import com.taller.mecanico.view.MenuView;

import java.util.Scanner;

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
        String input = scanner.next();
        Validate.notBlank(input, "Porfavor escriba una oracion valida");
        if (input.toLowerCase().contains("deseo registrarme")) {
            ClientService.registerClient();
        }
    }
    

}
