package br.com.iagoomes.gerenciador.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {

	private static List<Empresa> lista = new ArrayList<>();
	private static List<Usuario> listaUsuarios = new ArrayList<>();
	private static Integer chaveSequencial = 1;

	static {
		Empresa empresa = new Empresa();
		empresa.setId(Banco.chaveSequencial++);
		empresa.setNome("F1RST");

		Empresa empresa2 = new Empresa();
		empresa2.setId(Banco.chaveSequencial++);
		empresa2.setNome("ALURA");

		lista.add(empresa);
		lista.add(empresa2);

		Usuario u1 = new Usuario();
		u1.setLogin("iago");
		u1.setSenha("12345");

		Usuario u2 = new Usuario();
		u2.setLogin("dio");
		u2.setSenha("6789");

		listaUsuarios.add(u1);
		listaUsuarios.add(u2);

	}

	public void adiciona(Empresa empresa) {
		empresa.setId(Banco.chaveSequencial);
		Banco.lista.add(empresa);
	}

	public static List<Empresa> getEmpresas() {
		return Banco.lista;
	}

	public static void removeEmpresa(Integer id) {
		Iterator<Empresa> it = lista.iterator();

		while (it.hasNext()) {
			Empresa empresa = it.next();

			if (empresa.getId() == id) {
				it.remove();
			}
		}
	}

	public static Empresa buscaEmpresaPorId(Integer id) {

		for (Empresa e : lista) {
			if (e.getId() == id) {
				return e;
			}
		}

		return null;
	}

	public static Usuario existeUsuario(String login, String senha) {
		for (Usuario usuario : listaUsuarios) {
			if (usuario.ehIgual(login, senha)) {
				return usuario;
			}
		}

		return null;
	}

}
