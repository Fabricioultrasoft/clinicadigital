package entidade;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


/**
 * Entity implementation class for Entity: Paciente
 *
 */
@Entity
@Table(schema="administracao", name="paciente")
public class Paciente implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@OneToOne(cascade=CascadeType.PERSIST)
	private Pessoa pessoa;
	
	private static final long serialVersionUID = 1L;

	public Paciente() {
		super();
	}   
	
	public String toString(){
		return this.getId()+"\t"+super.toString();
	}
	
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}
	
   
}
