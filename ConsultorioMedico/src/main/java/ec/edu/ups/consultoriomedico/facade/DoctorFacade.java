/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.consultoriomedico.facade;

import ec.edu.ups.consultoriomedico.modelo.Doctor;
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
public class DoctorFacade extends AbstractFacade<Doctor> {

    @PersistenceContext()
    private EntityManager em;

    public DoctorFacade() {
        super(Doctor.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public Doctor buscaDoctor(String cedula) {
        Doctor doctor = null;
        try {
            String consulta = "SELECT d FROM Doctor d WHERE d.cedula = ?1"; // de esta forma mando parametros
            Query query = em.createQuery(consulta);
            query.setParameter(1, cedula); // asigno los parametros al objeto

            List<Doctor> lista = query.getResultList(); //definimos una lista de tipo usuario ya que es el objeto que se esta mapeando
            if (!lista.isEmpty()) { //pregunto si la lista es diferente de  vacia
                return doctor = lista.get(0); //retorno el primer elemento de la lista
            }
        } catch (Exception e) {
            System.out.println("Ya valio maso " + e); // caso contrario ya valio y retorna un null
        }
        return doctor;
    }
}
