<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alterar Se��o</title>
</head>
<body>
	<form action="alterarSecao" method="post">
		<input type="hidden" name="secId" value="${secao.secId}"/><br />
		T�tulo: <input type="text" name="titulo" value="${secao.titulo}"/><br />
		Descri��o: <input type="text" name="descricao" value="${secao.descricao}"/><br />
		<input type="submit" value="ALTERAR"/>
	</form>

</body>
</html>