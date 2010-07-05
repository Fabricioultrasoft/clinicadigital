package dao;
import java.util.Collection;

import javax.ejb.Local;

@Local
public interface GenericDaoLocal {

	public void create(Object obj);
	public Object retrieve(Class<?> classe, int id);
	Collection<?> retrieveAll(Class<?> classe);
	public void update(Object obj);
	public void delete(Object obj);
	
	

}
