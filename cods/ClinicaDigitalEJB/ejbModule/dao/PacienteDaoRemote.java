package dao;
import java.util.Collection;

import javax.ejb.Remote;

import entidade.Paciente;

@Remote
public interface PacienteDaoRemote {
	public void create(Paciente paciente);
	public Paciente retrieve(int id);
	public Collection<Paciente> retrieveAll();
}
