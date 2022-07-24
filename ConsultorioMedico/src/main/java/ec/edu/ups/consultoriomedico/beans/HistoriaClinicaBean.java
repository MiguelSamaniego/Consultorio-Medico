/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.consultoriomedico.beans;

import ec.edu.ups.consultoriomedico.facade.HistoriaClinicaFacade;
import ec.edu.ups.consultoriomedico.modelo.Consulta;
import ec.edu.ups.consultoriomedico.modelo.HistoriaClinica;
import ec.edu.ups.consultoriomedico.modelo.Paciente;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
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
public class HistoriaClinicaBean implements Serializable {

    @EJB
    private HistoriaClinicaFacade historiaClinicaFacade;
    private int id;
    private Paciente paciente;
    private List<Consulta> listaConsultas;
    private List<HistoriaClinica> listaHistoriaClinica = new ArrayList<>();
    
    @PostConstruct
    public void init() {
        listaHistoriaClinica = historiaClinicaFacade.findAll();
    }
    
    public String add(){
        historiaClinicaFacade.create(new HistoriaClinica(id,paciente,listaConsultas));
        listaHistoriaClinica = historiaClinicaFacade.findAll();
        return null;
    }
    
  
}
