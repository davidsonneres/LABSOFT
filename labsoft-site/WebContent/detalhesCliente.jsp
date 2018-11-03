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
	<%@page import="model.Cliente" %>
	<% Cliente cliente = (Cliente) request.getAttribute("cliente");%>
	<h1>Cliente</h1>
	<p>Id: <%= cliente.getId() %></p>
	<p>Nome: <%= cliente.getNome() %></p>
	<p>CPF: <%= cliente.getCPF() %></p>
	<p>Email: <%= cliente.getEmail() %></p>
	<p>Telefone: <%= cliente.getTelefone() %></p>
	<p>Endereço: <%= cliente.getEndereco() %></p>
	
	<a href="ClienteControle">Voltar</a>
	
</body>
</html>