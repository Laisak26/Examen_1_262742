/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import dominio.Cita;
import dominio.Medico;
import dominio.Paciente;
import interfaces.IObservador;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import modelo.ModeloCita;

/**
 * Muestra la confirmacion de la cita registrada.
 *
 * @author Isaac
 */
public class VistaConfirmacionCita extends JDialog implements IObservador {

    private JLabel lblPaciente;
    private JLabel lblNss;
    private JLabel lblMedico;
    private JLabel lblEspecialidad;
    private JLabel lblConsultorio;
    private JLabel lblFecha;
    private JLabel lblHora;

    private JButton btnAceptar;

    /**
     * Crea la ventana de confirmacion.
     */
    public VistaConfirmacionCita() {
        setTitle("Cita registrada");
        setSize(430, 330);
        setModal(true);
        setLocationRelativeTo(null);
        setResizable(false);

        iniciarComponentes();
    }

    /**
     * Organiza la informacion de la cita y el boton para cerrar la ventana.
     */
    private void iniciarComponentes() {
        JPanel principal = new JPanel();
        principal.setLayout(new BoxLayout(principal, BoxLayout.Y_AXIS));
        principal.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JLabel lblTitulo = new JLabel("Cita registrada correctamente!!!");
        lblTitulo.setFont(lblTitulo.getFont().deriveFont(Font.BOLD, 16f));
        lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel panelDatos = new JPanel(new GridLayout(7, 1, 5, 5));
        panelDatos.setBorder(BorderFactory.createEtchedBorder());

        lblPaciente = new JLabel("Paciente:");
        lblNss = new JLabel("NSS:");
        lblMedico = new JLabel("Medico:");
        lblEspecialidad = new JLabel("Especialidad:");
        lblConsultorio = new JLabel("Consultorio:");
        lblFecha = new JLabel("Fecha:");
        lblHora = new JLabel("Hora:");

        panelDatos.add(lblPaciente);
        panelDatos.add(lblNss);
        panelDatos.add(lblMedico);
        panelDatos.add(lblEspecialidad);
        panelDatos.add(lblConsultorio);
        panelDatos.add(lblFecha);
        panelDatos.add(lblHora);

        btnAceptar = new JButton("Aceptar");
        btnAceptar.setAlignmentX(Component.CENTER_ALIGNMENT);

        btnAceptar.addActionListener(e -> dispose());

        principal.add(lblTitulo);
        principal.add(Box.createVerticalStrut(15));
        principal.add(panelDatos);
        principal.add(Box.createVerticalStrut(15));
        principal.add(btnAceptar);

        add(principal);
    }

    /**
     * Actualiza la confirmacion con los datos guardados en el modelo.
     */
    @Override
    public void update(ModeloCita modelo) {
        Paciente paciente = modelo.getPaciente();
        Medico medico = modelo.getMedico();
        Cita cita = modelo.getCita();

        if (paciente != null) {
            lblPaciente.setText("Paciente: " + paciente.getNombre());
            lblNss.setText("NSS: " + paciente.getNss());
        }

        if (medico != null) {
            lblMedico.setText("Medico: " + medico.getNombre());
            lblEspecialidad.setText(
                    "Especialidad: " + medico.getEspecialidad()
            );
            lblConsultorio.setText(
                    "Consultorio: " + medico.getConsultorio()
            );
        }

        if (cita != null) {
            lblFecha.setText("Fecha: " + cita.getFecha());
            lblHora.setText("Hora: " + cita.getHora());
        }
    }
}
