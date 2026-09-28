/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 * Representa a un paciente dentro del sistema.
 *
 * @author Isaac
 */
public class Paciente {

    private String nss;
    private String nombre;
    private int edad;
    private String sexo;

    /**
     * Crea un paciente con sus datos principales.
     */
    public Paciente(String nss, String nombre, int edad, String sexo) {
        this.nss = nss;
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
    }

    public String getNss() {
        return nss;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setNss(String nss) {
        this.nss = nss;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

}
