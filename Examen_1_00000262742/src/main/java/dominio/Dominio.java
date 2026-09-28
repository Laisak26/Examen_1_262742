/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import interfaces.IDominio;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementa las operaciones del dominio usando datos guardados en memoria.
 *
 * @author Isaac
 */
public class Dominio implements IDominio {

    private List<Paciente> pacientes;
    private List<Medico> medicos;
    private List<Cita> citas;

    /**
     * Crea el dominio y carga los datos necesarios para probar el sistema.
     */
    public Dominio() {
        pacientes = new ArrayList<>();
        medicos = new ArrayList<>();
        citas = new ArrayList<>();

        pacientes.add(new Paciente("46127209461", "Pepe Chuy", 34, "Femenino"));

        pacientes.add(new Paciente("12345678901", "Maria Lopez", 28, "Femenino"));

        medicos.add(new Medico("Dr. Jose Jose", "Medicina General", "4-A", "Lunes a Jueves", "8:00 - 14:00"));

        medicos.add(new Medico("Dra. Ana Banana", "Cardiologia", "2-B", "Lunes, Miercoles y Viernes", "9:00 - 13:00"));

        medicos.add(new Medico("Dr. Pedro Hernandez", "Dermatologia", "3-C", "Martes y Jueves", "10:00 - 15:00"));

        medicos.add(new Medico("Dr. Luis Maquiavelo", "Pediatria", "5-A", "Lunes a Viernes", "8:00 - 12:00"));

        medicos.add(new Medico("Dra. Johnny Lozano", "Neurologia", "6-B", "Martes, Jueves y Viernes", "12:00 - 17:00"));
    }

    /**
     * Busca un paciente por su numero de seguridad social.
     */
    @Override
    public Paciente buscarPaciente(String nss) {
        for (Paciente paciente : pacientes) {
            if (paciente.getNss().equals(nss)) {
                return paciente;
            }
        }

        return null;
    }

    /**
     * Obtiene los medicos disponibles para registrar una cita.
     */
    @Override
    public List<Medico> obtenerMedicos() {
        return medicos;
    }

    /**
     * Obtiene la informacion del medico seleccionado.
     */
    @Override
    public Medico obtenerDatosMedico(Medico medico) {
        return medico;
    }

    /**
     * Registra una nueva cita con la fecha y hora seleccionadas.
     */
    @Override
    public Cita registrarCita(Paciente paciente, Medico medico,
            String fecha, String hora) {

        Cita cita = new Cita(fecha, hora);
        citas.add(cita);

        return cita;
    }
}
