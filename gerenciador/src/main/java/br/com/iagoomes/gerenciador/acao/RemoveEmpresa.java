package br.com.iagoomes.gerenciador.acao;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.iagoomes.gerenciador.modelo.Banco;

public class RemoveEmpresa implements Acao{
	
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//System.out.println("Removendo empresa");
		
		Integer idEmpresa = Integer.parseInt(request.getParameter("id"));
		Banco.removeEmpresa(idEmpresa);
		
		return "redirect:entrada?acao=ListaEmpresas";
		
	}
}
