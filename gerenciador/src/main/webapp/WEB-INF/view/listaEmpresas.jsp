<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="java.util.List,br.com.iagoomes.gerenciador.modelo.Empresa"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Java Standard taglib</title>
</head>
<body>
	
	<h2>Usuario logado: ${usuarioLogado.login}</h2>

	<c:if test="${not empty empresa}">
		Empresa ${empresa} cadastrada com sucesso!
	</c:if>
	

	<c:if test="${not empty empresas}">
		<h3>Lista de Empresas:</h3>

		<ul>
			<c:forEach items="${empresas}" var="empresa">
			
				<li>${empresa.nome} - <fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/>
				<a href="entrada?acao=MostraEmpresa&id=${empresa.id}">editar</a>
				<a href="entrada?acao=RemoveEmpresa&id=${empresa.id}">remover</a>
				</li>
			</c:forEach>
		</ul>
	</c:if>

	<c:if test="${empty empresas}">
			Nenhuma empresa cadastrada!
	</c:if>
</body>
</html>