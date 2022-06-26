package ec.edu.ups.consultoriomedico.beans;

import ec.edu.ups.consultoriomedico.facade.FacturaCompraCabeceraFacade;
import ec.edu.ups.consultoriomedico.modelo.FacturaCompraCabecera;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Adrian
 */
@Named
@SessionScoped
public class FacturaCompraCabeceraBean {

    @EJB
    private FacturaCompraCabeceraFacade facturaCompraCabeceraFacade;
    private int id;
    private Date fecha;
    private double total;
    private List<FacturaCompraCabecera> listaFacturaCompraC;

    @PostConstruct
    public void init() {
        listaFacturaCompraC = facturaCompraCabeceraFacade.findAll();
    }

    public FacturaCompraCabeceraFacade getFacturaCompraCabeceraFacade() {
        return facturaCompraCabeceraFacade;
    }

    public void setFacturaCompraCabeceraFacade(FacturaCompraCabeceraFacade facturaCompraCabeceraFacade) {
        this.facturaCompraCabeceraFacade = facturaCompraCabeceraFacade;
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

    public List<FacturaCompraCabecera> getListaFacturaCompraC() {
        return listaFacturaCompraC;
    }

    public void setListaFacturaCompraC(List<FacturaCompraCabecera> listaFacturaCompraC) {
        this.listaFacturaCompraC = listaFacturaCompraC;
    }
    
    
}
