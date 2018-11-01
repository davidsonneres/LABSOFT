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
	<%@page import="model.Apolice" %>

	<h1>Lista de Apólices</h1>
	<% SimpleDateFormat ft = new SimpleDateFormat("dd.MM.yyyy"); %>
	<% List<Apolice> apoliceList = (ArrayList) request.getAttribute("apoliceList"); %>
	<table>
		<tr>
			<th>Id</th>
			<th>Data de início</th>
			<th>Data de fim</th>
			<th>Status</th>
		</tr>
		<% for(int i = 0; i < apoliceList.size(); i++) {%>
		<% Apolice apolice = apoliceList.get(i);%>
			<tr>
				<td><a href="ApoliceControle?id=<%= apolice.getId() %>"><%= apoliceList.get(i).getId() %></a></td>
				<td><%= ft.format(apolice.getDataInicio()) %></td>
				<td><%= ft.format(apolice.getDataFim()) %></td>
				<td><%= apolice.getStatus() %></td>
			</tr>
		<% } %>
	</table>
</body>
</html>