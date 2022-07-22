/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.consultoriomedico.beans;

import ec.edu.ups.consultoriomedico.facade.FacturaCompraCabeceraFacade;
import ec.edu.ups.consultoriomedico.facade.FacturaCompraDetalleFacade;
import ec.edu.ups.consultoriomedico.modelo.FacturaCompraCabecera;
import ec.edu.ups.consultoriomedico.modelo.FacturaCompraDetalle;
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
public class FacturaCompraDetalleBean implements Serializable {

    @EJB
    private FacturaCompraDetalleFacade facturacompraDetalleFacade;
    @EJB
    private FacturaCompraCabeceraFacade facturaCompraCabeceraFacade;
    private int id;
    private String producto;
    private int cantidad;
    private double precio;
    private double total;
    private FacturaCompraCabecera cabeceraCompra;
    private double totalFinal;
    private List<FacturaCompraCabecera> listaCabeceraCom = new ArrayList<>();
    private List<FacturaCompraDetalle> listaenBlanco = new ArrayList<>();

    @PostConstruct
    public void init() {
        listaenBlanco = new ArrayList<>();
  
    }

    public String guardarFactura() {
        FacturaCompraCabecera fc = new FacturaCompraCabecera(id, new Date(), totalFinal);
        System.out.println("holagfdgdfgfdg "+fc + id);
        facturaCompraCabeceraFacade.create(fc);
        for (FacturaCompraDetalle det : listaenBlanco) {
            
            facturacompraDetalleFacade.create(det);
            det.setCabeceraCompra(fc);
            facturacompraDetalleFacade.edit(det);
        }
        fc.setListaFacturaCompraDetalle(listaenBlanco);
        facturaCompraCabeceraFacade.edit(fc);
        listaenBlanco = new ArrayList<>();
//        listaCabeceraCom= facturaCompraCabeceraFacade.findAll();
//        this.limpiar();
        totalFinal = 0;
        return null;
    }

    public void add2() {
        FacturaCompraDetalle fac = new FacturaCompraDetalle(producto, cantidad, precio);
        fac.setTotal(cantidad * precio);
        totalFinal = fac.getTotal() + totalFinal;
        listaenBlanco.add(fac);
    }

    public void edit(FacturaCompraDetalle s) {

        for (FacturaCompraDetalle detalle : listaenBlanco) {
            if (s.equals(detalle)) {
                listaenBlanco.set(0, detalle);
            }
        }
    }

    public double obtenerTotalFinal() {

        return totalFinal;
    }

    public String delete(FacturaCompraDetalle s) {
        listaenBlanco.remove(s);
        return null;
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

    public List<FacturaCompraDetalle> getListaenBlanco() {
        return listaenBlanco;
    }

    public void setListaenBlanco(List<FacturaCompraDetalle> listaenBlanco) {
        this.listaenBlanco = listaenBlanco;
    }

    public String getProducto() {
        return producto;
    }

    public FacturaCompraCabeceraFacade getFacturaCompraCabeceraFacade() {
        return facturaCompraCabeceraFacade;
    }

    public void setFacturaCompraCabeceraFacade(FacturaCompraCabeceraFacade facturaCompraCabeceraFacade) {
        this.facturaCompraCabeceraFacade = facturaCompraCabeceraFacade;
    }

    public FacturaCompraCabecera getCabeceraCompra() {
        return cabeceraCompra;
    }

    public void setCabeceraCompra(FacturaCompraCabecera cabeceraCompra) {
        this.cabeceraCompra = cabeceraCompra;
    }

    public double getTotalFinal() {
        return totalFinal;
    }

    public void setTotalFinal(double totalFinal) {
        this.totalFinal = totalFinal;
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

    public List<FacturaCompraCabecera> getListaCabeceraCom() {
        return listaCabeceraCom;
    }

    public void setListaCabeceraCom(List<FacturaCompraCabecera> listaCabeceraCom) {
        this.listaCabeceraCom = listaCabeceraCom;
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

 

}
