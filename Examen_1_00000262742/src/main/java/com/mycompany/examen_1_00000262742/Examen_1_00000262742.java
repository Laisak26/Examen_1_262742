/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.examen_1_00000262742;

import controlador.ControladorCita;
import dominio.Dominio;
import interfaces.IDominio;
import modelo.ModeloCita;

/**
 * Main naim.
 *
 * @author Isaac
 */
public class Examen_1_00000262742 {

    public static void main(String[] args) {
        IDominio dominio = new Dominio();
        ModeloCita modelo = new ModeloCita(dominio);

        new ControladorCita(modelo);
    }
}
