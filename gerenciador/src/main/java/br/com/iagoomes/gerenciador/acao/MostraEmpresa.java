package br.com.iagoomes.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.iagoomes.gerenciador.modelo.Banco;
import br.com.iagoomes.gerenciador.modelo.Empresa;

public class MostraEmpresa {

	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		System.out.println("Mostrando dados da empresa");

		Integer idEmpresa = Integer.parseInt(request.getParameter("id"));

		Empresa empresa = Banco.buscaEmpresaPorId(idEmpresa);

		System.out.println(empresa.getNome());

		request.setAttribute("empresa", empresa);

		return "forward:formAlteraEmpresa.jsp";

	}
}
