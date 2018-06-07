package com.taller.mecanico.view;

import com.taller.mecanico.model.Automovil;
import com.taller.mecanico.model.Motocicleta;

/**
 * This class provides common menu forms, should not handle any business logic
 */
public class MenuView {

    /**
     * Constructor, this class should not normally be instantiated
     */
    public MenuView() { super();}
    
    
    public static void displayWelcomeForm() {
        System.out.println("Bienvenido a nuestro taller mecanico");
        System.out.println("Si usted ya es uno de nuestros clientes porfavor ingrese su DNI de lo contrario escriba 'Deseo registrarme'");
    }
    
    public static void displayClientRegistrationForm() {
        System.out.println("Porfavor escriba la siguiente informacion sparada por comas");
        System.out.println("1) Nombre");
        System.out.println("2) Apellido");
        System.out.println("3) DNI");
        System.out.println("4) Tipo de Vehiculo, valores posibles:" +
                Automovil.class.getSimpleName() + ", " +
                Motocicleta.class.getSimpleName());
    }
    
    public static void displayVehicleRegistrationForm() {
        System.out.println("Antes de proceder a arreglar su vehiculo neceitamos los siguentes datos:");
        System.out.println("1) Numbero de patente");
        System.out.println("2) Cantidad de cilindros");
        System.out.println("3) Cantidad de litros en el tanque");
        System.out.println("4) Tipo de encendido del vehiculo");
        System.out.println("5) Es necesario arreglar los airbags?");
    }
    
    public static void displayClientUnregistrationForm() {
        System.out.println("Esperamos nuestro servicio haya sido de su agrado");
        System.out.println("Porfavor, provea su DNI para proceder");
    }
    
    public static void dislayVehicleStatusForm(String client, String vehicleState) {
        System.out.println("Buenas " + client + "su vehiculo esta actualmente " + vehicleState + ".");
    }
}
