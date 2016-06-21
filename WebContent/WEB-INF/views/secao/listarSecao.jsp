<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista Seções</title>
</head>
<body>
	<table border="1">
		<c:forEach var="secao" items="${secoes}">
			<tr>
				<td>${secao.titulo}</td>
				<td>${secao.descricao}</td>
				<td><a href="listarNoticiaSecao?secId=${secao.secId}">Ler Noticias</a></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>