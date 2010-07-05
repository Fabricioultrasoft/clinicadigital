package entidade;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Permissão de acesso dos usuários ao sistema.
 *
 */
@Entity
@Table(schema="administracao", name="permissao")
public class Permissao implements Serializable {

	public static final int ADMINISTRADOR = 1;
	public static final int ATENDENTE = 2;
	public static final int PROFISSIONAL = 3;
	
	@Id
	@Column(name="id_permissao")
	private int id;
	
	private String descricao;
	
	private static final long serialVersionUID = 1L;

	public Permissao() {
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
