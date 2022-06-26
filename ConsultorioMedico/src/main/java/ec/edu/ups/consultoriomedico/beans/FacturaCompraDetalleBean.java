/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.consultoriomedico.beans;

import ec.edu.ups.consultoriomedico.facade.FacturaCompraDetalleFacade;
import ec.edu.ups.consultoriomedico.modelo.FacturaCompraDetalle;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Adrian
 */
@Named
@SessionScoped
public class FacturaCompraDetalleBean {

    @EJB
    private FacturaCompraDetalleFacade facturacompraDetalleFacade;
    private int id;
    private String producto;
    private int cantidad;
    private double precio;
    private double total;
    private List<FacturaCompraDetalle> listaFactCompraD = new ArrayList<>();

    @PostConstruct
    public void init() {
        listaFactCompraD = facturacompraDetalleFacade.findAll();
    }

    public FacturaCompraDetalleFacade getFacturacompraDetalleFacade() {
        return facturacompraDetalleFacade;
    }

    public void setFacturacompraDetalleFacade(FacturaCompraDetalleFacade facturacompraDetalleFacade) {
        this.facturacompraDetalleFacade = facturacompraDetalleFacade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public List<FacturaCompraDetalle> getListaFactCompraD() {
        return listaFactCompraD;
    }

    public void setListaFactCompraD(List<FacturaCompraDetalle> listaFactCompraD) {
        this.listaFactCompraD = listaFactCompraD;
    }
    

}
