<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Inserir Classificado</title>
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
        <h2>Inserir Classificado</h2>
        <form action="inserirClassificado" method="post" enctype="multipart/form-data">
        	<input type="hidden" name="idLeitor" value="${leitor.usuId}" />
            <p><label for="cTitulo">Titulo: </label><input type="text" name="titulo" id="cTitulo" size="80" placeholder="Titulo do Classificado"/></p>
            <p><label for="cTexto">Texto: </label>
                <textarea name="texto" id="cTexto" cols="45" rows="8" placeholder="Escreva aqui o texto do seu classificado"></textarea></p>
            <p><label for="cTelefone">Telefone: </label><input type="text" name="telefone" id="cTelefone" size="25" placeholder="Telefone para Contato"/></p>
            <p><label for="cPreco">Pre�o: </label><input type="text" name="preco" id="cPreco" size="15" placeholder="Pre�o"/></p>
            <p><label for="cImage">Imagem: </label><input type="file" name="image" /></p>
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