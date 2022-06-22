/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.consultoriomedico.modelo;

import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

/**
 *
 * @author pcuser
 */
@Entity
public class PrescripcionDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String medicamento;
    private String tiempoMedicamente;
    private String intervaloTiempo;
    @ManyToOne
    @JoinColumn
    private PrescripcionCabecera prescripcionCabecera;

    public PrescripcionDetalle() {
    }

  

    public PrescripcionDetalle(int id, String medicamento, String tiempoMedicamente, String intervaloTiempo, PrescripcionCabecera prescripcionCabecera) {
        this.id = id;
        this.medicamento = medicamento;
        this.tiempoMedicamente = tiempoMedicamente;
        this.intervaloTiempo = intervaloTiempo;
        this.prescripcionCabecera = prescripcionCabecera;
    }

    public String getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(String medicamento) {
        this.medicamento = medicamento;
    }

    public String getTiempoMedicamente() {
        return tiempoMedicamente;
    }

    public void setTiempoMedicamente(String tiempoMedicamente) {
        this.tiempoMedicamente = tiempoMedicamente;
    }

    public String getIntervaloTiempo() {
        return intervaloTiempo;
    }

    public void setIntervaloTiempo(String intervaloTiempo) {
        this.intervaloTiempo = intervaloTiempo;
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
        if (!(object instanceof PrescripcionDetalle)) {
            return false;
        }
        PrescripcionDetalle other = (PrescripcionDetalle) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.ups.consultoriomedico.modelo.PrescripcionDetalle[ id=" + id + " ]";
    }
    
}
