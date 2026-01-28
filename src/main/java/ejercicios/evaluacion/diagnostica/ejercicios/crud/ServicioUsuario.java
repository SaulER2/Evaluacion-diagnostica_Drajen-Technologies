/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.evaluacion.diagnostica.ejercicios.crud;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;


/**
 *
 * @author Saul Espinosa Rios
 */
public class ServicioUsuario {

    private static final List<Usuario> usuarios = new ArrayList<>();

    public static void menuUsuario(Scanner scanner) {
        String opcion;
        do {
            System.out.println("Menú de Usuario");
            System.out.println("1. Agregar Usuario");
            System.out.println("2. Editar Usuarios");
            System.out.println("3. Eliminar Usuario");
            System.out.println("4. Listar Usuarios");
            System.out.println("5. Salir");

            opcion = scanner.nextLine().toLowerCase();

            switch (opcion) {
                case "1", "agregar", "agregar usuario" -> agregarUsuario(scanner);
                case "2", "editar", "editar usuario" -> editarUsuarios(scanner);
                case "3", "eliminar", "eliminar usuario" -> eliminarUsuario(scanner);
                case "4", "listar", "listar usuarios" -> listarUsuarios(scanner);
                case "5", "salir"-> System.out.println("Saliendo del menú de usuario.");
                default -> System.out.println("Opción no válida. Por favor, intente de nuevo.");
                
            }
        } while (!opcion.equals("5") && !opcion.equalsIgnoreCase("salir"));
    }

    private static void agregarUsuario(Scanner scanner) {
        System.out.print("Ingrese el nombre del usuario: ");
        String nombre;
        while (true) {
            nombre = scanner.nextLine().trim();
            if (!nombre.isBlank() && nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ]+")) {
                break;
            }
            System.out.print("El nombre no puede estar vacío y debe contener solo letras. Ingrese el nombre del usuario: ");
        }

        System.out.print("Ingrese la edad del usuario: ");
        int edad;
        while (true) {
            try {
                edad = Integer.parseInt(scanner.nextLine());
                if (edad >= 0 && edad <= 120) {
                    break;
                }
                System.out.print("La edad debe estar entre 0 y 120. Ingrese la edad del usuario: ");
            } catch (NumberFormatException e) {
                System.out.print("Edad inválida. Ingrese la edad del usuario: ");
            }
        }

        System.out.print("Ingrese la contraseña del usuario: ");
        String contraseña;
        while (true) {
            contraseña = scanner.nextLine().trim();
            if (!contraseña.isBlank() && contraseña.length() >= 8) {
                break;
            }
            System.out.print("La contraseña no puede estar vacía y debe tener al menos 8 caracteres. Ingrese la contraseña del usuario: ");
        }
        
        Usuario usuario = new Usuario(nombre, edad, contraseña);
        usuarios.add(usuario);
        System.out.println("Usuario agregado exitosamente.");

        listarUsuarios(scanner);
    }

    private static void editarUsuarios(Scanner scanner){
        listarUsuarios(scanner);
        System.out.print("Ingrese el ID del usuario a editar: ");
        int id;
        try {
            id = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("ID inválido. Operación cancelada.");
            return;
        }
        
        Optional<Usuario> usuarioOpt = buscarPorId(id);

        if(usuarioOpt.isPresent()){
            Usuario usuario =usuarioOpt.get();

            System.out.print("Ingrese el nuevo nombre -Enter para mantener (" + usuario.getNombre() + ")-: ");
            String nuevoNombre;
            while (true) {
                nuevoNombre = scanner.nextLine();
                if (nuevoNombre.isBlank()) {
                    break;
                }
                if (nuevoNombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ]+")) {
                    usuario.setNombre(nuevoNombre);
                    break;
                }
                System.out.print("El nombre debe contener solo letras. Ingrese el nuevo nombre -Enter para mantener (" + usuario.getNombre() + ")-: ");
            }

            System.out.print("Ingrese la nueva edad -Enter para mantener (" + usuario.getEdad() + ")-: ");
            String nuevaEdadStr;
            while (true) {
                nuevaEdadStr = scanner.nextLine();
                if (nuevaEdadStr.isBlank()) {
                    break;
                }
                try {
                    int nuevaEdad = Integer.parseInt(nuevaEdadStr);
                    if (nuevaEdad >= 0 && nuevaEdad <= 120) {
                        usuario.setEdad(nuevaEdad);
                        break;
                    } else {
                        System.out.print("La edad debe estar entre 0 y 120. Ingrese la nueva edad -Enter para mantener (" + usuario.getEdad() + ")-: ");
                    }
                } catch (NumberFormatException e) {
                    System.out.print("Edad inválida. Ingrese la nueva edad -Enter para mantener (" + usuario.getEdad() + ")-: ");
                }
            }

            System.out.print("Ingrese la nueva contraseña -Enter para mantener (" + usuario.getContraseña() + ")-: ");
            String nuevaContraseña;
            while (true) {
                nuevaContraseña = scanner.nextLine().trim();
                if (nuevaContraseña.isBlank()) {
                    break;
                }
                if (nuevaContraseña.length() >= 8) {
                    usuario.setContraseña(nuevaContraseña);
                    break;
                }
                System.out.print("La contraseña debe tener al menos 8 caracteres. Ingrese la nueva contraseña -Enter para mantener (" + usuario.getContraseña() + ")-: ");
            }

            System.out.println("Usuario editado exitosamente.");
            listarUsuarios(scanner);
        }else {
            System.out.println("Usuario con ID " + id + " no encontrado.");
            System.out.println("Presione Enter para continuar...");
            scanner.nextLine();
        }
    }

    private static void eliminarUsuario(Scanner scanner) {
        listarUsuarios(scanner);
        System.out.print("Ingrese el ID del usuario a eliminar: ");
        int id;
        try {
            id = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("ID inválido. Operación cancelada.");
            return;
        }

        Optional<Usuario> usuarioOpt = buscarPorId(id);

        if (usuarioOpt.isPresent()) {
            usuarios.remove(usuarioOpt.get());
            System.out.println("Usuario eliminado exitosamente.");
            listarUsuarios(scanner);
        } else {
            System.out.println("Usuario con ID " + id + " no encontrado.");
        }
        System.out.println("Presione Enter para continuar...");
        scanner.nextLine();
    }

    private static void listarUsuarios(Scanner scanner) {
        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
            System.out.println("Presione Enter para continuar...");
            scanner.nextLine();
            return;
        }

        System.out.println("Lista de Usuarios:");
        usuarios.forEach(usuario -> {
            System.out.println("ID: " + usuario.getId() + ", Nombre: " + usuario.getNombre() +
                    ", Edad: " + usuario.getEdad() + ", Contraseña: " + usuario.getContraseña());
        });
        /*usuarios.forEach(System.out::println);*/
        System.out.println("Presione Enter para continuar...");
        scanner.nextLine();
    }

    private static Optional<Usuario> buscarPorId(int id) {
        return usuarios.stream()
                .filter(usuario -> usuario.getId() == id)
                .findFirst();
    }
}
