package entidade;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Especialidade
 *
 */
@Entity
@Table(schema="administracao", name="especialidade")
public class Especialidade implements Serializable {

	public static final int CLINICO_GERAL = 1;
	public static final int CARDIOLOGISTA = 2;
	public static final int NEUROLOGISTA = 3;
	public static final int ENFERMEIRO_GERAL = 4;
	public static final int NUTRICIONISTA_HOSPITALAR = 5;
	public static final int NUTRICIONISTA_ESPORTIVO = 6;
	public static final int FISIOTERAPEUTA_HOSPITALAR = 7;
	public static final int FISIOTERAPEUTA_ESPORTIVO = 8;
	
	@Id
	@Column(name="id_especialidade")
	private int id;
	
	private String descricao;
	
	private static final long serialVersionUID = 1L;

	public Especialidade() {
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
   
}
