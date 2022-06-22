/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.consultoriomedico.facade;

import ec.edu.ups.consultoriomedico.modelo.Colaborador;
import ec.edu.ups.consultoriomedico.modelo.Doctor;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 *
 * @author pcuser
 */
@Stateless
public class ColaboradorFacade extends AbstractFacade <Colaborador> {
    @PersistenceContext()
    private EntityManager em;
    
    public ColaboradorFacade() {
        super(Colaborador.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}
