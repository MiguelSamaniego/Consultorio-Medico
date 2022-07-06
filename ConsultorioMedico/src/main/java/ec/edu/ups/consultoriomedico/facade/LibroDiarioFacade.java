/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.consultoriomedico.facade;

import ec.edu.ups.consultoriomedico.modelo.LibroDiario;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 *
 * @author Adrian
 */
@Stateless
public class LibroDiarioFacade extends AbstractFacade<LibroDiario> {

    @PersistenceContext()
    private EntityManager em;

    public LibroDiarioFacade() {
        super(LibroDiario.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}
