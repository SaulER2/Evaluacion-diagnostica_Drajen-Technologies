/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.evaluacion.diagnostica.ejercicios;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Saul Espinosa Rios
 */
public class GeneradorContraseñas {

    public static void ejecutar(Scanner scanner) {

        String mayusculas = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String minusculas = "abcdefghijklmnopqrstuvwxyz";
        String numeros = "0123456789";
        String simbolos = "!@#$%^&*()-_=+[]{}|;:,.<>?/";
        String todosCaracteres = mayusculas + minusculas + numeros + simbolos;
        SecureRandom random = new SecureRandom();
        int longitud;
        String continuar = "s";

        do {
            System.out.print("Ingrese la longitud deseada para la contraseña (al menos 8): ");
            longitud = scanner.nextInt();
            scanner.nextLine();

            if (longitud < 8) {
                System.out.println("La contraseña debe tener al menos 8 caracteres.");
                continue;
            }

            System.out.println("Contraseña generada: "
                    + generarCaracteres(longitud, mayusculas, numeros, simbolos, todosCaracteres, random));

            System.out.print("¿Desea generar otra contraseña? (s/n): ");
            continuar = scanner.nextLine().toLowerCase();
        } while (("s".equals(continuar)) || ("si".equals(continuar)) || ("sí".equals(continuar)));

    }

    private static String generarCaracteres(int longitud, String mayusculas, String numeros, String simbolos,
            String todosCaracteres, SecureRandom random) {

        List<Character> contraseña = new ArrayList<>();

        contraseña.add(mayusculas.charAt(random.nextInt(mayusculas.length())));
        contraseña.add(simbolos.charAt(random.nextInt(simbolos.length())));
        contraseña.add(numeros.charAt(random.nextInt(numeros.length())));

        for (int i = 3; i < longitud; i++) {
            contraseña.add(todosCaracteres.charAt(random.nextInt(todosCaracteres.length())));
        }
        return mezclarLista(contraseña, random);
    }

    private static String mezclarLista(List<Character> contraseña, SecureRandom random) {
        Collections.shuffle(contraseña, random);

        StringBuilder contraseñaFinal = new StringBuilder();
        for (char c : contraseña) {
            contraseñaFinal.append(c);
        }
        return contraseñaFinal.toString();
    }
}
