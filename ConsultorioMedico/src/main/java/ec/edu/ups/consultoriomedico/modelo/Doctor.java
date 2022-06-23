/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.consultoriomedico.modelo;

import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.util.Date;

/**
 *
 * @author pcuser
 */
@Entity
@Table(name = "doctor")
public class Doctor extends Persona implements Serializable {

    private String especialidad;

    public Doctor() {
    }

    public Doctor(int id, String nombreCompleto, String cedula, String celular, String email, String direccion, boolean estado, Date fechaNacimiento) {
        super(id, nombreCompleto, cedula, celular, email, direccion, estado, fechaNacimiento);
    }

    public Doctor(String especialidad, int id, String nombreCompleto, String cedula, String celular, String email, String direccion, boolean estado, Date fechaNacimiento) {
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
