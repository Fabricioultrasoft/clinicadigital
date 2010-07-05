package bll;
import javax.ejb.Local;

import entidade.Usuario;

@Local
public interface LogonLocal {

	boolean logon(String login, String senha);
	void logoff();
	Usuario getUsuarioLogadoParcial();
	Object getUsuarioLogadoTotal();

}
