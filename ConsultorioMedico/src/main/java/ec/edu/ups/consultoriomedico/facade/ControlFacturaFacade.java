package ec.edu.ups.consultoriomedico.facade;

import ec.edu.ups.consultoriomedico.modelo.ControlFactura;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 *
 * @author Adrian
 */
@Stateless
public class ControlFacturaFacade extends AbstractFacade<ControlFactura> {

    @PersistenceContext()
    private EntityManager em;

    public ControlFacturaFacade() {
        super(ControlFactura.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
