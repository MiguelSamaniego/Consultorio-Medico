/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.consultoriomedico.beans;

import ec.edu.ups.consultoriomedico.facade.ColaboradorFacade;
import ec.edu.ups.consultoriomedico.modelo.Colaborador;
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
public class ColaboradorBean implements Serializable {

    private static final long serialVersionUID = 1L;
    @EJB
    private ColaboradorFacade colaboradorFacade;
    private List<Colaborador> list = new ArrayList<>();
    private Colaborador colaborador;
    private int id;
    private String nombreCompleto;
    private String cedula;
    private String tipoColaborador;
    private String celular;
    private String email;
    private String direccion;
    private boolean estado;
    private Date fechaNacimiento;

    @PostConstruct
    public void init() {
        list = colaboradorFacade.findAll();
       // listaColaboradores();
    }

    public List<Colaborador> listaColaboradores() {
        List<Colaborador> listasUuU = new ArrayList<>();//listar usu
        for (Colaborador colaborador : list) {
            if (colaborador.isEstado()==true) {
                listasUuU.add(colaborador);
            }
        }
        return listasUuU;
    }
    
    public String add() {
        colaboradorFacade.create(new Colaborador(tipoColaborador, id, nombreCompleto, cedula, celular, email, direccion, true, fechaNacimiento));
        list = colaboradorFacade.findAll();
        this.limpiar();
        return null;
    }

    public String delete(Colaborador colaborador) {
        colaborador.setEstado(false);
         colaboradorFacade.edit(colaborador);
        list = colaboradorFacade.findAll();
        return null;
    }

    public String edit(Colaborador colaborador) {
        colaboradorFacade.edit(colaborador);
        return null;
    }

    public Colaborador[] getList() {
        return list.toArray(new Colaborador[0]);
    }

    public void setList(List<Colaborador> list) {
        this.list = list;
    }

    public ColaboradorFacade getColaboradorFacade() {
        return colaboradorFacade;
    }

    public void setColaboradorFacade(ColaboradorFacade colaboradorFacade) {
        this.colaboradorFacade = colaboradorFacade;
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

    public String getTipoColaborador() {
        return tipoColaborador;
    }

    public void setTipoColaborador(String tipoColaborador) {
        this.tipoColaborador = tipoColaborador;
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

    public Colaborador getColaborador() {
        return colaborador;
    }

    public void setColaborador(Colaborador colaborador) {
        this.colaborador = colaborador;
    }

   
    
    public void limpiar() {
        this.nombreCompleto = "";
        this.cedula = "";
        this.celular = "";
        this.email = "";
        this.direccion = "";

    }
}
