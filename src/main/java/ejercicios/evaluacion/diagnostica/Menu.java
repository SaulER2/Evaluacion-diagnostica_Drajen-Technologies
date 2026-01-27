/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.evaluacion.diagnostica;

import ejercicios.evaluacion.diagnostica.ejercicios.*;
import java.util.Scanner;

/**
 *
 * @author Saul Espinosa Rios
 */
public class Menu {
    
    private final Scanner scanner = new Scanner(System.in);
    
    public void iniciar(){
        String opcion;
        
        do{
            mostrarOpciones();
            opcion = scanner.nextLine().toLowerCase();
            
            switch(opcion){
                case "1", "palindromo", "palíndromo" -> Palindromo.ejecutar(scanner);
            }
        }while(!opcion.equals("salir"));
    }
    
    private void mostrarOpciones(){
        System.out.println("""
                           =========EJERCICIOS=========
                           ===Selecciona una opción===
                           1.- Palíndromo
                           2.- Edad exacta
                           3.- Generar contraeña
                           4.- Ahorcado
                           5.- Fibonacci
                           6.- CRUD
                           Escribe 'salir' para terminar""");
    }
}
