package dao;
import java.util.Collection;

import javax.ejb.Local;

import entidade.Permissao;

@Local
public interface PermissaoDaoLocal {

	public Permissao retrieve(int id);
	public Collection<Permissao> retrieveAll();

}
