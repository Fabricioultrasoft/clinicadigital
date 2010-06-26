package servlets;

import java.io.IOException;

import java.util.*;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bll.CrudsLocal;

import utilitario.UtilitarioLocal;
import entidade.*;

/**
 * Servlet implementation class MainServlet
 */
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	CrudsLocal cruds;
	@EJB
	UtilitarioLocal utilitarioLocal;
	
    public MainServlet() {
        super();
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
		
		new BancoUtils().initBanco(cruds);
		
		
		response.getWriter().println("Pacientes da clinica:");
		Collection<Paciente> pacientes = cruds.pacienteRetrieveAll();
		for (Paciente pacienteTemp : pacientes) {
			response.getWriter().println("\t"+pacienteTemp.getPessoa().getNome());
		}
		
	}
	

}
