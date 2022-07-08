/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.consultoriomedico.beans;

import ec.edu.ups.consultoriomedico.facade.UsuarioFacade;
import ec.edu.ups.consultoriomedico.modelo.Usuario;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
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
public class UsuarioClave implements Serializable {

    @EJB
    private UsuarioFacade usuarioFacade;

    private Usuario usuario;

    @PostConstruct
    public void init() {
        this.usuario = new Usuario();
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
