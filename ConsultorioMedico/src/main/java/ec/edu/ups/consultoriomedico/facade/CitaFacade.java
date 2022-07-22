/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.consultoriomedico.facade;

import ec.edu.ups.consultoriomedico.modelo.Cita;
import ec.edu.ups.consultoriomedico.modelo.Colaborador;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 *
 * @author pcuser
 */
@Stateless
public class CitaFacade  extends AbstractFacade <Cita> {
    @PersistenceContext()
    private EntityManager em;
    
    public CitaFacade() {
        super(Cita.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}
