/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.consultoriomedico.beans;

import ec.edu.ups.consultoriomedico.facade.DoctorFacade;
import ec.edu.ups.consultoriomedico.modelo.Doctor;
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
 * @author edwin
 */
@Named
@SessionScoped
public class DoctorBean implements Serializable {

    private static final long serialVersionUID = 1L;
    @EJB
    private DoctorFacade doctorFacade;
    private List<Doctor> list = new ArrayList<>();
    private int id;
    private String nombreCompleto;
    private String cedula;
    private String especialidad;
    private String celular;
    private String email;
    private String direccion;
    private boolean estado;
    private Date fechaNacimiento;

    @PostConstruct
    public void init() {
        list = doctorFacade.findAll();
    }

    public String add() {
        doctorFacade.create(new Doctor(especialidad, id, nombreCompleto, cedula, celular, email, direccion, true, fechaNacimiento));
        list = doctorFacade.findAll();
        this.limpiar();
        return null;
    }

    public String delete(Doctor doctor) {
        doctor.setEstado(false);
        doctorFacade.edit(doctor);
        list = doctorFacade.findAll();
        return null;
    }

    public List<Doctor> listaDoctors() {
        List<Doctor> listasUuU = new ArrayList<>();//listar usu
        for (Doctor doctor : list) {
            if (doctor.isEstado() == true) {
                listasUuU.add(doctor);
            }
        }
        return listasUuU;
    }

    public String edit(Doctor doctor) {
        doctorFacade.edit(doctor);
        return null;
    }

    public Doctor[] getList() {
        return list.toArray(new Doctor[0]);
    }

    public void setList(List<Doctor> list) {
        this.list = list;
    }

    public DoctorFacade getDoctorFacade() {
        return doctorFacade;
    }

    public void setDoctorFacade(DoctorFacade doctorFacade) {
        this.doctorFacade = doctorFacade;
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

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
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

    public void limpiar() {
        this.nombreCompleto = "";
        this.cedula = "";
        this.celular = "";
        this.email = "";
        this.direccion = "";
        this.estado = true;
    }

}
