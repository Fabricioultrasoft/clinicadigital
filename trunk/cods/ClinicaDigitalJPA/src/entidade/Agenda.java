package entidade;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Agenda
 *
 */
@Entity
@Table(schema="administracao", name="agenda")
public class Agenda implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_agenda")
	private int id;
	
	@OneToOne(mappedBy="agenda")
	private Profissional profissional;
	
	private static final long serialVersionUID = 1L;

	
	
	
	public Agenda() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public Profissional getProfissional() {
		return profissional;
	}
	public void setProfissional(Profissional profissional) {
		this.profissional = profissional;
	}
   
}
