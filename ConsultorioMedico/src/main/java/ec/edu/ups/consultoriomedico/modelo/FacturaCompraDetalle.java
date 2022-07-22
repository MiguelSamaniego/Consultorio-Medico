package ec.edu.ups.consultoriomedico.modelo;

import jakarta.persistence.Table;
import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

/**
 *
 * @author Adrian
 */
@Entity
@Table(name = "facturaCompraDetalle")
public class FacturaCompraDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String producto;
    private int cantidad;
    private double precio;
    private double total;
    @ManyToOne
    private FacturaCompraCabecera cabeceraCompra;
    public FacturaCompraDetalle() {
    }

    public FacturaCompraDetalle(int id, String producto, int cantidad, double precio, double total) {
        this.id = id;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precio = precio;
        this.total = total;
    }

    public FacturaCompraDetalle(String producto, int cantidad, double precio) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public FacturaCompraDetalle(int id, String producto, int cantidad, double precio, double total, FacturaCompraCabecera cabeceraCompra) {
        this.id = id;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precio = precio;
        this.total = total;
        this.cabeceraCompra = cabeceraCompra;
    }

    public FacturaCompraCabecera getCabeceraCompra() {
        return cabeceraCompra;
    }

    public void setCabeceraCompra(FacturaCompraCabecera cabeceraCompra) {
        this.cabeceraCompra = cabeceraCompra;
    }


    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
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
        if (!(object instanceof FacturaCompraDetalle)) {
            return false;
        }
        FacturaCompraDetalle other = (FacturaCompraDetalle) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "FacturaCompraDetalle{" + "id=" + id + ", producto=" + producto + ", cantidad=" + cantidad + ", precio=" + precio + ", total=" + total + '}';
    }


}
