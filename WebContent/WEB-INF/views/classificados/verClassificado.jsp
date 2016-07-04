<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>${classificados.titulo}</title>
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
    <section id="corpo">

        <header id="noticia">
            <hgroup>
                <h1>${classificados.titulo}</h1>
                <h1 class="subtitulo">Preço: R$ ${classificados.preco}</h1>
                <h2>por ${classificados.u.nome}</h2>
            </hgroup>
        </header>
        <div align="center">
        	<img id="imgCla" src="<c:url value="resources/images/${classificados.titulo}.jpg" />"/>
        </div>
            <p>
                ${classificados.texto}
            </p>
		<h4>Melhor oferta até o momento: ${classificados.melhor_oferta}</h4>
		
		<c:if test="${leitor!=null}">
			<c:if test="${leitor.usuId == classificados.autId}">
				<a href="alterarClassificadoFormulario?idCla=${classificados.claId}">Alterar Classificado</a><br />
				<a href="apagarClassificado?idCla=${classificados.claId}">Apagar Classificado</a>
			</c:if>
        </c:if>
    </section>
    
    <aside id="lateral">
    	<h2>Dar Oferta</h2>
    	<c:if test="${leitor != null}">
	    	<form action="inserirOferta">
	    		<input type="hidden" name="idUsuario" value="${leitor.usuId}" />
	    		<input type="hidden" name="idCla" value="${classificados.claId}" />
	    		<p><label for="cValor">Valor da Oferta: </label><input type="text" name="valor" id="cValor" size="15" placeholder="Valor da Oferta"/></p>
	    		<input type="submit" value="Dar Oferta" />
	    	</form>
    	</c:if>
    	<c:if test="${leitor==null}">
    		<h4>Logue-se para dar um lance no classificado.</h4>
    	</c:if>
    	
    </aside>

    <footer id="rodape">
        <p>UFC - Universidade Federal do Ceará <br/>
            por Ianka Karúzia</p>
    </footer>
</div>
</body>
</html>