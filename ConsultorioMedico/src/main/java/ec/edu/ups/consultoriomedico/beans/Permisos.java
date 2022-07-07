/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.consultoriomedico.beans;

import ec.edu.ups.consultoriomedico.modelo.Usuario;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import java.io.Serializable;

/**
 *
 * @author edwin
 */
@Named
@RequestScoped
public class Permisos implements Serializable {

    public void verificarSesion() {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            //Casteo
            Usuario us = (Usuario) context.getExternalContext().getSessionMap().get("usuario"); // (get) con esto hago un seguimiento de la sesion iniciada

            if (us == null) {
                context.getExternalContext().redirect("../colaborador/permisos.html"); //redirecciono al login 
            }
        } catch (Exception e) {
            System.out.println("No entro");
        }
    }
}
