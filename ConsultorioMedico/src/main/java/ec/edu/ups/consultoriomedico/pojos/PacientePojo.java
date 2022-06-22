/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.consultoriomedico.pojos;

import java.io.Serializable;
import java.util.GregorianCalendar;

/**
 *
 * @author pcuser
 */

public class PacientePojo extends PersonaPojo implements Serializable {

    private GregorianCalendar primerIngreso;
     private boolean editable;
    public PacientePojo() {
    }

    public PacientePojo(GregorianCalendar primerIngreso, int id, String nombreCompleto, String cedula, String celular, String email, String direccion, boolean estado, GregorianCalendar fechaNacimiento) {
        super(id, nombreCompleto, cedula, celular, email, direccion, estado, fechaNacimiento);
        this.primerIngreso = primerIngreso;
    }

    
   

    public GregorianCalendar getPrimerIngreso() {
        return primerIngreso;
    }

    public void setPrimerIngreso(GregorianCalendar primerIngreso) {
        this.primerIngreso = primerIngreso;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    

}
