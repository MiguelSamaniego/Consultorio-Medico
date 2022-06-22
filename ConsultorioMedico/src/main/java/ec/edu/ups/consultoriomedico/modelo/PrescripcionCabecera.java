/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.consultoriomedico.modelo;

import com.sun.tools.classfile.StackMapTable_attribute;
import jakarta.persistence.CascadeType;
import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.util.List;

/**
 *
 * @author pcuser
 */
@Entity
public class PrescripcionCabecera implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String mensaje;
    @OneToOne(cascade = CascadeType.ALL ,mappedBy = "prescripcionCabecera")
    private Consulta consulta;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "prescripcionCabecera")
    private List<PrescripcionDetalle> listaDetalle;

    public PrescripcionCabecera() {
    }

    public PrescripcionCabecera(int id) {
        this.id = id;
    }

    public PrescripcionCabecera(int id, String mensaje, List<PrescripcionDetalle> listaDetalle) {
        this.id = id;
        this.mensaje = mensaje;
        this.listaDetalle = listaDetalle;
    }

    public List<PrescripcionDetalle> getListaDetalle() {
        return listaDetalle;
    }

    public void setListaDetalle(List<PrescripcionDetalle> listaDetalle) {
        this.listaDetalle = listaDetalle;
    }

    public PrescripcionCabecera(int id, String mensaje) {
        this.id = id;
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
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
        if (!(object instanceof PrescripcionCabecera)) {
            return false;
        }
        PrescripcionCabecera other = (PrescripcionCabecera) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.ups.consultoriomedico.modelo.PrescripcionCabecera[ id=" + id + " ]";
    }
    
}
