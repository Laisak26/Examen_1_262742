/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import modelo.ModeloCita;

/**
 * Define el método que reciben las vistas cuando el modelo cambia.
 *
 * @author Isaac
 */
public interface IObservador {

    void update(ModeloCita modelo);
}