/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.evaluacion.diagnostica.ejercicios;

import java.util.Scanner;
import java.time.*;

/**
 *
 * @author Saul Espinosa Rios
 */
public class EdadExacta {

    public static void ejecutar(Scanner scanner) {

        int año, mes, dia, hora;
        String continuar;

        do {

            System.out.println("Ingrese los siguintes datos en valor numérico: ");
            System.out.print("Ingrese su año de nacimiento: ");
            año = scanner.nextInt();

            System.out.print("Ingrese su mes de nacimiento: ");
            mes = scanner.nextInt();

            System.out.print("Ingrese su día de nacimiento: ");
            dia = scanner.nextInt();

            System.out.print("Ingrese su hora de nacimiento: ");
            hora = scanner.nextInt();
            scanner.nextLine(); 

            LocalDateTime fechaNacimiento = LocalDateTime.of(año, mes, dia, hora, 0);
            LocalDateTime fechaActual = LocalDateTime.now();

            // int años = fechaActual.getYear() - fechaNacimiento.getYear();
            // int meses = fechaActual.getMonthValue() - fechaNacimiento.getMonthValue();
            // int dias = fechaActual.getDayOfMonth() - fechaNacimiento.getDayOfMonth();
            // int horas = fechaActual.getHour() - fechaNacimiento.getHour();

            Period periodo = Period.between(fechaNacimiento.toLocalDate(), fechaActual.toLocalDate());
            Duration duracion = Duration.between(fechaNacimiento.toLocalTime(), fechaActual.toLocalTime());

            if (duracion.isNegative()) {
                periodo = periodo.minusDays(1);
                duracion = duracion.plusHours(24);
            }

            int años = periodo.getYears();
            int meses = periodo.getMonths();
            int dias = periodo.getDays();
            long horas = duracion.toHours();

            System.out.println("Su edad exacta es: ");
            System.out.println("Años: " + años);
            System.out.println("Meses: " + meses);
            System.out.println("Días: " + dias);
            System.out.println("Horas: " + horas);

            System.out.print("¿Desea calcular otra edad exacta? (s/n): ");
            continuar = scanner.nextLine().toLowerCase();

        } while (("s".equals(continuar)) || ("si".equals(continuar)) || ("sí".equals(continuar)));
    }
}