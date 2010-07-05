package dao;
import javax.ejb.Local;

import entidade.Usuario;

@Local
public interface UsuarioDaoLocal {

	Usuario findUsuarioByLogin(String login);

}
