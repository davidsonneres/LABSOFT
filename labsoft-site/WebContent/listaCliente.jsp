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
	<%@page import="java.util.List"%>
	<%@page import="java.util.Set"%>
	<%@page import="java.util.Map"%>
		<%@page import="java.util.HashMap"%>
	<%@page import="java.text.SimpleDateFormat" %>
	<%@page import="model.Cliente" %>

	<h1>Lista de Clientes</h1>
	<% SimpleDateFormat ft = new SimpleDateFormat("dd.MM.yyyy"); %>
	<% Map<Integer, Cliente> clienteList = (Map) request.getAttribute("listaCliente"); %>
	<table>
		<tr>
			<th>Id</th>
			<th>Nome</th>
			<th>CPF</th>
			<th>Email</th>
			<th>Telefone</th>
			<th>Endereço</th>
		</tr>
		<% Set<Integer> keySet = clienteList.keySet(); %>
		<% for(Integer id : keySet){%>
		<% Cliente cliente = clienteList.get(id);%>
			<tr>
				<td><a href="ClienteControle?id=<%= cliente.getId() %>"><%= cliente.getId() %></a></td>
				<td><%= cliente.getNome() %></td>
				<td><%= cliente.getCPF() %></td>
				<td><%= cliente.getEmail() %></td>
				<td><%= cliente.getTelefone() %></td>
				<td><%= cliente.getEndereco() %></td>
			</tr>
		<% } %>
	</table>
	<a href="">Inicio</a>

</body>
</html>