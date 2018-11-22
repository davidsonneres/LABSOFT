<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@page import="java.sql.Date"%>
	<%@page import="java.util.List"%>
	<%@page import="java.util.Map"%>
	<%@page import="java.text.SimpleDateFormat" %>
	<%@page import="model.Apolice" %>
	<% SimpleDateFormat ft = new SimpleDateFormat("dd.MM.yyyy"); %>
	<% Apolice apolice = (Apolice) request.getAttribute("apolice");%>
	<h1>Apólice</h1>
	<p>Id: <%= apolice.getId() %></p>
	<p>Data de Início: <%= ft.format(apolice.getDataInicio()) %></p>
	<p>Data de Fim: <%= ft.format(apolice.getDataFim()) %></p>
	<p>Status: <%= apolice.getStatus() %></p>
	
	<a href="ApoliceControle">Voltar</a>
</body>
</html>