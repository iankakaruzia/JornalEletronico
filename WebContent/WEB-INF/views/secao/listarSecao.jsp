<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=ISO-8859-1"/>
	<title>Listar Seções</title>
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
            	<c:if test="${usuario==null}">
                	<li><a href="loginUsuarioFormulario">Logar-se</a></li>
                	<li><a href="inserirLeitorFormulario">Cadastrar-se</a></li>
                </c:if>
            	<c:if test="${leitor!=null}">
                	<li><a href="logout">Sair do Jornal</a></li>
                </c:if>
                <c:if test="${editor!=null}">
                	<li><a href="logout">Sair do Jornal</a></li>
                </c:if>
            </ul>
        </nav>
    </header>
	<section id="corpo-full">
        <table id="tabela">
			<c:forEach var="secao" items="${secoes}">
				<tr>
					<td>${secao.titulo}</td>
					<td>${secao.descricao}</td>
					<c:if test="${editor!=null}">
						<td><a href="apagarSecao?id=${secao.secId}">Apagar Seção</a></td>
						<td><a href="alterarSecaoFormulario?id=${secao.secId}">Alterar Seção</a></td>
					</c:if>
					<td><a href="listarNoticiaSecao?secId=${secao.secId}">Ler Noticias</a></td>
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