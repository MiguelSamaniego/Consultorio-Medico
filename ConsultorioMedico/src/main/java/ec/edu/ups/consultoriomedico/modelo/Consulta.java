/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.consultoriomedico.modelo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.util.GregorianCalendar;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 *
 * @author pcuser
 */
@Entity
@Table(name = "consultas")
public class Consulta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Temporal(TemporalType.DATE)
    private GregorianCalendar fecha;
    @OneToOne//(cascade = CascadeType.ALL)
    @JoinColumn//(name = "doctor_id", nullable = true, referencedColumnName = "id")
    private Doctor doctor;
    @OneToOne
    @JoinColumn//(name = "paciente_id", nullable = true, referencedColumnName = "id")
    private Paciente paciente;
    private String observaciones;
    private int tiempo; // en minutos
    @OneToOne
    @JoinColumn//(name = "cabecera_id", nullable = true, referencedColumnName = "id")
    private PrescripcionCabecera prescripcionCabecera;

    public Consulta() {
    }

    public Consulta(int id, GregorianCalendar fecha, Doctor doctor, Paciente paciente, String observaciones, int tiempo) {
        this.id = id;
        this.fecha = fecha;
        this.doctor = doctor;
        this.paciente = paciente;
        this.observaciones = observaciones;
        this.tiempo = tiempo;
    }

    public Consulta(int id, GregorianCalendar fecha, Doctor doctor, Paciente paciente, String observaciones, int tiempo, PrescripcionCabecera prescripcionCabecera) {
        this.id = id;
        this.fecha = fecha;
        this.doctor = doctor;
        this.paciente = paciente;
        this.observaciones = observaciones;
        this.tiempo = tiempo;
        this.prescripcionCabecera = prescripcionCabecera;
    }
    
    
   


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Consulta)) {
            return false;
        }
        Consulta other = (Consulta) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    
}
