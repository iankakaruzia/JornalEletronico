<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
	<title>Login</title>
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
        <h2>Login</h2>
        <form action="loginUsuario" method="post">
            <p><label for="cLogin">Login:</label><input type="text" name="login" id="cLogin" size="26" placeholder="Login"/></p>
            <p><label for="cSenha">Senha:</label><input type="password" name="senha" id="cSenha" size="25" placeholder="Senha"/></p>
            <p><label for="cPapel">Tipo de Conta:</label>
                <select name="papel" id="cPapel">
                    <option value="null">Escolha uma Op�ao</option>
                    <option value="Leitor">Leitor</option>
                    <option value="Jornalista">Jornalista</option>
                    <option value="Editor">Editor</option>
                </select>
            </p>
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