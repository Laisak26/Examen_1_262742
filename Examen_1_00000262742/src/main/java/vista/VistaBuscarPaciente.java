/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import controlador.ControladorCita;
import interfaces.IObservador;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import modelo.ModeloCita;

/**
 * Vista inicial donde el usuario busca al paciente con su NSS.
 *
 * @author Isaac
 */
public class VistaBuscarPaciente extends JFrame implements IObservador {

    private ControladorCita controlador;

    private JTextField txtNss;
    private JButton btnBuscar;

    /**
     * Crea la vista y recibe el controlador que atendera sus acciones.
     */
    public VistaBuscarPaciente(ControladorCita controlador) {
        this.controlador = controlador;

        setTitle("Registrar cita");
        setSize(420, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        iniciarComponentes();
    }

    /**
     * Organiza los elementos de la pantalla y conecta el boton con la busqueda.
     */
    private void iniciarComponentes() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel lblTitulo = new JLabel("Búsqueda de Paciente");
        lblTitulo.setFont(lblTitulo.getFont().deriveFont(Font.BOLD, 18f));

        JLabel lblNss = new JLabel("Ingrese número de seguridad social:");

        txtNss = new JTextField(20);
        btnBuscar = new JButton("Buscar");

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 10, 25, 10);
        panel.add(lblTitulo, gbc);

        gbc.gridy++;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 10, 5, 10);
        panel.add(lblNss, gbc);

        gbc.gridy++;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(txtNss, gbc);

        gbc.gridy++;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(15, 10, 5, 10);
        panel.add(btnBuscar, gbc);

        btnBuscar.addActionListener(e -> buscarPaciente());

        add(panel);
    }

    /**
     * Envia al controlador el NSS escrito por el usuario.
     */
    public void buscarPaciente() {
        controlador.buscarPaciente(txtNss.getText().trim());
    }

    /**
     * Recibe la notificacion del modelo cuando termina la busqueda.
     */
    @Override
    public void update(ModeloCita modelo) {
        setVisible(false);
        dispose();
    }
}
