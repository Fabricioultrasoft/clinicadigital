package entidade;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Usuario
 *
 */
@Entity
@Table(schema="administracao", name="usuario")
public class Usuario implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_usuario")
	private int id;
	
	private String login;
	
	private String senha;
	
	@OneToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	private Pessoa pessoa;
	
	@ManyToOne
	@JoinColumn(name="id_tipo_usuario")
	private TipoUsuario tipoUsuario;
	
	@ManyToMany
	@JoinTable(schema="administracao", name="usuario_permissao",
			joinColumns={@JoinColumn(name="id_usuario")},
			inverseJoinColumns={@JoinColumn(name="id_permissao")})
	private Collection<Permissao> permissoes;
	
	private static final long serialVersionUID = 1L;

	
	public Usuario() {
		super();
	}   
	
	
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}   
	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	} 
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public Collection<Permissao> getPermissoes() {
		return permissoes;
	}
	public void setPermissoes(Collection<Permissao> permissoes) {
		this.permissoes = permissoes;
	}


	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}


	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
   
}
