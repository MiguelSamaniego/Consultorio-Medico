package ec.edu.ups.consultoriomedico.facade;

import ec.edu.ups.consultoriomedico.modelo.FacturaCompraCabecera;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 *
 * @author Adrian
 */
@Stateless
public class FacturaCompraCabeceraFacade extends AbstractFacade<FacturaCompraCabecera> {

    @PersistenceContext()
    private EntityManager em;

    public FacturaCompraCabeceraFacade() {
        super(FacturaCompraCabecera.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
