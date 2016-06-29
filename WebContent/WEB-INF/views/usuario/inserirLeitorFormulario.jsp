<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=ISO-8859-1"/>
	<title>Cadastro Leitor</title>
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
            	<c:if test="${usuario == null}">
                	<li><a href="loginUsuarioFormulario">Logar-se</a></li>
                	<li><a href="inserirLeitorFormulario">Cadastrar-se</a></li>
                </c:if>
                <c:if test="${usuario!=null}">
                	<li><a href="logout">Sair</a></li>
                </c:if>
            </ul>
        </nav>
    </header>
	<section id="corpo-full">
        <h2>Cadastro Leitor</h2>
        <form action="inserirLeitor" method="post">
            <p><label for="cNome">Nome:</label><input type="text" name="nome" id="cNome" size="50" placeholder="Nome Completo"/></p>
            <p><label for="cEmail">Email:</label><input type="text" name="email" id="cEmail" size="50" placeholder="Email"/></p>
            <p><label for="cLogin">Login:</label><input type="text" name="login" id="cLogin" size="30" placeholder="Login"/></p>
            <p><label for="cSenha">Senha:</label><input type="password" name="senha" id="cSenha" size="20" placeholder="Senha"/></p>
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