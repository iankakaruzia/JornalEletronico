<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=ISO-8859-1"/>
	<title>Listar Usuarios</title>
	<link href="resources/css/estilos.css" rel="stylesheet">
	<link href="resources/css/formularios.css" rel="stylesheet">
</head>
<body>

<div id="interface">
    <header id="cabecalho">
        <h1>MN News</h1>
        <img id="icone" src="resources/images/noticias0031842016155522.jpg"/>
        <nav id="menu">
            <ul>
                <li>Home</li>
                <li><a href="listarSecao">Seções</a></li>
                <li><a href="listarClassificados">Classificados</a></li>
            </ul>
        </nav>
        <nav id="login">
            <ul>
                <c:if test="${empty leitor or empty jornalista or empty editor}">
                	<li><a href="loginUsuarioFormulario">Logar-se</a></li>
                	<li><a href="inserirLeitorFormulario">Cadastrar-se</a></li>
                </c:if>
                <c:if test="${not empty leitor or not empty jornalista or not empty editor}">
                	<li><a href="logout">Sair do Jornal</a></li>
                </c:if>
            </ul>
        </nav>
    </header>
	<section id="corpo-full">
        <table id="tabela">
			<c:forEach var="usuario" items="${usuarios}">
				<tr>
					<td>${usuario.usuId}</td>
					<td>${usuario.nome}</td>
					<td>${usuario.login}</td>
					<td>${usuario.email}</td>
					<td><img id="imgListaUsuario" src="<c:url value="resources/images/${usuario.login}.jpg" />"/></td>
					<td><a href="apagarUsuario?idUsuario=${usuario.usuId}">Apagar Usuário</a></td>
				</tr>
			</c:forEach>
		</table>

    </section>

    <footer id="rodape">
        <p>UFC - Universidade Federal do Ceará <br/>
            por Ianka Karúzia</p>
    </footer>
</div>
</body>
</html>