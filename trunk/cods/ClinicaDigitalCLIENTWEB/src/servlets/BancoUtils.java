package servlets;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;

import bll.CrudsLocal;

import entidade.*;

/**
 * Este utilitário está na camada web para que não seja necessário reiniciar o server
 * em caso de alterações na configuração.
 * Espera-se que seja utilizado ao iniciar o server.
 * 
 * @author Daniel
 */
public class BancoUtils {
	
	/** Checar se é o primeiro acesso, pois os inits só podem rodar uma vez. */
	public static boolean primeiroAcesso = true;
	
	public BancoUtils(){
		
	}
	
	public void initBanco(CrudsLocal cruds){
		primeiroAcesso = false;
		initPermissoes(cruds);
		initTipoUsuario(cruds);
		initTipoProfissional(cruds);
		initEspecialidades(cruds);
		initPacientes(cruds);
		initUsuarios(cruds);
	}
	
	
	private void initPermissoes(CrudsLocal cruds) {
		Permissao permissao1 = new Permissao();
		permissao1.setId(1);
		permissao1.setDescricao("ADMINISTRADOR");
		cruds.create(permissao1);
		
		Permissao permissao2 = new Permissao();
		permissao2.setId(2);
		permissao2.setDescricao("ATENDENTE");
		cruds.create(permissao2);
		
		Permissao permissao3 = new Permissao();
		permissao3.setId(3);
		permissao3.setDescricao("PROFISSIONAL");
		cruds.create(permissao3);
	}
	
	private void initTipoUsuario(CrudsLocal cruds) {
		TipoUsuario tipoUsuario0 = new TipoUsuario();
		tipoUsuario0.setId(0);
		tipoUsuario0.setDescricao("SU");
		cruds.create(tipoUsuario0);
		
		TipoUsuario tipoUsuario1 = new TipoUsuario();
		tipoUsuario1.setId(1);
		tipoUsuario1.setDescricao("ADMINISTRADOR");
		cruds.create(tipoUsuario1);
		
		TipoUsuario tipoUsuario2 = new TipoUsuario();
		tipoUsuario2.setId(2);
		tipoUsuario2.setDescricao("ATENDENTE");
		cruds.create(tipoUsuario2);
		
		TipoUsuario tipoUsuario3 = new TipoUsuario();
		tipoUsuario3.setId(3);
		tipoUsuario3.setDescricao("PROFISSIONAL");
		cruds.create(tipoUsuario3);
	}
	
	private void initTipoProfissional(CrudsLocal cruds){
		TipoProfissional tipoProfissional01 = new TipoProfissional();
		tipoProfissional01.setId(1);
		tipoProfissional01.setDescricao("MEDICO");
		cruds.create(tipoProfissional01);
		
		TipoProfissional tipoProfissional02 = new TipoProfissional();
		tipoProfissional02.setId(2);
		tipoProfissional02.setDescricao("ENFERMEIRO");
		cruds.create(tipoProfissional02);
		
		TipoProfissional tipoProfissional03 = new TipoProfissional();
		tipoProfissional03.setId(3);
		tipoProfissional03.setDescricao("NUTRICIONISTA");
		cruds.create(tipoProfissional03);
		
		TipoProfissional tipoProfissional04 = new TipoProfissional();
		tipoProfissional04.setId(4);
		tipoProfissional04.setDescricao("FISIOTERAPEUTA");
		cruds.create(tipoProfissional04);
	}
	
	private void initEspecialidades(CrudsLocal cruds) {
		Especialidade especialidade1 = new Especialidade();
		especialidade1.setId(1);
		especialidade1.setDescricao("CLINICO_GERAL");
		cruds.create(especialidade1);
		
		Especialidade especialidade2 = new Especialidade();
		especialidade2.setId(2);
		especialidade2.setDescricao("CARDIOLOGISTA");
		cruds.create(especialidade2);
		
		Especialidade especialidade3 = new Especialidade();
		especialidade3.setId(3);
		especialidade3.setDescricao("NEUROLOGISTA");
		cruds.create(especialidade3);
		
		Especialidade especialidade4 = new Especialidade();
		especialidade4.setId(4);
		especialidade4.setDescricao("ENFERMEIRO_GERAL");
		cruds.create(especialidade4);
		
		Especialidade especialidade5 = new Especialidade();
		especialidade5.setId(5);
		especialidade5.setDescricao("NUTRICIONISTA_HOSPITALAR");
		cruds.create(especialidade5);
		
		Especialidade especialidade6 = new Especialidade();
		especialidade6.setId(6);
		especialidade6.setDescricao("NUTRICIONISTA_ESPORTIVO");
		cruds.create(especialidade6);
		
		Especialidade especialidade7 = new Especialidade();
		especialidade7.setId(7);
		especialidade7.setDescricao("FISIOTERAPEUTA_HOSPITALAR");
		cruds.create(especialidade7);
		
		Especialidade especialidade8 = new Especialidade();
		especialidade8.setId(8);
		especialidade8.setDescricao("FISIOTERAPEUTA_ESPORTIVO");
		cruds.create(especialidade8);
	}
	
