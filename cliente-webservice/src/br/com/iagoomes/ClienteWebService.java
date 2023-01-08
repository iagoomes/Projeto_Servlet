package br.com.iagoomes;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;

public class ClienteWebService {

	public static void main(String[] args) throws ClientProtocolException, IOException {
		String conteudo = Request.Post("http://localhost:8080/gerenciador/Empresas")
				.addHeader("Accept", "application/json") //ou xml
				.execute()
				.returnContent()
				.asString();

		System.out.println(conteudo);
	}
}
