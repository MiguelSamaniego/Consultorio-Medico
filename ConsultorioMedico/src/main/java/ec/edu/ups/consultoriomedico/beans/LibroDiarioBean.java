/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.consultoriomedico.beans;

import ec.edu.ups.consultoriomedico.facade.LibroDiarioFacade;
import ec.edu.ups.consultoriomedico.modelo.FacturaInterna;
import ec.edu.ups.consultoriomedico.modelo.LibroDiario;
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
public class LibroDiarioBean implements Serializable {

    @EJB
    private LibroDiarioFacade libroDiarioFacade;
    private int id;
    private Date fecha;
    private List<FacturaInterna> listaFacturas;
    private List<LibroDiario> listaLibrosdiarios = new ArrayList<>();
    private double valor;
    private String signo;

    @PostConstruct
    public void init() {
        listaLibrosdiarios = libroDiarioFacade.findAll();
    }

    public String add() {
        libroDiarioFacade.create(new LibroDiario(id, fecha, valor, signo, listaFacturas));
        listaLibrosdiarios = libroDiarioFacade.findAll();
        return null;
    }

    public String delete(LibroDiario l) {
        libroDiarioFacade.remove(l);
        listaLibrosdiarios = libroDiarioFacade.findAll();
        return null;
    }

    public void edit(LibroDiario l) {
        libroDiarioFacade.edit(l);
        listaLibrosdiarios = libroDiarioFacade.findAll();
    }

//    public Date asignarFecha(LibroDiario l){
//        Date d = new Date();
//        if (true) {
//            
//        }else {
//    }
    public LibroDiarioFacade getLibroDiarioFacade() {
        return libroDiarioFacade;
    }

    public void setLibroDiarioFacade(LibroDiarioFacade libroDiarioFacade) {
        this.libroDiarioFacade = libroDiarioFacade;
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

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getSigno() {
        return signo;
    }

    public void setSigno(String signo) {
        this.signo = signo;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public List<FacturaInterna> getListaFacturas() {
        return listaFacturas;
    }

    public void setListaFacturas(List<FacturaInterna> listaFacturas) {
        this.listaFacturas = listaFacturas;
    }

    public LibroDiario[] getList() {
        return listaLibrosdiarios.toArray(new LibroDiario[0]);
    }

    public void setListaLibrosdiarios(List<LibroDiario> listaLibrosdiarios) {
        this.listaLibrosdiarios = listaLibrosdiarios;
    }

}
