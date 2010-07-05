package entidade;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: TipoUsuario
 *
 */
@Entity
@Table(schema="administracao", name="tipo_usuario")
public class TipoUsuario implements Serializable {

	public static final int SU = 0;
	public static final int ADMINISTRADOR = 1;
	public static final int ATENDENTE = 2;
	public static final int PROFISSIONAL = 3;
	   
	@Id
	private int id;
	
	private String descricao;
	
	private static final long serialVersionUID = 1L;

	public TipoUsuario() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
   
}
