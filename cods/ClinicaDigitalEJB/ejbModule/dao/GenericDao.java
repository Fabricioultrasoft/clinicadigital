package dao;

import java.util.Collection;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Session Bean implementation class GenericDao
 */
@Stateless
public class GenericDao implements GenericDaoLocal {

	@PersistenceContext
	EntityManager em;
	
    /**
     * Default constructor. 
     */
    public GenericDao() {
        
    }
    
    @Override
    public void create(Object obj){
    	em.persist(obj);
    }
    
    //@Override
    public Object retrieve(Class<?> classe, int id){
    	return em.find(classe, id);
    }
    
    @Override
	public Collection<?> retrieveAll(Class<?> classe){
    	Query query = em.createQuery("SELECT obj FROM "+classe.getSimpleName()+" obj");
    	List<?> lista = query.getResultList();
    	return lista;
    }
    
    @Override
    public void update(Object obj){
    	em.merge(obj);
    }

    @Override
    public void delete(Object obj){
    	em.remove(obj);
    }

}
