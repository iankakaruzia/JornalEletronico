<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listar Noticias</title>
</head>
<body>
	
	<ul>
		<c:forEach var="noticia" items="${noticias}">
			 <li>
			  <div id="titulo">
			     <h1> ${noticia.titulo}  </h1>  
                 <h3> ${noticia.subtitulo}</h3> <br>     
                 <a href="lerNoticia?notId=${noticia.notId}"> Ler Noticia Completa</a> <br>
              </div>
			 </li>
		</c:forEach>
	</ul>
	
</body>
</html>