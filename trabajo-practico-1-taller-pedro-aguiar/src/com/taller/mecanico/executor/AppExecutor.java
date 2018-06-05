package com.taller.mecanico.executor;

import com.taller.mecanico.lib.Validate;
import com.taller.mecanico.view.MenuView;

import java.util.Scanner;

/**
 * Program Executor, defines application business logic
 */
public class AppExecutor {
    
    /**
     * Executes the application business logic
     */
    public static void execute() {
        MenuView.displayWelcomeForm();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        Validate.notBlank(input, "Porfavor escriba una oracion valida");
        if (input.toLowerCase().contains("deseo registrarme")) {
            registerClient();
        }
    }
    
    private static void registerClient() {
        MenuView.displayClientRegistrationForm();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        Validate.notBlank(input, "Datos invalidos, Porfavor intentelo nuevamente");
        String[] splittedInput = input.split(",");
        if (!splittedInput[2].matches("([a-zA-z]{2} [0-9]{3} [a-zA-Z]{2}|[a-zA-Z]{3} [0-9]{3})")) {
        
        }
        
        if (input.matches(".*,,[0-9]{8}"))
    }
}
