package ec.edu.ups.consultoriomedico.beans;

import ec.edu.ups.consultoriomedico.facade.ControlFacturaFacade;
import ec.edu.ups.consultoriomedico.modelo.ControlFactura;
import ec.edu.ups.consultoriomedico.modelo.FacturaCompraCabecera;
import ec.edu.ups.consultoriomedico.modelo.FacturaInterna;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Adrian
 */
@Named
@SessionScoped
public class ControlFacturaBean {

    @EJB
    private ControlFacturaFacade controlFacturaFacade;
    private int id;
    private FacturaCompraCabecera facturaCompraCabecera;
    private FacturaInterna facturaInterna;
    private List<ControlFactura> listacontrolFactura = new ArrayList<>();
    
    @PostConstruct
    public void init(){
        listacontrolFactura=controlFacturaFacade.findAll();
    }

    public ControlFacturaFacade getControlFacturaFacade() {
        return controlFacturaFacade;
    }

    public void setControlFacturaFacade(ControlFacturaFacade controlFacturaFacade) {
        this.controlFacturaFacade = controlFacturaFacade;
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

    public List<ControlFactura> getListacontrolFactura() {
        return listacontrolFactura;
    }

    public void setListacontrolFactura(List<ControlFactura> listacontrolFactura) {
        this.listacontrolFactura = listacontrolFactura;
    }
    
}
