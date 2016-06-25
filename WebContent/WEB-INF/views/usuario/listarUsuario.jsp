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
                <li>Seções</li>
                <li>Classificados</li>
            </ul>
        </nav>
        <nav id="login">
            <ul>
                <c:if test="${editor!=null}">
                	<li><a href="logout">Sair</a></li>
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