/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dominio.Cita;
import dominio.Medico;
import dominio.Paciente;
import java.util.List;

/**
 * Interfaz que define las operaciones necesarias para trabajar con pacientes,
 * médicos y citas.
 *
 * @author Isaac
 */
public interface IDominio {

    Paciente buscarPaciente(String nss);

    List<Medico> obtenerMedicos();

    Medico obtenerDatosMedico(Medico medico);

    Cita registrarCita(Paciente paciente, Medico medico, String fecha, String hora);

}
