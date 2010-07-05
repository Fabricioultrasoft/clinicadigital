package bll;

import java.util.Collection;
import java.util.Iterator;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import dao.GenericDaoLocal;
import entidade.Administrador;
import entidade.Permissao;

/**
 * Session Bean implementation class Cruds
 */
@Stateless
public class Cruds implements CrudsLocal {
	
	@EJB
	GenericDaoLocal genericDao;
	
    /**
     * Default constructor. 
     */
    public Cruds() {
        
    }
    
    
    @Override
    public void create(Object obj){
    	genericDao.create(obj);
    }
    
    @Override
    public Object retrieve(Class<?> classe, int id){
    	return genericDao.retrieve(classe, id);
    }
    
    @Override
    public Collection<?> retrieveAll(Class<?> classe){
    	return genericDao.retrieveAll(classe);
    }
    
    @Override
    public void update(Object obj){
    	genericDao.update(obj);
    }

    @Override
    public void delete(Object obj){
    	genericDao.delete(obj);
    }
    
    
    @Override
    public void usuarioCreate(Object usuario){
    	genericDao.create(addPermissao(usuario));
    }
    
    @Override
    public void usuarioUpdate(Object usuario){
    	genericDao.update(addPermissao(usuario));
    }
    
    private Object addPermissao(Object usuario){
    	if (usuario instanceof Administrador){
    		Administrador administrador = (Administrador) usuario;
    		Collection<Permissao> permissoes = administrador.getUsuario().getPermissoes();
    		for(Iterator<Permissao> iter = permissoes.iterator(); iter.hasNext(); ){
    			if (iter.next().getId() == Permissao.ADMINISTRADOR){
    				permissoes.add((Permissao) genericDao.retrieve(Permissao.class, Permissao.ATENDENTE));
    				break;
    			}
    		}
    		administrador.getUsuario().setPermissoes(permissoes);
    		return administrador;
    	}
    	return usuario;
    }
    

}
