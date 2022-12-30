package br.com.iagoomes.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.iagoomes.gerenciador.acao.AlteraEmpresa;
import br.com.iagoomes.gerenciador.acao.ListaEmpresas;
import br.com.iagoomes.gerenciador.acao.MostraEmpresa;
import br.com.iagoomes.gerenciador.acao.NovaEmpresa;
import br.com.iagoomes.gerenciador.acao.NovaEmpresaForm;
import br.com.iagoomes.gerenciador.acao.RemoveEmpresa;

@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String paramAcao = request.getParameter("acao");
		String uri = null;

		if (paramAcao.equals("listaEmpresas")) {
			ListaEmpresas acao = new ListaEmpresas();
			uri = acao.executa(request, response);

		} else if (paramAcao.equals("removeEmpresa")) {
			RemoveEmpresa acao = new RemoveEmpresa();
			uri = acao.executa(request, response);

		} else if (paramAcao.equals("mostraEmpresa")) {
			MostraEmpresa acao = new MostraEmpresa();
			uri = acao.executa(request, response);

		} else if (paramAcao.equals("alteraEmpresa")) {
			AlteraEmpresa acao = new AlteraEmpresa();
			uri = acao.executa(request, response);

		} else if (paramAcao.equals("novaEmpresa")) {
			NovaEmpresa acao = new NovaEmpresa();
			uri = acao.executa(request, response);

		} else if (paramAcao.equals("novaEmpresaForm")) {
			NovaEmpresaForm acao = new NovaEmpresaForm();
			uri = acao.executa(request, response);

		}

		String tipoEEndereco[] = uri.split(":");

		if (tipoEEndereco[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + tipoEEndereco[1]);
			rd.forward(request, response);
		} else {
			response.sendRedirect(tipoEEndereco[1]);
		}

	}

}
