/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.consultoriomedico.beans;

import ec.edu.ups.consultoriomedico.facade.CitaFacade;
import ec.edu.ups.consultoriomedico.facade.ColaboradorFacade;
import ec.edu.ups.consultoriomedico.facade.DoctorFacade;
import ec.edu.ups.consultoriomedico.facade.PacienteFacade;
import ec.edu.ups.consultoriomedico.modelo.Cita;
import ec.edu.ups.consultoriomedico.modelo.Colaborador;
import ec.edu.ups.consultoriomedico.modelo.Doctor;
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
 * @author pcuser
 */
@Named
@SessionScoped
public class CitaBean implements Serializable {
     private static final long serialVersionUID = 1L;
    @EJB
    private CitaFacade citaFacade;
    @EJB
    private PacienteFacade pacienteFacade;
    @EJB
    private DoctorFacade doctorFacade;
    private List<Cita> list = new ArrayList<>();
    private List<Paciente> listPacientes = new ArrayList<>();
    private List<Doctor> listDoctores = new ArrayList<>();
    private Paciente paciente;
    private Doctor doctor;
    private String hora;
    private String cedula;
    private Date fecha;

    @PostConstruct
    public void init() {
        list = citaFacade.findAll();
        listPacientes=pacienteFacade.findAll();
        listDoctores=doctorFacade.findAll();
        this.doctor= new Doctor();
    }
    
    public void add(){
        buscarPaciente(cedula);
        Cita cita = new Cita(0, paciente, doctor, fecha, hora);
        citaFacade.create(cita);
        
    }
    
    public String edit(Cita cita) {
        citaFacade.edit(cita);
        list = citaFacade.findAll();
        return null;
    }
    public void buscarPaciente(String cedula){
        listPacientes= pacienteFacade.findAll();
        for (Paciente paciente :listPacientes) {
            if(paciente.getCedula().equals(cedula)){
                this.paciente=  paciente;
            }
        }
       
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }


    

    public CitaFacade getCitaFacade() {
        return citaFacade;
    }

    public void setCitaFacade(CitaFacade citaFacade) {
        this.citaFacade = citaFacade;
    }

    public PacienteFacade getPacienteFacade() {
        return pacienteFacade;
    }

    public void setPacienteFacade(PacienteFacade pacienteFacade) {
        this.pacienteFacade = pacienteFacade;
    }

    public DoctorFacade getDoctorFacade() {
        return doctorFacade;
    }

    public void setDoctorFacade(DoctorFacade doctorFacade) {
        this.doctorFacade = doctorFacade;
    }

    public List<Cita> getList() {
        return list;
    }

    public void setList(List<Cita> list) {
        this.list = list;
    }

    public List<Paciente> getListPacientes() {
        return listPacientes;
    }

    public void setListPacientes(List<Paciente> listPacientes) {
        this.listPacientes = listPacientes;
    }

    public List<Doctor> getListDoctores() {
        return listDoctores;
    }

    public void setListDoctores(List<Doctor> listDoctores) {
        this.listDoctores = listDoctores;
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

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    
    
    
    
}
