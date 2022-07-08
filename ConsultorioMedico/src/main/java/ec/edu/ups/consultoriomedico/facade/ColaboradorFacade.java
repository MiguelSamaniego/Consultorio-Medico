/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.consultoriomedico.facade;

import ec.edu.ups.consultoriomedico.modelo.Colaborador;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import java.util.List;

/**
 *
 * @author pcuser
 */
@Stateless
public class ColaboradorFacade extends AbstractFacade <Colaborador> {
    @PersistenceContext()
    private EntityManager em;
    
    public ColaboradorFacade() {
        super(Colaborador.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
     public Colaborador buscaColaborador(String cedula) {
        Colaborador colaborador = null;
        try {
            String consulta = "SELECT c FROM Colaborador c WHERE c.cedula = ?1"; // de esta forma mando parametros
            Query query = em.createQuery(consulta);
            query.setParameter(1, cedula); // asigno los parametros al objeto

            List<Colaborador> lista = query.getResultList(); //definimos una lista de tipo usuario ya que es el objeto que se esta mapeando
            if (!lista.isEmpty()) { //pregunto si la lista es diferente de  vacia
                return colaborador = lista.get(0); //retorno el primer elemento de la lista
            }
        } catch (Exception e) {
            System.out.println("Ya valio maso " + e); // caso contrario ya valio y retorna un null
        }
        return colaborador;
    }
}
