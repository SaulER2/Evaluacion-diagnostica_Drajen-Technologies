/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.evaluacion.diagnostica.ejercicios;

import ejercicios.evaluacion.diagnostica.EntradaContinuar;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

/**
 *
 * @author Saul Espinosa Rios
 */
public class Ahorcado {

    public static void ejecutar(Scanner scanner) {

        String continuar;
        final int intentosMaximos = 5;

        do {
            System.out.println("Para jugar al Ahorcado, intenta adivinar la palabra secreta. Una letra a la vez.");
            String[] palabras = { "ahorcado", "java", "computadora", "desarrollo", "software", "biblioteca" };
            int intentosRestantes = intentosMaximos;
            String letraIngresada;
            Set<Character> letrasAdivinadas = new HashSet<>();
            Set<Character> letrasIncorrectas = new HashSet<>();
            String palabraSecreta = seleccionarPalabra(palabras);

            while (intentosRestantes > 0 && !verificarVictoria(palabraSecreta, letrasAdivinadas)) {

                mostrarProgreso(palabraSecreta, letrasAdivinadas, intentosRestantes, letrasIncorrectas);
                System.out.print("Ingresa una letra: ");
                letraIngresada = scanner.nextLine().toLowerCase();

                if (letraIngresada.length() != 1 || !Character.isLetter(letraIngresada.charAt(0))) {
                    System.out.println("Por favor, ingresa una sola letra válida.");
                    continue;
                }

                char letra = letraIngresada.charAt(0);

                if (letrasAdivinadas.contains(letra) || letrasIncorrectas.contains(letra)) {
                    System.out.println("Ya has intentado con la letra '" + letra + "'. Intenta con otra.");
                    continue;
                }

                if (palabraSecreta.indexOf(letra) >= 0) {
                    letrasAdivinadas.add(letra);
                    System.out.println("¡Bien! La letra '" + letra + "' está en la palabra.");
                } else {
                    letrasIncorrectas.add(letra);
                    intentosRestantes--;
                    System.out.println("Lo siento, la letra '" + letra + "' no está en la palabra.");
                }
                System.out.println("");
            }
            if (verificarVictoria(palabraSecreta, letrasAdivinadas)) {
                System.out.println("¡Felicidades! Has adivinado la palabra: " + palabraSecreta);
            } else {
                System.out.println("Has perdido. La palabra era: " + palabraSecreta);
            }
            
            continuar = EntradaContinuar.continuar(scanner);
        } while ("s".equals(continuar));
    }

    private static String seleccionarPalabra(String[] palabras) {
        int indice = (int) (Math.random() * palabras.length);
        return palabras[indice];
    }

    private static void mostrarProgreso(String palabraSecreta, Set<Character> letrasAdivinadas, int intentosRestantes,
            Set<Character> letrasIncorrectas) {
        StringBuilder progreso = new StringBuilder();
        for (char letra : palabraSecreta.toCharArray()) {
            if (letrasAdivinadas.contains(letra)) {
                progreso.append(letra).append(" ");
            } else {
                progreso.append("_ ");
            }
        }
        System.out.println("Palabra: " + progreso);
        System.out.println("Intentos restantes: " + intentosRestantes);
        System.out.println("Letras incorrectas: " + letrasIncorrectas);
    }

    private static boolean verificarVictoria(String palabraSecreta, Set<Character> letrasAdivinadas) {
        for (char letra : palabraSecreta.toCharArray()) {
            if (!letrasAdivinadas.contains(letra)) {
                return false;
            }
        }
        return true;
    }

}
