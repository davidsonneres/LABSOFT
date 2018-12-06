<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

<title>Insert title here</title>
</head>
<body>
	<%@page import="java.util.ArrayList"%>
	<%@page import="java.sql.Date"%>
	<%@page import="java.util.Set"%>
	<%@page import="java.util.Map"%>
	<%@page import="java.util.List"%>
	<%@page import="java.text.SimpleDateFormat" %>
	<%@page import="model.Apolice" %>
	<% Object isValid = request.getAttribute("isValid"); %>
	<% if(isValid != null && (boolean) isValid) {%>
	<div class="alert alert-success alert-dismissible fade show" role="alert">
	  Alteração de status feita com sucesso
	  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
	    <span aria-hidden="true">&times;</span>
	  </button>
	</div>
	<% } else if (isValid != null && !(boolean) isValid) {%>
		<div class="alert alert-danger alert-dismissible fade show" role="alert">
	  Alteração inválida
	  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
	    <span aria-hidden="true">&times;</span>
	  </button>
	</div>
	<% } %>

	<h1>Lista de Apólices</h1>
	<% SimpleDateFormat ft = new SimpleDateFormat("dd.MM.yyyy"); %>
	<% Map<Integer, Apolice> apoliceList = (Map) request.getAttribute("apoliceList"); %>
	<table>
		<tr>
			<th>Id</th>
			<th>Data de início</th>
			<th>Data de fim</th>
			<th>Status</th>
		</tr>
		<% Set<Integer> keySet = apoliceList.keySet(); %>
		<% for(Integer id : keySet){%>
		<% Apolice apolice = apoliceList.get(id);%>
			<tr>
				<td><a href="ApoliceControle?id=<%= apolice.getId() %>"><%= apolice.getId() %></a></td>
				<td><%= ft.format(apolice.getDataInicio()) %></td>
				<td><%= ft.format(apolice.getDataFim()) %></td>
				<td><%= apolice.getStatus() %></td>
			</tr>
		<% } %>
	</table>
	
	<a href="/labsoft-site">Inicial</a>
	
</body>
</html>