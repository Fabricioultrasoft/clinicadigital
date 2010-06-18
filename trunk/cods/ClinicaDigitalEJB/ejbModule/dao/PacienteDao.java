package dao;

import java.util.Collection;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entidade.Paciente;

/**
 * Session Bean implementation class PacienteDao
 */
@Stateless
public class PacienteDao implements PacienteDaoRemote, PacienteDaoLocal {

	@PersistenceContext
	EntityManager em;
	
    /**
     * Default constructor. 
     */
    public PacienteDao() {
        
    }
    
    public void create(Paciente paciente){
    	em.persist(paciente);
    }
    
    public Paciente retrieve(int id){
    	return em.find(Paciente.class, id);
    }
    
	public Collection<Paciente> retrieveAll(){
    	Query query = em.createQuery("SELECT p FROM Paciente p");
    	@SuppressWarnings("unchecked")
    	List<Paciente> lista = query.getResultList();
    	return lista;
    }

}
