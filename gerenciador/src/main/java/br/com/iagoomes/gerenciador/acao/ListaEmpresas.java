package br.com.iagoomes.gerenciador.acao;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.iagoomes.gerenciador.modelo.Banco;
import br.com.iagoomes.gerenciador.modelo.Empresa;

public class ListaEmpresas implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("Listando empresas");

		List<Empresa> empresas = Banco.getEmpresas();

		request.setAttribute("empresas", empresas);

		return "forward:listaEmpresas.jsp";
	}

}
