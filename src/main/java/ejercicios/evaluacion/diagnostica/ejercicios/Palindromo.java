/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.evaluacion.diagnostica.ejercicios;

import java.util.Scanner;

/**
 *
 * @author Saul Espinosa Rios
 */
public class Palindromo {
    
    public static void ejecutar(Scanner scanner) {
        
        String palabra;
        String continuar;
        
        do{
            System.out.println("Ingrese una palabra: ");
            palabra = scanner.nextLine().replaceAll("\\s", "").toLowerCase();
        
            if (esPalindromo(palabra)){
                System.out.println("Es palíndromo");
            }
            else{
                System.out.println("No es palíndromo");
            }
            System.out.println("""
                               ¿Desea regresar?
                               1.- Si
                               2.- No""");
            continuar = scanner.nextLine().replaceAll("\\s", "").toLowerCase();
        }while(("2".equals(continuar)) || ("no".equals(continuar)));
        
    }
    
    private static boolean esPalindromo(String texto){
        int longitud = texto.length();
        int izquierda = 0;
        int derecha = longitud - 1;
        
        while(izquierda <= derecha){
            if (texto.charAt(izquierda) == texto.charAt(derecha)){
                izquierda += 1;
                derecha -= 1;
            }
            else{
                return false;
            }
        }
        return true;
    }
    
}
