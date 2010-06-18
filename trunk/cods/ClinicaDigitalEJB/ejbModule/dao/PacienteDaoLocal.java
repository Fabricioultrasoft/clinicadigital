package dao;
import java.util.Collection;

import javax.ejb.Local;

import entidade.Paciente;

@Local
public interface PacienteDaoLocal {
	public void create(Paciente paciente);
	public Paciente retrieve(int id);
	public Collection<Paciente> retrieveAll();
}
