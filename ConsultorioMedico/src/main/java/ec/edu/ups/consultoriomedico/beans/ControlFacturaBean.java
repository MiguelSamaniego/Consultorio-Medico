package ec.edu.ups.consultoriomedico.beans;

import ec.edu.ups.consultoriomedico.facade.ControlFacturaFacade;
import ec.edu.ups.consultoriomedico.modelo.ControlFactura;
import ec.edu.ups.consultoriomedico.modelo.FacturaCompraCabecera;
import ec.edu.ups.consultoriomedico.modelo.FacturaInterna;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.view.Location;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Adrian
 */
@Named
@SessionScoped
public class ControlFacturaBean implements Serializable {

    @EJB
    private ControlFacturaFacade controlFacturaFacade;
    private int id;
    private FacturaCompraCabecera facturaCompraCabecera;
    private FacturaInterna facturaInterna;
    private List<ControlFactura> listacontrolFactura = new ArrayList<>();

    @PostConstruct
    public void init() {
        listacontrolFactura = controlFacturaFacade.findAll();
    }

    public String add() {
        controlFacturaFacade.create(new ControlFactura(id, facturaCompraCabecera, facturaInterna));
        listacontrolFactura = controlFacturaFacade.findAll();
        return null;
    }

    public String delete(ControlFactura c) {
        controlFacturaFacade.remove(c);
        listacontrolFactura = controlFacturaFacade.findAll();
        return null;
    }

    public void edit(ControlFactura c) {
        controlFacturaFacade.edit(c);
        listacontrolFactura = controlFacturaFacade.findAll();
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

    public ControlFactura[] getList() {
        return listacontrolFactura.toArray(new ControlFactura[0]);
    }

    public void setListacontrolFactura(List<ControlFactura> listacontrolFactura) {
        this.listacontrolFactura = listacontrolFactura;
    }

}
