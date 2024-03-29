package servlets;

import java.io.IOException;

import java.util.*;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bll.CrudsLocal;
import bll.LogonLocal;

import utilitario.UtilitarioLocal;
import entidade.*;

/**
 * Servlet implementation class MainServlet
 */
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BancoUtils bancoUtils;
       
	@EJB
	CrudsLocal cruds;
	@EJB
	UtilitarioLocal utilitarioLocal;
	
	@EJB
	LogonLocal logon;
	
    public MainServlet() {
        super();
        bancoUtils = new BancoUtils();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.processar(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.processar(request, response);
	}
	
	
	private void processar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (BancoUtils.primeiroAcesso) bancoUtils.initBanco(cruds);
		
		response.getWriter().println("INICIALIZANDO O BANCO DE DADOS E TESTANDO O SISTEMA");
		response.getWriter().println();
		
		response.getWriter().println("Permissoes de Usuario:");
		response.getWriter().println("\t"+((Permissao)cruds.retrieve(Permissao.class, 1)).getDescricao());
		response.getWriter().println("\t"+((Permissao)cruds.retrieve(Permissao.class, 2)).getDescricao());
		response.getWriter().println("\t"+((Permissao)cruds.retrieve(Permissao.class, 3)).getDescricao());
		
		response.getWriter().println("Tipos de Usuario:");
		response.getWriter().println("\t"+((TipoUsuario)cruds.retrieve(TipoUsuario.class, 1)).getDescricao());
		response.getWriter().println("\t"+((TipoUsuario)cruds.retrieve(TipoUsuario.class, 2)).getDescricao());
		response.getWriter().println("\t"+((TipoUsuario)cruds.retrieve(TipoUsuario.class, 3)).getDescricao());
		
		response.getWriter().println("Pacientes da clinica:");
		@SuppressWarnings("unchecked")
		Collection<Paciente> pacientes = (Collection<Paciente>) cruds.retrieveAll(Paciente.class);
		for (Paciente pacienteTemp : pacientes) {
			response.getWriter().println("\t"+pacienteTemp.getPessoa().getNome());
		}
		
		response.getWriter().println("Usuarios do sistema:");
		@SuppressWarnings("unchecked")
		Collection<Usuario> usuarios = (Collection<Usuario>) cruds.retrieveAll(Usuario.class);
		for (Usuario usuarioTemp : usuarios) {
			response.getWriter().println("\t"+usuarioTemp.getPessoa().getNome());
		}
		
		response.getWriter().println("teste de logins");
		logon.logon("usuario01", "senha01");
		Atendente atendente = (Atendente) logon.getUsuarioLogadoTotal();
		response.getWriter().println("\t"+atendente.getClass().getName());
		logon.logoff();
		
		logon.logon("usuario02", "senha02");
		Administrador administrador = (Administrador) logon.getUsuarioLogadoTotal();
		response.getWriter().println("\t"+administrador.getClass().getName());
		logon.logoff();
		
	}
	

}
