package bll;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import dao.*;
import entidade.*;

/**
 * Session Bean implementation class Cruds
 */
@Stateless
public class Cruds implements CrudsLocal {

	@EJB
	PacienteDaoLocal pacienteDao;
	
    /**
     * Default constructor. 
     */
    public Cruds() {
        
    }
    
    @Override
    public void pacienteCreate(Paciente paciente){
    	pacienteDao.create(paciente);
    }
    
    @Override
    public Paciente pacienteRetrieve(int id){
    	return pacienteDao.retrieve(id);
    }
    
    @Override
	public Collection<Paciente> pacienteRetrieveAll(){
    	return pacienteDao.retrieveAll();
    }

}
