/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.consultoriomedico.facade;

import ec.edu.ups.consultoriomedico.modelo.FacturaInterna;
import ec.edu.ups.consultoriomedico.modelo.HistoriaClinica;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 *
 * @author Adrian
 */
@Stateless
public class HistoriaClinicaFacade extends AbstractFacade<HistoriaClinica> {

    @PersistenceContext()
    private EntityManager em;

    public HistoriaClinicaFacade() {
        super(HistoriaClinica.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}
