<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Inserir Noticia</title>
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
                <li><a href="listarSecao">Seções</a></li>
                <li><a href="listarClassificados">Classificados</a></li>
            </ul>
        </nav>
        <nav id="login">
            <ul>
            	<c:if test="${usuario == null}">
                	<li><a href="loginUsuarioFormulario">Logar-se</a></li>
                	<li><a href="inserirLeitorFormulario">Cadastrar-se</a></li>
                </c:if>
                <c:if test="${usuario!=null}">
                	<li><a href="logout">Sair do Jornal</a></li>
                </c:if>
            </ul>
        </nav>
    </header>
    <section id="corpo-full">
        <h2>Inserir Noticia</h2>
        <form action="inserirNoticia" method="post" enctype="multipart/form-data">
        	<input type="hidden" name="idUsuario" value="${jornalista.usuId}" />
            <p><label for="cTitulo">Titulo: </label><input type="text" name="titulo" id="cTitulo" size="50" placeholder="Titulo da Notícia"/></p>
            <p><label for="cSubtitulo">Subtítulo: </label><input type="text" name="subtitulo" id="cSubtitulo" size="50" placeholder="Subtítulo da Notícia"/></p>
            <p><label for="cTexto">Texto: </label>
            <textarea name="texto" id="cTexto" cols="85" rows="15" placeholder="Escreva aqui a sua Notícia"></textarea></p>
            <p><label for="cSecao">Seção: </label>
                <select name="idSecao" id="cSecao">
                    <c:forEach var="s" items="${secoes}">
                    	<option value="${s.secId}">${s.titulo}</option>
                    </c:forEach>
                </select>
            </p>
            <p><label for="cImagem">Imagem: </label><input type="file" name="image" /></p>
            <input type="submit" value="ENVIAR"/>
        </form>

    </section>

    <footer id="rodape">
        <p>UFC - Universidade Federal do Ceará <br/>
            por Ianka Karúzia</p>
    </footer>
</div>
</body>
</html>