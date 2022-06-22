/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.consultoriomedico.modelo;

import jakarta.persistence.CascadeType;
import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.GregorianCalendar;

/**
 *
 * @author pcuser
 */
@Entity
@Table(name = "doctor")
public class Doctor extends Persona implements Serializable {

    private String especialidad;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "doctor")
    private Consulta consulta;

    public Doctor() {
    }

    public Doctor(int id, String nombreCompleto, String cedula, String celular, String email, String direccion, boolean estado, GregorianCalendar fechaNacimiento) {
        super(id, nombreCompleto, cedula, celular, email, direccion, estado, fechaNacimiento);
    }

    public Doctor(String especialidad, int id, String nombreCompleto, String cedula, String celular, String email, String direccion, boolean estado, GregorianCalendar fechaNacimiento) {
        super(id, nombreCompleto, cedula, celular, email, direccion, estado, fechaNacimiento);
        this.especialidad = especialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

}
