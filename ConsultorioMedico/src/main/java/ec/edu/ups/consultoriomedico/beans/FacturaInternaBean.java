package ec.edu.ups.consultoriomedico.beans;

import ec.edu.ups.consultoriomedico.facade.FacturaInternaFacade;
import ec.edu.ups.consultoriomedico.modelo.Doctor;
import ec.edu.ups.consultoriomedico.modelo.FacturaInterna;
import ec.edu.ups.consultoriomedico.modelo.Paciente;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Adrian
 */
@Named
@SessionScoped
public class FacturaInternaBean implements Serializable {

    @EJB
    private FacturaInternaFacade facturaInternaFacade;
    private int id;
    private Date fecha;
    private Paciente paciente;
    private Doctor doctor;
    private double subtotal;
    private double iva;
    private double total;
    private List<FacturaInterna> listFacturaIn = new ArrayList<>();

    @PostConstruct
    public void init() {
        listFacturaIn = facturaInternaFacade.findAll();
    }

    public String add() {
        facturaInternaFacade.create(new FacturaInterna(id, fecha, paciente, doctor, subtotal, iva, total));
        listFacturaIn = facturaInternaFacade.findAll();
        return null;
    }

    public String delete(FacturaInterna f) {
        facturaInternaFacade.remove(f);
        listFacturaIn = facturaInternaFacade.findAll();
        return null;
    }

    public void edit(FacturaInterna f) {
        facturaInternaFacade.edit(f);
        listFacturaIn = facturaInternaFacade.findAll();
    }

    public FacturaInternaFacade getFacturaInternaFacade() {
        return facturaInternaFacade;
    }

    public void setFacturaInternaFacade(FacturaInternaFacade facturaInternaFacade) {
        this.facturaInternaFacade = facturaInternaFacade;
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

    public FacturaInterna[] getList() {
        return listFacturaIn.toArray(new FacturaInterna[0]);
    }

    public void setListFacturaIn(List<FacturaInterna> listFacturaIn) {
        this.listFacturaIn = listFacturaIn;
    }

}
