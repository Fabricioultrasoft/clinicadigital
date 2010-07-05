package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entidade.Usuario;

/**
 * Session Bean implementation class UsuarioDao
 */
@Stateless
public class UsuarioDao implements UsuarioDaoLocal {

	@PersistenceContext
	EntityManager em;
	
    /**
     * Default constructor. 
     */
    public UsuarioDao() {
        
    }
    
    @Override
	public Usuario findUsuarioByLogin(String login) {
		String query = "SELECT u FROM Usuario u " + "WHERE u.login like '"+ login +"'";
		Query q = em.createQuery(query);
		return (Usuario) q.getSingleResult();
	}

}
