/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.consultoriomedico.beans;

import ec.edu.ups.consultoriomedico.facade.ColaboradorFacade;
import ec.edu.ups.consultoriomedico.facade.PrescripcionCabeceraFacade;
import ec.edu.ups.consultoriomedico.facade.PrescripcionDetalleFacade;
import ec.edu.ups.consultoriomedico.facade.ConsultaFacade;
import ec.edu.ups.consultoriomedico.facade.PacienteFacade;

import ec.edu.ups.consultoriomedico.modelo.Colaborador;
import ec.edu.ups.consultoriomedico.modelo.Consulta;
import ec.edu.ups.consultoriomedico.modelo.Doctor;
import ec.edu.ups.consultoriomedico.modelo.Paciente;
import ec.edu.ups.consultoriomedico.modelo.PrescripcionCabecera;
import ec.edu.ups.consultoriomedico.modelo.PrescripcionDetalle;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author pcuser
 */
@Named
@SessionScoped
public class ConsultaBean implements Serializable {

    private static final long serialVersionUID = 1L;
    @EJB
    private ConsultaFacade consultaFacade;
    @EJB
    private PrescripcionCabeceraFacade prescripcionCabeceraFacade;
    @EJB
    private PrescripcionDetalleFacade prescripcionDetalleFacade;
    @EJB
    private PacienteFacade pacienteFacade;

    private Calendar fecha;

    private Paciente paciente;

    private Doctor doctor;

    private String observaciones;

    private int tiempo;

    private List<PrescripcionDetalle> listaPrescripcionesDetalle;

    private List<Consulta> list = new ArrayList<>();

    private List<Paciente> listaPacientes = new ArrayList<>();

    private String medicamento;

    private String tiempoDetratamiento;
    
   private String intervaloDetiempo;
    
    private String cedula;
    
    private Consulta consulta;
    
    private PrescripcionCabecera prescripcionCabecera;
    
    private PrescripcionDetalle prescripcionDetalle;


    
    
    @PostConstruct
    public void init() {
        list = consultaFacade.findAll();
        listaPacientes= pacienteFacade.findAll();

       listaPrescripcionesDetalle= new ArrayList<>();
    }
    
    
    public void buscarPaciente(String cedula){
        for (Paciente paciente :listaPacientes) {
            if(paciente.getCedula().equals(cedula)){
                this.paciente=  paciente;
            }
        }
       
    }

    
    public void  addP(){
        listaPrescripcionesDetalle.add(new PrescripcionDetalle(0, medicamento, tiempoDetratamiento, intervaloDetiempo, null));
    }
    
    public void add(){
        prescripcionCabecera= new PrescripcionCabecera(0, null);
        prescripcionCabeceraFacade.create(prescripcionCabecera);
        for (PrescripcionDetalle prescripcionDetalle1 : listaPrescripcionesDetalle) {
            PrescripcionDetalle detalle= new PrescripcionDetalle(prescripcionDetalle1.getId(), prescripcionDetalle1.getMedicamento(), prescripcionDetalle1.getTiempoDetratamiento(), prescripcionDetalle1.getTiempoDetratamiento(), prescripcionCabecera);
            prescripcionDetalleFacade.create(prescripcionDetalle);
        }
        prescripcionCabecera.setListaPrescripcionesDetalle(listaPrescripcionesDetalle);
        prescripcionCabeceraFacade.edit(prescripcionCabecera);
        
        
        consulta= new Consulta(0, new GregorianCalendar(), paciente, doctor, observaciones, 60, prescripcionCabecera);
        consultaFacade.create(consulta);
        
    }
    
    
    public PrescripcionCabecera getPrescripcionCabecera() {
        return prescripcionCabecera;
    }

    public void setPrescripcionCabecera(PrescripcionCabecera prescripcionCabecera) {
        this.prescripcionCabecera = prescripcionCabecera;
    }

    public PrescripcionDetalle getPrescripcionDetalle() {
        return prescripcionDetalle;
    }

    public void setPrescripcionDetalle(PrescripcionDetalle prescripcionDetalle) {
        this.prescripcionDetalle = prescripcionDetalle;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }
    
    
    

    public ConsultaFacade getConsultaFacade() {
        return consultaFacade;
    }

    public void setConsultaFacade(ConsultaFacade consultaFacade) {
        this.consultaFacade = consultaFacade;
    }

    public PrescripcionCabeceraFacade getPrescripcionCabeceraFacade() {
        return prescripcionCabeceraFacade;
    }

    public void setPrescripcionCabeceraFacade(PrescripcionCabeceraFacade prescripcionCabeceraFacade) {
        this.prescripcionCabeceraFacade = prescripcionCabeceraFacade;
    }

    public PrescripcionDetalleFacade getPrescripcionDetalleFacade() {
        return prescripcionDetalleFacade;
    }

    public void setPrescripcionDetalleFacade(PrescripcionDetalleFacade prescripcionDetalleFacade) {
        this.prescripcionDetalleFacade = prescripcionDetalleFacade;
    }

    public PacienteFacade getPacienteFacade() {
        return pacienteFacade;
    }

    public void setPacienteFacade(PacienteFacade pacienteFacade) {
        this.pacienteFacade = pacienteFacade;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
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

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public List<PrescripcionDetalle> getListaPrescripcionesDetalle() {
        return listaPrescripcionesDetalle;
    }

    public void setListaPrescripcionesDetalle(List<PrescripcionDetalle> listaPrescripcionesDetalle) {
        this.listaPrescripcionesDetalle = listaPrescripcionesDetalle;
    }

    public List<Consulta> getList() {
        return list;
    }

    public void setList(List<Consulta> list) {
        this.list = list;
    }

    public List<Paciente> getListaPacientes() {
        return listaPacientes;
    }

    public void setListaPacientes(List<Paciente> listaPacientes) {
        this.listaPacientes = listaPacientes;
    }

    public String getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(String medicamento) {
        this.medicamento = medicamento;
    }

    public String getTiempoDetratamiento() {
        return tiempoDetratamiento;
    }

    public void setTiempoDetratamiento(String tiempoDetratamiento) {
        this.tiempoDetratamiento = tiempoDetratamiento;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getIntervaloDetiempo() {
        return intervaloDetiempo;
    }

    public void setIntervaloDetiempo(String intervaloDetiempo) {
        this.intervaloDetiempo = intervaloDetiempo;
    }

    
    
    
}
