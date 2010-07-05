package entidade;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: SU
 *
 */
@Entity
@Table(schema="administracao", name="su")
public class Su implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_su")
	private int id;

	@OneToOne(cascade={CascadeType.ALL, CascadeType.MERGE})
	@JoinColumn(name="id_usuario")
	private Usuario usuario;
	
	private String descricao;
	
	private static final long serialVersionUID = 1L;

	public Su() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
   
}
