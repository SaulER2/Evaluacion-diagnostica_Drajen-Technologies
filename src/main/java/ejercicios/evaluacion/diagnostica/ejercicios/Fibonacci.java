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
public class Fibonacci {

    public static void ejecutar(Scanner scanner) {

        String continuar;
        do{

            System.out.println("Seleccione la cantidad de números de Fibonacci a generar:");
            int n = Integer.parseInt(scanner.nextLine());

            System.out.println("Los primeros " + n + " números de Fibonacci son:");
            Numerosfibonacci(n);
            System.out.println();
            System.out.println("¿Desea generar otra secuencia de Fibonacci? (s/n):");
            continuar = scanner.nextLine().toLowerCase();
        }while (("s".equals(continuar)) || ("si".equals(continuar)) || ("sí".equals(continuar)));
    }

    private static void Numerosfibonacci(int n) {
        if (n <= 0)
            return;

        int a = 0, b = 1;

        System.out.print(a + " ");
        if (n == 1)
            return;

        System.out.print(b + " ");
        for (int i = 2; i < n; i++) {
            int temp = a + b;
            System.out.print(temp + " ");
            a = b;
            b = temp;
        }
    }
}