	public void initPacientes(CrudsLocal cruds){
		GregorianCalendar gc;
		
		Pessoa pessoa01 = new Pessoa();
    	pessoa01.setNome("Paciente1 da Silva Sauro");
    	pessoa01.setEndereco("Rua 1");
    	pessoa01.setTelefone1("1111-1111");
    	pessoa01.setEmail("paciente1@gmail.com");
    	pessoa01.setSexo('m');
    	gc = new GregorianCalendar(1971, 0, 1);
    	pessoa01.setDataNascimento(new Date(gc.getTimeInMillis()));
    	Paciente paciente01 = new Paciente();
    	paciente01.setPessoa(pessoa01);
    	cruds.create(paciente01);
    	
    	Pessoa pessoa02 = new Pessoa();
    	pessoa02.setNome("Paciente2 da Silva Sauro");
    	pessoa02.setEndereco("Uma rua ai qualquer");
    	pessoa02.setTelefone1("3222-2222");
    	pessoa02.setEmail("paciente2@gmail.com");
    	pessoa02.setSexo('m');
    	gc = new GregorianCalendar(1972, 0, 2);
    	pessoa02.setDataNascimento(new Date(gc.getTimeInMillis()));
    	Paciente paciente02 = new Paciente();
    	paciente02.setPessoa(pessoa02);
    	cruds.create(paciente02);
	}
	
