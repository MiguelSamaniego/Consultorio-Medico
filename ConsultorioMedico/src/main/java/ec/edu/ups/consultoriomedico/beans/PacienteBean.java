/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.consultoriomedico.beans;

import ec.edu.ups.consultoriomedico.facade.ColaboradorFacade;
import ec.edu.ups.consultoriomedico.facade.ConsultaFacade;
import ec.edu.ups.consultoriomedico.facade.DoctorFacade;
import ec.edu.ups.consultoriomedico.facade.PacienteFacade;
import ec.edu.ups.consultoriomedico.facade.PrescripcionCabeceraFacade;
import ec.edu.ups.consultoriomedico.facade.PrescripcionDetalleFacade;
import ec.edu.ups.consultoriomedico.modelo.Paciente;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.Set;
import ec.edu.ups.consultoriomedico.pojos.PacientePojo;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;

/**
 *
 * @author pcuser
 */
@Named
@SessionScoped
public class PacienteBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private List<PacientePojo> list = new ArrayList<PacientePojo>();
    private int id;
    private String nombreCompleto;
    private String cedula;
    private String celular;
    private String email;
    private String direccion;
    private boolean estado;
    private GregorianCalendar fechaNacimiento;
    private GregorianCalendar primerIngreso;
    GregorianCalendar fecha = new GregorianCalendar();
    private int contador;
    @EJB
    private PacienteFacade ejbPaciente;

    public PacienteBean() {
        contador = 5;
        Paciente paciente = new Paciente(fecha, 0, "Migel Angel", "1400789721", "0984532324", "paciente@gmail.com", "Adolfot Torres", true, fecha);
        //ejbPaciente.create(paciente);
        PacientePojo pacientePojo = new PacientePojo(fecha, 0, "Migel Angel", "1400789755", "0984532324", "paciente@gmail.com", "Adolfot Torres", true, fecha);
        this.list.add(pacientePojo);
        PacientePojo pacientePojo1 = new PacientePojo(fecha, 1, "Migel Angel", "1400789721", "0984532321", "paciente1@gmail.com", "Ado1lfot Torres", true, fecha);
        this.list.add(pacientePojo1);
        System.out.println("controlador Miguel Angel 123");
    }

    public String add() {
        System.out.println("Mensaje para guardar en el boton");
        //this.list.add(new PacientePojo(primerIngreso, id, nombreCompleto, cedula, celular, email, direccion, estado, fechaNacimiento));
        contador += 1;
        String cont
                = String.valueOf(contador); // this.list.add(new Row(id, name, quantity));
        PacientePojo pacientePojo2 = new PacientePojo(fecha, 2, "Migel Angel",
                "1400789722" + cont, "0984532323", "paciente1@gmail.com", "Adolfot Torres1", true, fecha);
        this.list.add(pacientePojo2);
        Paciente p = new Paciente(fecha, 2, "Migel Samaniego", "1400789728", "0984532323",
                "paciente1@gmail.com", "Adolfot Torres1", true, fecha);
        ejbPaciente.create(p);
        System.out.println("Impresion de prueba");
        return null;
    }

    public String delete(PacientePojo t) {
        this.list.remove(t);
        return null;
    }

    public String edit(PacientePojo t) {
        t.setEditable(true);
        return null;
    }

    public String save(PacientePojo t) {
        t.setEditable(false);
        return null;
    }

    public PacientePojo[] getList() {
        return list.toArray(new PacientePojo[0]);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public GregorianCalendar getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(GregorianCalendar fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public GregorianCalendar getPrimerIngreso() {
        return primerIngreso;
    }

    public void setPrimerIngreso(GregorianCalendar primerIngreso) {
        this.primerIngreso = primerIngreso;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    /**
     * private static final long serialVersionUID = 1L; private
     * List<PacientePojo> list = new ArrayList<PacientePojo>(); private int id;
     * private String nombreCompleto; private String cedula; private String
     * celular; private String email; private String direccion; private boolean
     * estado; private GregorianCalendar fechaNacimiento; private
     * GregorianCalendar primerIngreso; GregorianCalendar fecha = new
     * GregorianCalendar();
     *
     * @EJB private PacienteFacade ejbPaciente; private int contador;
     *
     * public PacienteBean() {
     *
     * contador = 5; Paciente paciente = new Paciente(fecha, 0, "Migel Angel",
     * "1400789721", "0984532324", "paciente@gmail.com", "Adolfot Torres", true,
     * fecha); //ejbPaciente.create(paciente); PacientePojo pacientePojo = new
     * PacientePojo(fecha, 0, "Migel Angel", "1400789721", "0984532324",
     * "paciente@gmail.com", "Adolfot Torres", true, fecha);
     * this.list.add(pacientePojo); PacientePojo pacientePojo1 = new
     * PacientePojo(fecha, 1, "Migel Angel", "1400789721", "0984532321",
     * "paciente1@gmail.com", "Ado1lfot Torres", true, fecha);
     * this.list.add(pacientePojo1); System.out.println("controlador Miguel
     * Angel 123");
     *
     * }
     *
     * public String delete(PacientePojo t) { this.list.remove(t);
     * System.out.println("Mensaje de Eliminado"); return null; }
     *
     * public String add() { contador += 1; String cont =
     * String.valueOf(contador); // this.list.add(new Row(id, name, quantity));
     * PacientePojo pacientePojo2 = new PacientePojo(fecha, 2, "Migel Angel",
     * "1400789722" + cont, "0984532323", "paciente1@gmail.com", "Adolfot
     * Torres1", true, fecha); this.list.add(pacientePojo2); Paciente p = new
     * Paciente(fecha, 2, "Migel Samaniego", "1400789728", "0984532323",
     * "paciente1@gmail.com", "Adolfot Torres1", true, fecha);
     * ejbPaciente.create(p); System.out.println("Impresion de prueba"); return
     * null; }
     *
     * public String edit(PacientePojo t) { t.setEditable(true); return null; }
     *
     * public String save(PacientePojo t) { t.setEditable(false); return null; }
     *
     * public PacientePojo[] getList() { return list.toArray(new
     * PacientePojo[0]);
     *
     * }
     *
     * public String getCedula() { return cedula; }
     *
     * public void setCedula(String cedula) { this.cedula = cedula; }
     *
     * public String getCelular() { return celular; }
     *
     * public void setCelular(String celular) { this.celular = celular; }
     *
     * public String getDireccion() { return direccion; }
     *
     * public void setDireccion(String direccion) { this.direccion = direccion;
     * }
     *
     * public String getNombreCompleto() { return nombreCompleto; }
     *
     * public void setNombreCompleto(String nombreCompleto) {
     * this.nombreCompleto = nombreCompleto; }
     *
     * public String getEmail() { return email; }
     *
     * public void setEmail(String email) { this.email = email; }
     *
     * public boolean isEstado() { return estado; }
     *
     * public void setEstado(boolean estado) { this.estado = estado; }
     *
     * public GregorianCalendar getFechaNacimiento() { return fechaNacimiento; }
     *
     * public void setFechaNacimiento(GregorianCalendar fechaNacimiento) {
     * this.fechaNacimiento = fechaNacimiento; }
     *
     * public GregorianCalendar getPrimerIngreso() { return primerIngreso; }
     *
     * public void setPrimerIngreso(GregorianCalendar primerIngreso) {
     * this.primerIngreso = primerIngreso; }
     */
}
