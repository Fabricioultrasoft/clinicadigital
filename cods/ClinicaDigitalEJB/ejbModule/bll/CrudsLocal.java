package bll;
import java.util.Collection;

import javax.ejb.Local;

@Local
public interface CrudsLocal {

	public void create(Object obj);
	public Object retrieve(Class<?> classe, int id);
	public Collection<?> retrieveAll(Class<?> classe);
	public void update(Object obj);
	public void delete(Object obj);
	
	public void usuarioCreate(Object usuario);
	public void usuarioUpdate(Object usuario);
	
}
