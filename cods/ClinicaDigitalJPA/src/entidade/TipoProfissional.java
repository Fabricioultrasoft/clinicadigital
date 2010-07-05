package entidade;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: TipoProfissional
 *
 */
@Entity
@Table(schema="administracao", name="tipo_profissional")
public class TipoProfissional implements Serializable {

	public static final int MEDICO = 1;
	public static final int ENFERMEIRO = 2;
	public static final int NUTRICIONISTA = 3;
	public static final int FISIOTERAPEUTA = 4;
	
	@Id
	@Column(name="id_tipo_profissional")
	private int id;
	
	private String descricao;
	
	private static final long serialVersionUID = 1L;

	
	
	public TipoProfissional() {
		super();
	}

	public int getId() {
		return id;
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

   
}
