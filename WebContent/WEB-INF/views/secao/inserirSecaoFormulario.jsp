<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Inserir Se��o</title>
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
                <li><a href="/JornalEletronico/">Home</a></li>
                <li><a href="listarSecao">Se��es</a></li>
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
        <h2>Inserir Se��o</h2>
        <form action="inserirSecao" method="post">
            <p><label for="cTitulo">Titulo:</label><input type="text" name="titulo" id="cTitulo" size="50" placeholder="Titulo da Se��o"/></p>
            <p><label for="cDescricao">Descri��o:</label>
            <textarea name="descricao" id="cDescricao" rows="3" cols="30" placeholder="Descri��o da Se��o"></textarea></p>
            <input type="submit" value="ENVIAR"/>
        </form>

    </section>

    <footer id="rodape">
        <p>UFC - Universidade Federal do Cear� <br/>
            por Ianka Kar�zia</p>
    </footer>
</div>
</body>
</html>