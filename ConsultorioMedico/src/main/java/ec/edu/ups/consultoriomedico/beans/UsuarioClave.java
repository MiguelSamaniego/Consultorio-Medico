/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.consultoriomedico.beans;

import ec.edu.ups.consultoriomedico.facade.UsuarioFacade;
import ec.edu.ups.consultoriomedico.modelo.Doctor;
import ec.edu.ups.consultoriomedico.modelo.Rol;
import ec.edu.ups.consultoriomedico.modelo.Usuario;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author edwin
 */
@Named
@RequestScoped
public class UsuarioClave implements Serializable {

    @EJB
    private UsuarioFacade usuarioFacade;

    private Usuario usuario;

    @PostConstruct
    public void init() {
        this.usuario = new Usuario();
        //Usuario u = new Usuario(0, "tonny", "4050", new Doctor(0, "Tonny Lema Jaramillo", "78878787", "97879", "sdf@sfdds.com", "dsfsdsd", true, f), Rol.DOCTOR);
        // Date f = new Date();
        //Doctor d = new Doctor(0, "Edwin Angamarca", "78878787", "97879", "sdf@sfdds.com", "dsfsdsd", true, f);
        //usuarioFacade.create(new Usuario(0, "EDWIN", "EDWIN", , Rol.DOCTOR));
        Usuario usuario = new Usuario(0, "Adry", "Adry", null, Rol.DOCTOR);
        usuarioFacade.create(usuario);

    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String iniciarSesion() {
        Usuario us;
        String redireccion = null;
        System.out.println(this.usuario.getUsuario());
        try {
            us = usuarioFacade.iniciarUsuario(usuario);
            if (us != null) {
                //Almacenar en la sesion de JSF
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", us);// (put) con esto hago un seguimiento de la sesion iniciada
                redireccion = "paciente/paciente?faces-redirect=true";

            } else {
                System.out.println("Entro mal");
            }

        } catch (Exception e) {
        }
        return redireccion;
    }
}
