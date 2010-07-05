package bll;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dao.UsuarioDao;
import entidade.Usuario;

/**
 * Session Bean implementation class Login
 */
@Stateful
public class Logon implements LogonLocal {

	@PersistenceContext
	EntityManager em;
	
	@EJB
	UsuarioDao usuarioDao;
	
	static Usuario usuarioLogado;
	
    /**
     * Default constructor. 
     */
    public Logon() {
        usuarioLogado = null;
    }

    @Override
    public boolean logon(String login, String senha){
    	Usuario usuario = usuarioDao.findUsuarioByLogin(login);
    	if (usuario.getSenha().compareTo(senha) == 0){
    		usuarioLogado = usuario;
    		return true;
    	}
    	return false;
    }
    
    @Override
    public void logoff(){
    	usuarioLogado = null;
    }
    
    @Override
    public Usuario getUsuarioLogadoParcial(){
    	return usuarioLogado;
    }
    
    @Override
    public Object getUsuarioLogadoTotal(){
    	String nomeClasse = usuarioLogado.getTipoUsuario().getDescricao().toUpperCase().substring(0, 1) +
    						usuarioLogado.getTipoUsuario().getDescricao().toLowerCase().substring(1);
    	String query = "SELECT el FROM "+nomeClasse+" el WHERE el.usuario.id = "+usuarioLogado.getId()+" ";
    	return em.createQuery(query).getSingleResult();
    }
    
}
