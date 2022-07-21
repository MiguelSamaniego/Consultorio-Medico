/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.consultoriomedico.facade;

import ec.edu.ups.consultoriomedico.modelo.Consulta;
import ec.edu.ups.consultoriomedico.modelo.FacturaCompraCabecera;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 *
 * @author pcuser
 */

@Stateless
public class ConsultaFacade  extends AbstractFacade <Consulta>{
    
    @PersistenceContext()
    private EntityManager em;

    public ConsultaFacade() {
        super(Consulta.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}
