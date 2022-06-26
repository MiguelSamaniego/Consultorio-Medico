package ec.edu.ups.consultoriomedico.modelo;

import jakarta.persistence.Table;
import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 *
 * @author Adrian
 */
@Entity
@Table(name ="controlFactura")
public class ControlFactura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private FacturaCompraCabecera facturaCompraCabecera;
    private FacturaInterna facturaInterna;

    public ControlFactura() {
    }

    public ControlFactura(int id, FacturaCompraCabecera facturaCompraCabecera, FacturaInterna facturaInterna) {
        this.id = id;
        this.facturaCompraCabecera = facturaCompraCabecera;
        this.facturaInterna = facturaInterna;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public FacturaCompraCabecera getFacturaCompraCabecera() {
        return facturaCompraCabecera;
    }

    public void setFacturaCompraCabecera(FacturaCompraCabecera facturaCompraCabecera) {
        this.facturaCompraCabecera = facturaCompraCabecera;
    }

    public FacturaInterna getFacturaInterna() {
        return facturaInterna;
    }

    public void setFacturaInterna(FacturaInterna facturaInterna) {
        this.facturaInterna = facturaInterna;
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
        if (!(object instanceof ControlFactura)) {
            return false;
        }
        ControlFactura other = (ControlFactura) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ControlFactura{" + "id=" + id + ", facturaCompraCabecera=" + facturaCompraCabecera + ", facturaInterna=" + facturaInterna + '}';
    }

 
    
}
