package ec.edu.ups.consultoriomedico.modelo;

import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Adrian
 */
@Entity
@Table(name = "facturaCompraCabecera")
public class FacturaCompraCabecera implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Temporal(TemporalType.DATE)
    private Date fecha;
    private double total;
    private List<FacturaCompraDetalle> listaFacturaCompraDetalle;

    public FacturaCompraCabecera() {
    }

    public FacturaCompraCabecera(int id, Date fecha, double total, List<FacturaCompraDetalle> listaFacturaCompraDetalle) {
        this.id = id;
        this.fecha = fecha;
        this.total = total;
        this.listaFacturaCompraDetalle = listaFacturaCompraDetalle;
    }

     public FacturaCompraCabecera(int id, Date fecha, double total) {
        this.id = id;
        this.fecha = fecha;
        this.total = total;
        this.listaFacturaCompraDetalle = new ArrayList<>();
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

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public List<FacturaCompraDetalle> getListaFacturaCompraDetalle() {
        return listaFacturaCompraDetalle;
    }

    public void setListaFacturaCompraDetalle(List<FacturaCompraDetalle> listaFacturaCompraDetalle) {
        this.listaFacturaCompraDetalle = listaFacturaCompraDetalle;
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
        if (!(object instanceof FacturaCompraCabecera)) {
            return false;
        }
        FacturaCompraCabecera other = (FacturaCompraCabecera) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "FacturaCompraCabecera{" + "id=" + id + ", fecha=" + fecha + ", total=" + total + ", listaFacturaCompraDetalle=" + listaFacturaCompraDetalle + '}';
    }

 
}
