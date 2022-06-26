package ec.edu.ups.consultoriomedico.facade;

import ec.edu.ups.consultoriomedico.modelo.FacturaCompraDetalle;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 *
 * @author Adrian
 */
@Stateless
public class FacturaCompraDetalleFacade extends AbstractFacade<FacturaCompraDetalle> {

    @PersistenceContext()
    private EntityManager em;

    public FacturaCompraDetalleFacade() {
        super(FacturaCompraDetalle.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
