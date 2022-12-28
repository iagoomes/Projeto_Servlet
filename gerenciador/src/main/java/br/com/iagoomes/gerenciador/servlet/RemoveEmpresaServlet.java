package br.com.iagoomes.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.iagoomes.gerenciador.modelo.Banco;


//@WebServlet("/removeEmpresa")
public class RemoveEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		System.out.println("Removendo empresa");
		Integer idEmpresa = Integer.parseInt(request.getParameter("id"));
		Banco.removeEmpresa(idEmpresa);
		
		response.sendRedirect("listaEmpresasServlet");
	}


}
