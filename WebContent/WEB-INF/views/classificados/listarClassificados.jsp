<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Listar Classificado</title>
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
                <li><a href="listarSecao">Seções</a></li>
                <li><a href="listarClassificados">Classificados</a></li>
            </ul>
        </nav>
        <nav id="login">
            <ul>
                <li>Logar-se</li>
                <li>Cadastrar-se</li>
                <li>Sair</li>
            </ul>
        </nav>
    </header>
    <section id="corpo-full">
		<ul>
			<c:forEach var="c" items="${classificados}">
			<li>
				<div id="titulo">
			     <h1> ${c.titulo}  </h1>
			     <h3>por R$ ${c.preco}</h3>    
                 <a href="verClassificado?claId=${c.claId}">Visualizar Classificado</a> <br>
              </div>
             </li>
			</c:forEach>
		</ul>
    </section>

    <footer id="rodape">
        <p>UFC - Universidade Federal do Ceará <br/>
            por Ianka Karúzia</p>
    </footer>
</div>
</body>
</html>