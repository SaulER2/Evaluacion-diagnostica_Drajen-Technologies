/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.evaluacion.diagnostica;

import java.util.Scanner;

/**
 *
 * @author Saul Espinosa Rios
 */
public class EntradaContinuar {

    public static String continuar(Scanner scanner){
        while(true){
            System.out.print("¿Desea continuar (s/n): ");
            String respuesta = scanner.nextLine().trim().toLowerCase();
            
            if (respuesta.equals("s") || respuesta.equals("si") || respuesta.equals("sí")) {
                return "s";
            }
            if (respuesta.equals("n") || respuesta.equals("no")) {
                return "n";
            }

            System.out.println("Respuesta inválida. Por favor, ingrese 's' o 'n'.");
        }
    }
}
