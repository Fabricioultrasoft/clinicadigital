package bll;
import java.util.Collection;

import javax.ejb.Local;

import entidade.Paciente;

@Local
public interface CrudsLocal {

	public Collection<Paciente> pacienteRetrieveAll();

	public Paciente pacienteRetrieve(int id);

	public void pacienteCreate(Paciente paciente);

}
