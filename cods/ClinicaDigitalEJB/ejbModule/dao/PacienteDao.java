package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
    
  
    

}
