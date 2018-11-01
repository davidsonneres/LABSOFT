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
	<%@page import="java.text.SimpleDateFormat" %>
	<%@page import="model.Cliente" %>

	<h1>Lista de Clientes</h1>
	<% SimpleDateFormat ft = new SimpleDateFormat("dd.MM.yyyy"); %>
	<% List<Cliente> clienteList = (ArrayList) request.getAttribute("listaCliente"); %>
	<table>
		<tr>
			<th>Id</th>
			<th>Nome</th>
			<th>CPF</th>
			<th>Email</th>
			<th>Telefone</th>
			<th>Endereço</th>
		</tr>
		<% for(int i = 0; i < clienteList.size(); i++) {%>
		<% Cliente cliente = clienteList.get(i);%>
			<tr>
				<td><a href="ClienteControle?id=<%= cliente.getId() %>"><%= clienteList.get(i).getId() %></a></td>
				<td><%= cliente.getNome() %></td>
				<td><%= cliente.getCPF() %></td>
				<td><%= cliente.getEmail() %></td>
				<td><%= cliente.getTelefone() %></td>
				<td><%= cliente.getEndereco() %></td>
			</tr>
		<% } %>
	</table>

</body>
</html>