<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inserir Not�cia</title>
</head>
<body>
		<h1>Jornal Eletr�nico</h1>
		<br />
		<br />
		<form action="inserirNoticia" method="post">
			<input type="hidden" name="idUsuario" value="${jornalista.usuId}"><br />
			Titulo:<input type="text" name="titulo"/><br />
			Subt�tulo:<input type="text" name="subtitulo"/><br />
			Texto:<textarea name="texto" rows="15" cols="40" placeholder="Escreva aqui a sua Not�cia"></textarea>
			<br/>
			<p>Se��o:</p>
			<select name="idSecao">	
				<c:forEach var="secao" items="${secoes}">
					<option value="${secao.secId}">${secao.titulo}</option>
				</c:forEach>
			</select>               
			<br/>
			<input type="submit" value="ENVIAR">
		</form>
</body>
</html>