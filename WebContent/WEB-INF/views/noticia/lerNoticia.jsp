<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>${noticia.titulo}</title>
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

        <header id="noticia">
            <hgroup>
                <h3>Seção > ${noticia.secao.titulo}</h3>
                <h1>${noticia.titulo}</h1>
                <h1 class="subtitulo">${noticia.subtitulo}</h1>
                <h2>por ${noticia.u.nome}</h2>
                <h3 class="direita">Atualizado em ${noticia.dataNoticia}</h3>
            </hgroup>
        </header>
        <div align="center">
        	<img id="imgNoticia" src="<c:url value="resources/images/${noticia.titulo}.jpg" />"/>
        </div>    
            <p >
                ${noticia.texto}
            </p>
            <c:if test="${jornalista!=null}">
            	<c:if test="${jornalista.usuId == noticia.autId}">
			        <a href="alterarNoticiaFormulario?idNoticia=${noticia.notId}">Alterar Notícia</a><br/>
			        <a href="apagarNoticia?idNoticia=${noticia.notId}">Apagar Notícia</a>
        		</c:if>
			</c:if>
			
		<h2>Comentários</h2>
        <c:if test="${leitor != null}">
        	<form action="inserirComentario" method="post">
        		<input type="hidden" name="idUsuario" value="${leitor.usuId}"/>
        		<input type="hidden" name="idNoticia" value="${noticia.notId}"/>
            	<p><label for="cTexto">Comentário:</label>
            	<textarea name="texto" id="cTexto" cols="30" rows="5" placeholder="Escreva aqui o seu Comentário."></textarea></p>
            	<input type="submit" value="ENVIAR"/>
        	</form>
		</c:if>
		<table id="tabela">
			<c:forEach var="comentario" items="${comentarios}">
				<tr>
					<td>${comentario.u.nome}</td>
					<td>${comentario.texto}</td>
					<c:if test="${comentario.u.usuId == leitor.usuId}">
						<td><a href="apagarComentario?idCom=${comentario.comId}">Apagar Comentário</a></td><br/>
						<td><a href="alterarComentarioFomulario?idCom=${comentario.comId}">Apagar Comentário</a></td>
					</c:if>
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