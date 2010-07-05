package utilitario;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Bean utilitário para operações diversas.
 */
@Stateless
public class Utilitario implements UtilitarioLocal {

	@PersistenceContext
	EntityManager em;
	
    /**
     * Default constructor. 
     */
    public Utilitario() {
        
    }
    
    @Override
    public void iniciarBanco(){
    	
    }

}
