package entidade;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Administrador
 *
 */
@Entity
@Table(schema="administracao", name="administrador")
public class Administrador implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_administrador")
	private int id;
	
	@OneToOne(cascade={CascadeType.ALL, CascadeType.MERGE})
	@JoinColumn(name="id_usuario")
	private Usuario usuario;
	
	private static final long serialVersionUID = 1L;

	public Administrador() {
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
   
}
