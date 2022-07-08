/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.consultoriomedico.beans;

import ec.edu.ups.consultoriomedico.facade.ColaboradorFacade;
import ec.edu.ups.consultoriomedico.facade.DoctorFacade;
import ec.edu.ups.consultoriomedico.facade.UsuarioFacade;
import ec.edu.ups.consultoriomedico.modelo.Colaborador;
import ec.edu.ups.consultoriomedico.modelo.Doctor;
import ec.edu.ups.consultoriomedico.modelo.Persona;
import ec.edu.ups.consultoriomedico.modelo.Rol;
import ec.edu.ups.consultoriomedico.modelo.Usuario;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author edwin
 */
@Named
@SessionScoped
public class UsuarioBean implements Serializable {

    private static final long serialVersionUID = 1L;
    @EJB
    private UsuarioFacade usuarioFacade;
    @EJB
    private ColaboradorFacade colaboradorFacade;
    @EJB
    private DoctorFacade doctorFacade;
    private List<Usuario> list = new ArrayList<>();
    private int id;
    private Usuario u;
    private String usuario;
    private String cedula;
    private String contrasenia;
    private Rol rol;
    private Persona entidad;

    public UsuarioFacade getUsuarioFacade() {
        return usuarioFacade;
    }

    public void setUsuarioFacade(UsuarioFacade usuarioFacade) {
        this.usuarioFacade = usuarioFacade;
    }

    public ColaboradorFacade getColaboradorFacade() {
        return colaboradorFacade;
    }

    public void setColaboradorFacade(ColaboradorFacade colaboradorFacade) {
        this.colaboradorFacade = colaboradorFacade;
    }

    public List<Usuario> getList() {
        return list;
    }

    public void setList(List<Usuario> list) {
        this.list = list;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getU() {
        return u;
    }

    public void setU(Usuario u) {
        this.u = u;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Persona getEntidad() {
        return entidad;
    }

    public void setEntidad(Persona entidad) {
        this.entidad = entidad;
    }

    @PostConstruct
    public void init() {
        list = usuarioFacade.findAll();
    }

    public Colaborador buscarColaborador(String Cedula) {
        return colaboradorFacade.buscaColaborador(Cedula);
    }

    public Doctor buscarDoctor(String Cedula) {
        return doctorFacade.buscaDoctor(Cedula);
    }

    public String add() {
        Persona persona;
        if (rol.equals("DOCTOR")) {
            persona = buscarDoctor(cedula);
        }else{
            persona = buscarColaborador(cedula);
        }
        Usuario usuario = new Usuario(id, this.usuario, contrasenia, persona, rol);
        usuarioFacade.create(usuario);
        return "Cedula";
    }

}
