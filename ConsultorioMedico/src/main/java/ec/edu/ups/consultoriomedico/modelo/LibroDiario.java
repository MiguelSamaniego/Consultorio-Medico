/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.consultoriomedico.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Adrian
 */
@Entity
public class LibroDiario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private Date fecha;
    private List<FacturaInterna> listaFacturas;

    public LibroDiario(int id, Date fecha, List<FacturaInterna> listaFacturas) {
        this.id = id;
        this.fecha = fecha;
        this.listaFacturas = listaFacturas;
    }

    public LibroDiario() {
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public List<FacturaInterna> getListaFacturas() {
        return listaFacturas;
    }

    public void setListaFacturas(List<FacturaInterna> listaFacturas) {
        this.listaFacturas = listaFacturas;
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
        if (!(object instanceof LibroDiario)) {
            return false;
        }
        LibroDiario other = (LibroDiario) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "LibroDiario{" + "id=" + id + ", fecha=" + fecha + ", listaFacturas=" + listaFacturas + '}';
    }

 
    
}
