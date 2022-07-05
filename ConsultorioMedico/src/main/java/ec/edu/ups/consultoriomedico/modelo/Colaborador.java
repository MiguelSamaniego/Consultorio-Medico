/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.consultoriomedico.modelo;

import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.util.Date;
import java.util.GregorianCalendar;
///////////Hola dos 
/**
 *
 * @author pcuser
 */
@Entity
@Table(name = "colaborador")
public class Colaborador extends Persona implements Serializable {

    private String tipoColaborador;

    public Colaborador() {
    }

    public Colaborador(String tipoColaborador) {
        this.tipoColaborador = tipoColaborador;
    }

    public Colaborador(String tipoColaborador, int id, String nombreCompleto, String cedula, String celular, String email, String direccion, boolean estado, Date fechaNacimiento) {
        super(id, nombreCompleto, cedula, celular, email, direccion, estado, fechaNacimiento);
        this.tipoColaborador = tipoColaborador;
    }

    public String getTipoColaborador() {
        return tipoColaborador;
    }

    public void setTipoColaborador(String tipoColaborador) {
        this.tipoColaborador = tipoColaborador;
    }

}
