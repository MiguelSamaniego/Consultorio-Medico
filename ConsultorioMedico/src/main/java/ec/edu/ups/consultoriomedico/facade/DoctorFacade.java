/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.consultoriomedico.facade;

import ec.edu.ups.consultoriomedico.modelo.Doctor;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 *
 * @author pcuser
 */

@Stateless
public class DoctorFacade extends AbstractFacade <Doctor> { 
        
     
  @PersistenceContext()
    private EntityManager em;
    
    public DoctorFacade() {
        super(Doctor.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}
