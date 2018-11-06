<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="java.text.SimpleDateFormat" %>
<%@page import="model.Apolice" %>
<%@ page import="model.Corretor" %>

<h1>Lista de Corretores</h1>
<% Map<Integer, Corretor> list = (Map) request.getAttribute("list"); %>

<table>
		<tr>
			<th>Id</th>
			<th>Nome</th>
			<th>Telefone</th>
			<th>E-mail</th>
		</tr>
		<% Set<Integer> keySet = list.keySet(); %>
		<% for(Integer id : keySet){%>
		<% Corretor corretor= list.get(id);%>
			<tr>    
				<td><a href="CorretorControle?id=<%= corretor.getIdCorretor() %>"><%= corretor.getIdCorretor() %></a></td>
				<td><%= corretor.getNome() %></td>
				<td><%= corretor.getTelefone() %></td>
				<td><%= corretor.getEmail() %></td>
			</tr>
		<% } %>
	</table>
	<a href="">Inicio</a>
</body>
</html>