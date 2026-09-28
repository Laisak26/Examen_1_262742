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
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import modelo.ModeloCita;

/**
 * Muestra los datos del paciente y permite seleccionar un medico.
 *
 * @author Isaac
 */
public class VistaSeleccionarMedico extends JFrame implements IObservador {

    private ControladorCita controlador;

    private JLabel lblNombrePaciente;
    private JLabel lblNss;
    private JLabel lblEdad;
    private JLabel lblSexo;

    private DefaultListModel<Medico> modeloLista;
    private JList<Medico> listaMedicos;

    private JLabel lblNombreMedico;
    private JLabel lblEspecialidad;
    private JLabel lblConsultorio;
    private JLabel lblDias;
    private JLabel lblHorario;

    private JButton btnContinuar;

    /**
     * Crea la vista y recibe el controlador que atendera sus acciones.
     */
    public VistaSeleccionarMedico(ControladorCita controlador) {
        this.controlador = controlador;

        setTitle("Seleccionar medico");
        setSize(520, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        iniciarComponentes();
    }

    /**
     * Organiza los datos del paciente, la lista de medicos y la informacion del
     * medico seleccionado.
     */
    private void iniciarComponentes() {
        JPanel principal = new JPanel();
        principal.setLayout(new BoxLayout(principal, BoxLayout.Y_AXIS));
        principal.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JPanel panelPaciente = new JPanel(new GridLayout(4, 1, 5, 5));
        panelPaciente.setBorder(
                BorderFactory.createTitledBorder("Datos del paciente")
        );

        lblNombrePaciente = new JLabel("Nombre:");
        lblNss = new JLabel("No. Seg. Social:");
        lblEdad = new JLabel("Edad:");
        lblSexo = new JLabel("Sexo:");

        panelPaciente.add(lblNombrePaciente);
        panelPaciente.add(lblNss);
        panelPaciente.add(lblEdad);
        panelPaciente.add(lblSexo);

        modeloLista = new DefaultListModel<>();
        listaMedicos = new JList<>(modeloLista);
        listaMedicos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        /*
         * Muestra el nombre y especialidad de cada medico sin modificar
         * la forma en que se guarda el objeto.
         */
        listaMedicos.setCellRenderer((lista, medico, index, seleccionado, foco) -> {
            JLabel etiqueta = new JLabel(
                    medico.getNombre() + " - " + medico.getEspecialidad()
            );

            etiqueta.setOpaque(true);

            if (seleccionado) {
                etiqueta.setBackground(lista.getSelectionBackground());
                etiqueta.setForeground(lista.getSelectionForeground());
            } else {
                etiqueta.setBackground(lista.getBackground());
                etiqueta.setForeground(lista.getForeground());
            }

            return etiqueta;
        });

        JScrollPane scrollMedicos = new JScrollPane(listaMedicos);
        scrollMedicos.setBorder(
                BorderFactory.createTitledBorder("Medicos disponibles")
        );

        JPanel panelMedico = new JPanel(new GridLayout(5, 1, 5, 5));
        panelMedico.setBorder(
                BorderFactory.createTitledBorder("Datos del medico")
        );

        lblNombreMedico = new JLabel("Nombre:");
        lblEspecialidad = new JLabel("Especialidad:");
        lblConsultorio = new JLabel("Consultorio:");
        lblDias = new JLabel("Dias:");
        lblHorario = new JLabel("Horario:");

        panelMedico.add(lblNombreMedico);
        panelMedico.add(lblEspecialidad);
        panelMedico.add(lblConsultorio);
        panelMedico.add(lblDias);
        panelMedico.add(lblHorario);

        btnContinuar = new JButton("Continuar");
        btnContinuar.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnContinuar.setEnabled(false);

        listaMedicos.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                seleccionarMedico();
            }
        });

        btnContinuar.addActionListener(e -> continuar());

        principal.add(panelPaciente);
        principal.add(Box.createVerticalStrut(10));
        principal.add(scrollMedicos);
        principal.add(Box.createVerticalStrut(10));
        principal.add(panelMedico);
        principal.add(Box.createVerticalStrut(15));
        principal.add(btnContinuar);

        add(principal);
    }

    /**
     * Envia al controlador el medico elegido por el usuario.
     */
    public void seleccionarMedico() {
        Medico medico = listaMedicos.getSelectedValue();

        if (medico != null) {
            controlador.seleccionarMedico(medico);
        }
    }

    /**
     * Continua con el registro de la fecha y hora de la cita.
     */
    public void continuar() {
        controlador.continuar();

        setVisible(false);
        dispose();
    }

    /**
     * Actualiza la vista con la informacion disponible en el modelo.
     */
    @Override
    public void update(ModeloCita modelo) {

        /*
         * La primera notificacion carga el paciente y la lista de medicos.
         */
        if (modeloLista.isEmpty()) {
            Paciente paciente = modelo.getPaciente();
            List<Medico> medicos = modelo.getMedicos();

            lblNombrePaciente.setText("Nombre: " + paciente.getNombre());
            lblNss.setText("No. Seg. Social: " + paciente.getNss());
            lblEdad.setText("Edad: " + paciente.getEdad() + " años");
            lblSexo.setText("Sexo: " + paciente.getSexo());

            for (Medico medico : medicos) {
                modeloLista.addElement(medico);
            }

            return;
        }

        /*
         * Las siguientes notificaciones muestran el medico seleccionado.
         */
        Medico medico = modelo.getMedico();

        if (medico != null) {
            lblNombreMedico.setText("Nombre: " + medico.getNombre());
            lblEspecialidad.setText("Especialidad: " + medico.getEspecialidad());
            lblConsultorio.setText("Consultorio: " + medico.getConsultorio());
            lblDias.setText("Dias: " + medico.getDiasConsulta());
            lblHorario.setText("Horario: " + medico.getHorarioConsulta());

            btnContinuar.setEnabled(true);
        }
    }
}
