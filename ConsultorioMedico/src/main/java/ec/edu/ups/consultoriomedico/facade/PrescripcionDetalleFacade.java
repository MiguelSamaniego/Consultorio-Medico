/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.consultoriomedico.facade;

import ec.edu.ups.consultoriomedico.modelo.PrescripcionCabecera;
import ec.edu.ups.consultoriomedico.modelo.PrescripcionDetalle;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 *
 * @author pcuser
 */
@Stateless
public class PrescripcionDetalleFacade extends AbstractFacade<PrescripcionDetalle>{
      @PersistenceContext()
    private EntityManager em;
    
    public PrescripcionDetalleFacade() {
        super(PrescripcionDetalle.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}