	@SuppressWarnings("unused")
	private void initUsuarios(CrudsLocal cruds) {
		GregorianCalendar gc;
		Permissao permissaoAdministrador = (Permissao) cruds.retrieve(Permissao.class, Permissao.ADMINISTRADOR);
		Permissao permissaoAtendente = (Permissao) cruds.retrieve(Permissao.class, Permissao.ATENDENTE);
		Permissao permissaoProfissional = (Permissao) cruds.retrieve(Permissao.class, Permissao.PROFISSIONAL);
		TipoUsuario tipoUsuarioAdministrador = (TipoUsuario) cruds.retrieve(TipoUsuario.class, TipoUsuario.ADMINISTRADOR);
		TipoUsuario tipoUsuarioAtendente = (TipoUsuario) cruds.retrieve(TipoUsuario.class, TipoUsuario.ATENDENTE);
		TipoUsuario tipoUsuarioProfissional = (TipoUsuario) cruds.retrieve(TipoUsuario.class, TipoUsuario.PROFISSIONAL);
		TipoProfissional tipoProfissionalMedico = (TipoProfissional) cruds.retrieve(TipoProfissional.class, TipoProfissional.MEDICO);
		TipoProfissional tipoProfissionalEnfermeiro = (TipoProfissional) cruds.retrieve(TipoProfissional.class, TipoProfissional.ENFERMEIRO);
		TipoProfissional tipoProfissionalNutricionista = (TipoProfissional) cruds.retrieve(TipoProfissional.class, TipoProfissional.NUTRICIONISTA);
		TipoProfissional tipoProfissionalFisioterapeuta = (TipoProfissional) cruds.retrieve(TipoProfissional.class, TipoProfissional.FISIOTERAPEUTA);
		Especialidade especialidadeClinicoGeral = (Especialidade) cruds.retrieve(Especialidade.class, Especialidade.CLINICO_GERAL);
		Especialidade especialidadeCardiologista = (Especialidade) cruds.retrieve(Especialidade.class, Especialidade.CARDIOLOGISTA);
		Especialidade especialidadeNeurologista = (Especialidade) cruds.retrieve(Especialidade.class, Especialidade.NEUROLOGISTA);
		Especialidade especialidadeEnfermeiroGeral = (Especialidade) cruds.retrieve(Especialidade.class, Especialidade.ENFERMEIRO_GERAL);
		Especialidade especialidadeNutricionistaHospitalar = (Especialidade) cruds.retrieve(Especialidade.class, Especialidade.NUTRICIONISTA_HOSPITALAR);
		Especialidade especialidadeNutricionistaEsportivo = (Especialidade) cruds.retrieve(Especialidade.class, Especialidade.NUTRICIONISTA_ESPORTIVO);
		Especialidade especialidadeFisioterapeutaHospitalar = (Especialidade) cruds.retrieve(Especialidade.class, Especialidade.FISIOTERAPEUTA_HOSPITALAR);
		Especialidade especialidadeFisioterapeutaEsportivo = (Especialidade) cruds.retrieve(Especialidade.class, Especialidade.FISIOTERAPEUTA_ESPORTIVO);
		
		
		Pessoa pessoa01 = new Pessoa();
    	pessoa01.setNome("Atendente1 da Silva Sauro");
    	pessoa01.setEndereco("Via 1");
    	pessoa01.setTelefone1("3333-1111");
    	pessoa01.setEmail("atendente1@gmail.com");
    	pessoa01.setSexo('m');
    	gc = new GregorianCalendar(1971, 0, 1);
    	pessoa01.setDataNascimento(new Date(gc.getTimeInMillis()));
    	Collection<Permissao> permissoes01 = new ArrayList<Permissao>();
    	permissoes01.add(permissaoAtendente);
    	Usuario usuario01 = new Usuario();
    	usuario01.setLogin("usuario01");
    	usuario01.setSenha("senha01");
    	usuario01.setPessoa(pessoa01);
    	usuario01.setTipoUsuario(tipoUsuarioAtendente);
    	usuario01.setPermissoes(permissoes01);
    	Atendente atendente01 = new Atendente();
    	atendente01.setUsuario(usuario01);
    	
    	Pessoa pessoa02 = new Pessoa();
    	pessoa02.setNome("Administrador1 da Silva Sauro");
    	pessoa02.setEndereco("Avenida 1");
    	pessoa02.setTelefone1("4444-1111");
    	pessoa02.setEmail("admnistrador1@gmail.com");
    	pessoa02.setSexo('m');
    	gc = new GregorianCalendar(1971, 0, 1);
    	pessoa02.setDataNascimento(new Date(gc.getTimeInMillis()));
    	Collection<Permissao> permissoes02 = new ArrayList<Permissao>();
    	permissoes02.add(permissaoAdministrador);
    	Usuario usuario02 = new Usuario();
    	usuario02.setLogin("usuario02");
    	usuario02.setSenha("senha02");
    	usuario02.setPessoa(pessoa02);
    	usuario02.setTipoUsuario(tipoUsuarioAdministrador);
    	usuario02.setPermissoes(permissoes02);
    	Administrador administrador01 = new Administrador();
    	administrador01.setUsuario(usuario02);
    	
    	Pessoa pessoa03 = new Pessoa();
    	pessoa03.setNome("Profissional1 da Silva Sauro");
    	pessoa03.setEndereco("Avenida 1");
    	pessoa03.setTelefone1("5555-1111");
    	pessoa03.setEmail("profissional1@gmail.com");
    	pessoa03.setSexo('m');
    	gc = new GregorianCalendar(1971, 0, 1);
    	pessoa03.setDataNascimento(new Date(gc.getTimeInMillis()));
    	Collection<Permissao> permissoes03 = new ArrayList<Permissao>();
    	permissoes03.add(permissaoProfissional);
    	Usuario usuario03 = new Usuario();
    	usuario03.setLogin("usuario03");
    	usuario03.setSenha("senha03");
    	usuario03.setPessoa(pessoa03);
    	usuario03.setTipoUsuario(tipoUsuarioProfissional);
    	usuario03.setPermissoes(permissoes03);
    	Agenda agenda01 = new Agenda(); //TODO inserir atributos de agenda
    	Profissional profissional01 = new Profissional();
    	profissional01.setAgenda(agenda01);
    	profissional01.setTipoProfissional(tipoProfissionalMedico);
    	profissional01.setEspecialidade(especialidadeClinicoGeral);
    	profissional01.setUsuario(usuario03);
    	profissional01.setConselho("CRM");
    	profissional01.setInscricaoConselho("CRM-111111");
    	
    	Pessoa pessoa04 = new Pessoa();
    	pessoa04.setNome("SU");
    	pessoa04.setEndereco("-");
    	pessoa04.setTelefone1("-");
    	pessoa04.setEmail("su@gmail.com");
    	pessoa04.setSexo('m');
    	gc = new GregorianCalendar(1971, 0, 1);
    	pessoa04.setDataNascimento(new Date(gc.getTimeInMillis()));
    	Collection<Permissao> permissoes04 = new ArrayList<Permissao>();
    	permissoes04.add(permissaoAdministrador);
    	permissoes04.add(permissaoProfissional);
    	Usuario usuario04 = new Usuario();
    	usuario04.setLogin("su");
    	usuario04.setSenha("su");
    	usuario04.setPessoa(pessoa04);
    	usuario04.setTipoUsuario(tipoUsuarioAdministrador);
    	usuario04.setPermissoes(permissoes04);
    	Su su01 = new Su();
    	su01.setDescricao("Administrador do Sistema");
    	su01.setUsuario(usuario04);
    	
    	
    	cruds.usuarioCreate(atendente01);
    	cruds.usuarioCreate(administrador01);
    	cruds.usuarioCreate(profissional01);
    	cruds.usuarioCreate(su01);
		
	}
}

