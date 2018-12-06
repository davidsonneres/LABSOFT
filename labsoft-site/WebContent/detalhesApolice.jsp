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
<script type="text/javascript">
	function salvarAlteracao() {
		var novoStatus = $("#sel option:selected").text();
		window.location.href += "?status = " + novoStatus;
						
	}
</script>
<body>
	<%@page import="java.sql.Date"%>
	<%@page import="java.util.List"%>
	<%@page import="java.util.Map"%>
	<%@page import="java.text.SimpleDateFormat" %>
	<%@page import="model.Apolice" %>
	
	<% SimpleDateFormat ft = new SimpleDateFormat("dd.MM.yyyy"); %>
	<% Apolice apolice = (Apolice) request.getAttribute("apolice");%>
	<h1>Ap�lice</h1>
	<p>Id: <%= apolice.getId() %></p>
	<p>Data de In�cio: <%= ft.format(apolice.getDataInicio()) %></p>
	<p>Data de Fim: <%= ft.format(apolice.getDataFim()) %></p>
	<p>Status atual: <%= apolice.getStatus() %></p>
	<form action = "" method = "post">
		<label name="id" value = <%= apolice.getId() %> hidden></label>
    	<label for="sel">Alterar status</label>
        <select name = "status" class="form-control" id="sel" >
        	<option>Ativo</option>
            <option>Cancelado</option>
            <option>Encerrado</option>
        </select>
        <input type="submit" value="salvar">
    </form>
	<a href="ApoliceControle">Voltar</a>
</body>
</html>