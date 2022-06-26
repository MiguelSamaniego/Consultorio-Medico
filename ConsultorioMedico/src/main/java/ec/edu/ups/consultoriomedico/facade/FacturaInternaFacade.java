package ec.edu.ups.consultoriomedico.facade;

import ec.edu.ups.consultoriomedico.modelo.FacturaInterna;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 *
 * @author Adrian
 */
@Stateless
public class FacturaInternaFacade extends AbstractFacade<FacturaInterna> {

    @PersistenceContext()
    private EntityManager em;

    public FacturaInternaFacade() {
        super(FacturaInterna.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
