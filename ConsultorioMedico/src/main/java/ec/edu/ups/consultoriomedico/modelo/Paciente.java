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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.GregorianCalendar;

/**
 *
 * @author pcuser
 */
@Entity
@Table(name = "paciente")
public class Paciente extends Persona implements Serializable {

    @Temporal(TemporalType.DATE)
    private GregorianCalendar primerIngreso;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "paciente")
    private Consulta consulta;

    public Paciente() {
    }

    public Paciente(GregorianCalendar primerIngreso, int id, String nombreCompleto, String cedula, String celular, String email, String direccion, boolean estado, GregorianCalendar fechaNacimiento) {
        super(id, nombreCompleto, cedula, celular, email, direccion, estado, fechaNacimiento);
        this.primerIngreso = primerIngreso;
    }

    
   

    public GregorianCalendar getPrimerIngreso() {
        return primerIngreso;
    }

    public void setPrimerIngreso(GregorianCalendar primerIngreso) {
        this.primerIngreso = primerIngreso;
    }

}
