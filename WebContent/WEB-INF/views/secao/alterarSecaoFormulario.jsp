<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Inserir Seção</title>
    <link rel="stylesheet" type="text/css" href="resources/css/estilos.css"/>
    <link rel="stylesheet" type="text/css" href="resources/css/formularios.css"/>
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
                <c:if test="${usuario!=null}">
                	<li><a href="logout">Sair do Jornal</a></li>
                </c:if>
            </ul>
        </nav>
    </header>
    <section id="corpo-full">
        <h2>Inserir Seção</h2>
        <form action="alterarSecao" method="post">
        	<input type="hidden" name="secId" value="${secao.secId}"/>
            <p><label for="cTitulo">Titulo:</label><input type="text" name="titulo" id="cTitulo" size="50" value="${secao.titulo}"/></p>
            <p><label for="cDescricao">Descrição:</label><input type="text" name="descricao" id="cDescricao" value="${secao.descricao}"/></p>
            <input type="submit" value="ALTERAR"/>
        </form>

    </section>

    <footer id="rodape">
        <p>UFC - Universidade Federal do Ceará <br/>
            por Ianka Karúzia</p>
    </footer>
</div>
</body>
</html>