/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 * Representa un medico disponible para las citas.
 *
 * @author Isaac
 */
public class Medico {

    private String nombre;
    private String especialidad;
    private String consultorio;
    private String diasConsulta;
    private String horarioConsulta;

    /**
     * Crea un medico con sus datos.
     */
    public Medico(String nombre, String especialidad, String consultorio,
            String diasConsulta, String horarioConsulta) {
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.consultorio = consultorio;
        this.diasConsulta = diasConsulta;
        this.horarioConsulta = horarioConsulta;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public String getConsultorio() {
        return consultorio;
    }

    public String getDiasConsulta() {
        return diasConsulta;
    }

    public String getHorarioConsulta() {
        return horarioConsulta;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public void setConsultorio(String consultorio) {
        this.consultorio = consultorio;
    }

    public void setDiasConsulta(String diasConsulta) {
        this.diasConsulta = diasConsulta;
    }

    public void setHorarioConsulta(String horarioConsulta) {
        this.horarioConsulta = horarioConsulta;
    }

}
