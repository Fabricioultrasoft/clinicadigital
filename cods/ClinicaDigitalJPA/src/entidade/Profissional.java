package entidade;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: Profissional
 *
 */
@Entity
@Table(schema="administracao", name="profissional")
public class Profissional implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_profissional")
	private int id;
	
	@OneToOne(cascade={CascadeType.ALL, CascadeType.MERGE})
	@JoinColumn(name="id_usuario")
	private Usuario usuario;
	
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="id_agenda")
	private Agenda agenda;
	
	@ManyToOne
	@JoinColumn(name="id_tipo_profissional")
	private TipoProfissional tipoProfissional;
	
	@ManyToOne
	@JoinColumn(name="id_especialidade")
	private Especialidade especialidade;
	
	private String conselho;
	
	private String inscricaoConselho;
	
	
	private static final long serialVersionUID = 1L;

	public Profissional() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Agenda getAgenda() {
		return agenda;
	}
	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}
	public Especialidade getEspecialidade() {
		return especialidade;
	}
	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}
	public String getConselho() {
		return conselho;
	}
	public void setConselho(String conselho) {
		this.conselho = conselho;
	}
	public String getInscricaoConselho() {
		return inscricaoConselho;
	}
	public void setInscricaoConselho(String inscricaoConselho) {
		this.inscricaoConselho = inscricaoConselho;
	}
	public TipoProfissional getTipoProfissional() {
		return tipoProfissional;
	}
	public void setTipoProfissional(TipoProfissional tipoProfissional) {
		this.tipoProfissional = tipoProfissional;
	}
   
}
