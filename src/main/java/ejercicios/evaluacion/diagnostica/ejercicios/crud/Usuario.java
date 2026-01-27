/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.evaluacion.diagnostica.ejercicios.crud;

/**
 *
 * @author Saul Espinosa Rios
 */
public class Usuario {

    private static int idIncremental = 1;

    private int id;
    private String nombre;
    private int edad;
    private String contraseña;
    
    public Usuario(String nombre, int edad, String contraseña) {
        this.id = idIncremental++;
        this.nombre = nombre;
        this.edad = edad;
        this.contraseña = contraseña;
    }

    public int getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public int getEdad() {
        return edad;
    }
    public String getContraseña() {
        return contraseña;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}
