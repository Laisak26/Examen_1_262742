/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import dominio.Medico;
import modelo.ModeloCita;
import vista.VistaApartarCita;
import vista.VistaBuscarPaciente;
import vista.VistaConfirmacionCita;
import vista.VistaSeleccionarMedico;

/**
 * Coordina las acciones de las vistas con el modelo de la cita.
 *
 * @author Isaac
 */
public class ControladorCita {

    private ModeloCita modelo;

    /**
     * Crea el controlador e inicia la primera vista del registro de cita.
     */
    public ControladorCita(ModeloCita modelo) {
        this.modelo = modelo;

        VistaBuscarPaciente vista = new VistaBuscarPaciente(this);

        modelo.setObservador(vista);
        vista.setVisible(true);
    }

    /**
     * Solicita la busqueda del paciente y cambia a la vista donde se
     * seleccionara al medico.
     */
    public void buscarPaciente(String nss) {
        modelo.buscarPaciente(nss);

        VistaSeleccionarMedico vista = new VistaSeleccionarMedico(this);

        modelo.setObservador(vista);
        modelo.notificarObservador();

        vista.setVisible(true);
    }

    /**
     * Envia al modelo el medico seleccionado.
     */
    public void seleccionarMedico(Medico medico) {
        modelo.seleccionarMedico(medico);
    }

    /**
     * Cambia a la vista para apartar la cita y solicita que se actualice con la
     * informacion guardada en el modelo.
     */
    public void continuar() {
        VistaApartarCita vista = new VistaApartarCita(this);

        modelo.setObservador(vista);
        modelo.notificarObservador();

        vista.setVisible(true);
    }

    /**
     * Registra la cita y muestra la confirmacion con sus datos.
     */
    public void registrarCita(String fecha, String hora) {
        modelo.registrarCita(fecha, hora);

        VistaConfirmacionCita vista = new VistaConfirmacionCita();

        modelo.setObservador(vista);
        modelo.notificarObservador();

        vista.setVisible(true);
    }
}
