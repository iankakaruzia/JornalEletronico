<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>MN News</title>
    <link href="resources/css/estilos.css" rel="stylesheet">
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

    <section id="corpo">
        <h2>Manchetes</h2>	
		<ul>
			<c:forEach var="noticia" items="${news}">
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

    <aside id="lateral">
        <h2>Ações</h2>
        <ul>
        	<c:if test="${editor!=null}">
        		<li><a href="inserirSecaoFormulario">Cadastrar Seção</a></li>
        		<li><a href="listarSecao">Listar Seções</a></li>
        		<li><a href="inserirJornalistaFormulario">Cadastrar Jornalista</a></li>
        		<li><a href="listarUsuario">Listar Usuarios</a></li>
        	</c:if>
			<c:if test="${jornalista!=null}">
        		<li><a href="inserirNoticiaFormulario">Cadastrar Notícia</a></li>
        	</c:if>
        	<c:if test="${usuario==null}">
        		<li>Nenhuma ação a ser exibida.</li>
        	</c:if>
        	<c:if test="${leitor!=null}">
        		<li><a href="inserirClassificadoFormulario">Cadastrar Classificado</a></li>
        	</c:if>
        </ul>
    </aside>

    <footer id="rodape">
        <p>UFC - Universidade Federal do Ceará <br/>
        por Ianka Karúzia</p>
    </footer>
</div>
</body>
</html>