package dao;

import java.util.Collection;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entidade.Permissao;

/**
 * Session Bean implementation class PermissaoDao
 */
@Stateless
public class PermissaoDao implements PermissaoDaoLocal {

	@PersistenceContext
	EntityManager em;
	
    /**
     * Default constructor. 
     */
    public PermissaoDao() {
        
    }
    
    
    @Override
    public Permissao retrieve(int id){
    	return em.find(Permissao.class, id);
    }
    
    @Override
	public Collection<Permissao> retrieveAll(){
    	Query query = em.createQuery("SELECT p FROM Permissao p");
    	@SuppressWarnings("unchecked")
    	List<Permissao> lista = query.getResultList();
    	return lista;
    }

}
