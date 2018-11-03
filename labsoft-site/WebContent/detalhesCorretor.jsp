<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%@page import="java.util.Date"%>
	<%@page import="java.util.List"%>
	<%@page import="java.text.SimpleDateFormat" %>
	<%@page import="model.Corretor" %>
	
	<% Corretor corretor = (Corretor) request.getAttribute("corretor");%>
	<h1>Corretor</h1>
	<p>ID: <%= corretor.getIdCorretor() %></p>
	<p>Nome: <%= corretor.getNome() %></p>
	<p>Telefone: <%= corretor.getTelefone() %></p>
	<p>E mail:<%= corretor.getEmail() %></p>
	
	<a href="CorretorControle">Voltar</a>

</body>
</html>