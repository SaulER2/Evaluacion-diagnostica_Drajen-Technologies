/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.evaluacion.diagnostica.ejercicios;

import java.util.Scanner;
import java.time.*;
import ejercicios.evaluacion.diagnostica.EntradaContinuar;

/**
 *
 * @author Saul Espinosa Rios
 */
public class EdadExacta {

    public static void ejecutar(Scanner scanner) {

        int año, mes, dia, hora;
        String continuar = "s";

        do {

            System.out.println("Ingrese los siguintes datos en valor numérico: ");
            año = leerEnteroValido(scanner, "Ingrese su año de nacimiento: ", 1900, LocalDate.now().getYear());

            mes = leerEnteroValido(scanner, "Ingrese su mes de nacimiento (1-12): ", 1, 12);

            dia = leerEnteroValido(scanner, "Ingrese su día de nacimiento (1-31): ", 1, 31);

            hora = leerEnteroValido(scanner, "Ingrese su hora de nacimiento (0-23): ", 0, 23);

            LocalDateTime fechaNacimiento;
            try {
                fechaNacimiento = LocalDateTime.of(año, mes, dia, hora, 0);
            } catch (DateTimeException e) {
                System.out.println("La fecha ingresada no es válida. Por favor, intente de nuevo.");
                continue;
            }

            LocalDateTime fechaActual = LocalDateTime.now();

            if (fechaNacimiento.isAfter(fechaActual)) {
                System.out.println("La fecha de nacimiento no puede ser en el futuro. Por favor, intente de nuevo.");
                continue;
            }

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

            continuar = EntradaContinuar.continuar(scanner);

        } while ("s".equals(continuar));
    }

    private static int leerEnteroValido(Scanner scanner, String mensaje, int min, int max){
        while (true) {
            System.out.print(mensaje);
            String entrada = scanner.nextLine();
            try {
                int valor = Integer.parseInt(entrada);
                if (valor >= min || valor <= max) {
                    return valor;
                } else {
                    System.out.println("Por favor, ingrese un número entre " + min + " y " + max + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Por favor, ingrese un número entero.");
            }
        }
    }
}