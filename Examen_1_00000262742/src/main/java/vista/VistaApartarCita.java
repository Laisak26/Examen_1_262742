/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import controlador.ControladorCita;
import dominio.Medico;
import dominio.Paciente;
import interfaces.IObservador;
import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import modelo.ModeloCita;

/**
 * Permite seleccionar la fecha y hora para registrar la cita.
 *
 * @author Isaac
 */
public class VistaApartarCita extends JFrame implements IObservador {

    private ControladorCita controlador;

    private JLabel lblNombrePaciente;
    private JLabel lblNss;

    private JLabel lblNombreMedico;
    private JLabel lblEspecialidad;
    private JLabel lblConsultorio;

    private JComboBox<String> cmbFecha;
    private JComboBox<String> cmbHora;
    private JButton btnApartar;

    /**
     * Crea la vista y recibe el controlador que atendera sus acciones.
     */
    public VistaApartarCita(ControladorCita controlador) {
        this.controlador = controlador;

        setTitle("Apartar cita");
        setSize(520, 520);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        iniciarComponentes();
    }

    /**
     * Organiza los datos del paciente, medico y seleccion de fecha y hora.
     */
    private void iniciarComponentes() {
        JPanel principal = new JPanel();
        principal.setLayout(new BoxLayout(principal, BoxLayout.Y_AXIS));
        principal.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JPanel panelPaciente = new JPanel(new GridLayout(2, 1, 5, 5));
        panelPaciente.setBorder(
                BorderFactory.createTitledBorder("Datos del paciente")
        );

        lblNombrePaciente = new JLabel("Nombre:");
        lblNss = new JLabel("No. Seg. Social:");

        panelPaciente.add(lblNombrePaciente);
        panelPaciente.add(lblNss);

        JPanel panelMedico = new JPanel(new GridLayout(3, 1, 5, 5));
        panelMedico.setBorder(
                BorderFactory.createTitledBorder("Datos del medico")
        );

        lblNombreMedico = new JLabel("Nombre:");
        lblEspecialidad = new JLabel("Especialidad:");
        lblConsultorio = new JLabel("Consultorio:");

        panelMedico.add(lblNombreMedico);
        panelMedico.add(lblEspecialidad);
        panelMedico.add(lblConsultorio);

        JPanel panelFechaHora = new JPanel(new GridLayout(2, 2, 10, 10));
        panelFechaHora.setBorder(
                BorderFactory.createTitledBorder("Seleccion de Fecha y Hora")
        );

        JLabel lblFecha = new JLabel("Fecha:");
        JLabel lblHora = new JLabel("Hora:");

        String[] fechas = {
            "14/10/2026",
            "15/10/2026",
            "16/10/2026",
            "17/10/2026"
        };

        String[] horas = {
            "9:00",
            "10:00",
            "11:00",
            "12:00",
            "13:00"
        };

        cmbFecha = new JComboBox<>(fechas);
        cmbHora = new JComboBox<>(horas);

        panelFechaHora.add(lblFecha);
        panelFechaHora.add(cmbFecha);
        panelFechaHora.add(lblHora);
        panelFechaHora.add(cmbHora);

        btnApartar = new JButton("Apartar cita");
        btnApartar.setAlignmentX(Component.CENTER_ALIGNMENT);

        btnApartar.addActionListener(e -> registrarCita());

        principal.add(panelPaciente);
        principal.add(Box.createVerticalStrut(10));
        principal.add(panelMedico);
        principal.add(Box.createVerticalStrut(10));
        principal.add(panelFechaHora);
        principal.add(Box.createVerticalStrut(15));
        principal.add(btnApartar);

        add(principal);
    }

    /**
     * Envia al controlador la fecha y hora elegidas para registrar la cita.
     */
    public void registrarCita() {
        String fecha = cmbFecha.getSelectedItem().toString();
        String hora = cmbHora.getSelectedItem().toString();

        controlador.registrarCita(fecha, hora);

        setVisible(false);
        dispose();
    }

    /**
     * Actualiza la vista con el paciente y medico guardados en el modelo.
     */
    @Override
    public void update(ModeloCita modelo) {
        Paciente paciente = modelo.getPaciente();
        Medico medico = modelo.getMedico();

        if (paciente != null) {
            lblNombrePaciente.setText("Nombre: " + paciente.getNombre());
            lblNss.setText("No. Seg. Social: " + paciente.getNss());
        }

        if (medico != null) {
            lblNombreMedico.setText("Nombre: " + medico.getNombre());
            lblEspecialidad.setText(
                    "Especialidad: " + medico.getEspecialidad()
            );
            lblConsultorio.setText(
                    "Consultorio: " + medico.getConsultorio()
            );
        }
    }
}
