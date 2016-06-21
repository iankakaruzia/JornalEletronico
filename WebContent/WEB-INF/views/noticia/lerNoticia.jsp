<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Noticia</title>
</head>
<body>

		<h4>${noticia.secao.titulo }<br/> ${noticia.dataNoticia } </h4>

       	<div id="titulo">
       		<h3> ${noticia.titulo} </h3>
       		<h4> ${noticia.subtitulo} </h4>
       	<b>Autor da Noticia:</b> ${noticia.usuario.nome } <br>
       
       	<p >
          ${noticia.texto}  
       	</p> 	
       
       	</div>

</body>
</html>