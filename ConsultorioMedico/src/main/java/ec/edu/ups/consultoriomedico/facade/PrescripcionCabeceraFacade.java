/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.consultoriomedico.facade;

import ec.edu.ups.consultoriomedico.modelo.Consulta;
import jakarta.ejb.Stateless;
import ec.edu.ups.consultoriomedico.modelo.PrescripcionCabecera;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 *
 * @author pcuser
 */

@Stateless
public class PrescripcionCabeceraFacade extends AbstractFacade <PrescripcionCabecera> {
     @PersistenceContext()
    private EntityManager em;
    
    public PrescripcionCabeceraFacade() {
        super(PrescripcionCabecera.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}
