/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import dominio.Cita;
import dominio.Medico;
import dominio.Paciente;
import interfaces.IDominio;
import interfaces.IObservador;
import java.util.List;

/**
 * Modelo tiene la informacion necesaria para todo lo que necesiten las vistas y
 * registrar una cita médica.
 *
 * @author Isaac
 */
public class ModeloCita {

    private IDominio dominio;
    private IObservador observador;
    private Paciente paciente;
    private List<Medico> medicos;
    private Medico medicoSeleccionado;
    private Cita cita;

    /**
     * Crea el modelo y recibe el dominio que utilizara para las operaciones.
     */
    public ModeloCita(IDominio dominio) {
        this.dominio = dominio;
    }

    /**
     * Busca al paciente y obtiene la lista de medicos. 
     * Despues notifica a la vista activa para que actualice la informacion mostrada.
     */
    public void buscarPaciente(String nss) {
        paciente = dominio.buscarPaciente(nss);
        medicos = dominio.obtenerMedicos();

        notificarObservador();
    }

    /**
     * Guarda la informacion del medico seleccionado. 
     * Despues notifica a la vista activa para mostrar los datos del medico.
     */
    public void seleccionarMedico(Medico medico) {
        medicoSeleccionado = dominio.obtenerDatosMedico(medico);

        notificarObservador();
    }

    /**
     * Registra la cita con el paciente y medico seleccionados.
     */
    public void registrarCita(String fecha, String hora) {
        cita = dominio.registrarCita(paciente, medicoSeleccionado, fecha, hora);
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Medico getMedico() {
        return medicoSeleccionado;
    }

    public List<Medico> getMedicos() {
        return medicos;
    }

    public Cita getCita() {
        return cita;
    }

    /**
     * Cambia la vista que recibira las siguientes notificaciones del modelo.
     */
    public void setObservador(IObservador observador) {
        this.observador = observador;
    }

    /**
     * Avisa a la vista activa que debe actualizarse con la informacion del modelo.
     */
    public void notificarObservador() {
        if (observador != null) {
            observador.update(this);
        }
    }
    
}
