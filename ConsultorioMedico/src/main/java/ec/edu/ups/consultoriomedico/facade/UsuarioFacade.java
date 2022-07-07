/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.consultoriomedico.facade;

import ec.edu.ups.consultoriomedico.modelo.Usuario;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import java.util.List;

/**
 *
 * 
 * @author edwin
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {

    @PersistenceContext()
    private EntityManager em;

    public UsuarioFacade() {
        super(Usuario.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public Usuario iniciarUsuario(Usuario usuario) {
        Usuario u = null;
        try {
            String consulta = "SELECT u FROM Usuario u WHERE u.usuario = ?1 AND u.contrasenia = ?2"; // de esta forma mando parametros
            Query query = em.createQuery(consulta);
            query.setParameter(1, usuario.getUsuario()); // asigno los parametros al objeto
            query.setParameter(2, usuario.getContrasenia());

            List<Usuario> lista = query.getResultList(); //definimos una lista de tipo usuario ya que es el objeto que se esta mapeando
            System.out.println(usuario.getUsuario());
            System.out.println(usuario.getContrasenia());
            if (!lista.isEmpty()) { //pregunto si la lista es diferente de  vacia
                System.out.println(lista.get(0) + " Hola mundo");
                return usuario = lista.get(0); //retorno el primer elemento de la lista
            }
        } catch (Exception e) {
            System.out.println("Ya valio maso " + e); // caso contrario ya valio y retorna un null
        }
        return u;
    }
}
