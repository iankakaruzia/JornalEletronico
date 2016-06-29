<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=ISO-8859-1"/>
	<title>Listar Notícias</title>
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
                <li><a href="listarSecao">Seções</a></li>
                <li><a href="listarClassificados">Classificados</a></li>
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
        <ul>
			<c:forEach var="noticia" items="${noticias}">
				 <li>
				  <div id="titulo">
				  	<img id="imgLista" src="<c:url value="resources/images/${noticia.titulo}.jpg" />" />
				  	<br/>
				     <h1> ${noticia.titulo}  </h1>  
	                 <h3> ${noticia.subtitulo}</h3> <br>     
	                 <a href="lerNoticia?notId=${noticia.notId}"> Ler Noticia Completa</a> <br/>
	                 <br/>
	                 <br/>
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