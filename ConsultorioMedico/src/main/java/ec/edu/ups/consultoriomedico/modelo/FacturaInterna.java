package ec.edu.ups.consultoriomedico.modelo;

import jakarta.persistence.Table;
import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;

/**
 *
 * @author Adrian
 */
@Entity
@Table(name = "facturaInterna")
public class FacturaInterna implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Temporal(TemporalType.DATE)
    private Date fecha;
    private Paciente paciente;
    private Doctor doctor;
    private double subtotal;
    private double iva;
    private double total;

    public FacturaInterna() {
    }

    public FacturaInterna(int id, Date fecha, Paciente paciente, Doctor doctor, double subtotal, double iva, double total) {
        this.id = id;
        this.fecha = fecha;
        this.paciente = paciente;
        this.doctor = doctor;
        this.subtotal = subtotal;
        this.iva = iva;
        this.total = total;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
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
        if (!(object instanceof FacturaInterna)) {
            return false;
        }
        FacturaInterna other = (FacturaInterna) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "FacturaInterna{" + "id=" + id + ", fecha=" + fecha + ", paciente=" + paciente + ", doctor=" + doctor + ", subtotal=" + subtotal + ", iva=" + iva + ", total=" + total + '}';
    }

 

}
