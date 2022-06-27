/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.consultoriomedico.beans;

import ec.edu.ups.consultoriomedico.facade.PacienteFacade;
import ec.edu.ups.consultoriomedico.modelo.Paciente;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 *
 * @author edwin
 */
@Named
@SessionScoped
public class PacienteBean implements Serializable {

    private static final long serialVersionUID = 1L;
    @EJB
    private PacienteFacade pacienteFacade;
    private List<Paciente> list = new ArrayList<>();
    private Paciente paciente;
    private int id;
    private String nombreCompleto;
    private String cedula;
    private String celular;
    private String email;
    private String direccion;
    private boolean estado;
    private Date fechaNacimiento;
    private GregorianCalendar primerIngreso;

    @PostConstruct
    public void init() {
        list = pacienteFacade.findAll();
    }

    public String add() {
        pacienteFacade.create(new Paciente(new GregorianCalendar(), id, nombreCompleto, cedula, celular, email, direccion, true, fechaNacimiento));
        list = pacienteFacade.findAll();
        this.limpiar();
        return null;
    }

    public List<Paciente> listaPacientes() {
        List<Paciente> listasUuU = new ArrayList<>();//listar usu
        for (Paciente paciente : list) {
            if (paciente.isEstado() == true) {
                listasUuU.add(paciente);
            }
        }
        return listasUuU;
    }

    public List<Paciente> listaPacientesBaja() {
        List<Paciente> listasUuU = new ArrayList<>();//listar usu
        for (Paciente paciente : list) {
            if (paciente.isEstado() == false) {
                listasUuU.add(paciente);
            }
        }
        return listasUuU;
    }

    public String delete(Paciente paciente) {
        paciente.setEstado(false);
        pacienteFacade.edit(paciente);
        list = pacienteFacade.findAll();
        return null;
    }

    public String activar(Paciente paciente) {
        paciente.setEstado(true);
        pacienteFacade.edit(paciente);
        list = pacienteFacade.findAll();
        return null;
    }

    public String edit(Paciente paciente) {
        pacienteFacade.edit(paciente);
        list = pacienteFacade.findAll();
        return null;
    }

    public Paciente[] getList() {
        return list.toArray(new Paciente[0]);
    }

    public void setList(List<Paciente> list) {
        this.list = list;
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

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Date fechaIngreso(Paciente paciente) {
        Date fechaIngreso = paciente.getPrimerIngreso().getTime();

        return fechaIngreso;
    }

    public void limpiar() {
        this.nombreCompleto = "";
        this.cedula = "";
        this.celular = "";
        this.email = "";
        this.direccion = "";

    }

}
