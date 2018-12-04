<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@page import="model.Compra"%>
	<%@page import="java.util.List" %>
	<%@page import="java.util.ArrayList" %>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

<title>Gerar Relatórios</title></head>

<body>
	<% Object isValid = request.getAttribute("isValid"); %>
	<% List<Compra> compraList = new ArrayList<>(); %>
	<% if (isValid != null) { %>
		<% if ((boolean) isValid) { %>
			<div class="alert alert-success alert-dismissible fade show" role="alert">
		  		Relatorio gerado com sucesso
		  		<button type="button" class="close" data-dismiss="alert" aria-label="Close">
		    		<span aria-hidden="true">&times;</span>
		  		</button>
			</div>
			
			<% compraList = (List<Compra>) request.getAttribute("compraList"); %>
		<% } else { %>
			<div class="alert alert-danger alert-dismissible fade show" role="alert">
		  		Período inválido
		  		<button type="button" class="close" data-dismiss="alert" aria-label="Close">
		    		<span aria-hidden="true">&times;</span>
		  		</button>
			</div>
		<% } %>
	<% } %>
	<div class="container">
		<form method="post">
		  <div class="row">
		    <div class="col">
		      <label for="input_data_inicial">Data Inicial</label>
		      <input name="data-inicio" type="date" class="form-control">
		    </div>
		    <div class="col">
		      <label for="input_data_final">Data Final</label>
		      <input name="data-fim" type="date" class="form-control">
		    </div>
		  </div>
		  <br>
		  <button type="submit" class="btn btn-primary">Gerar</button>
		</form>
	</div>
	<div class="container">
	  <table class="table table-striped">
	    <thead>
	      <tr>
	        <th scope="col">#Apolice</th>
	        <th scope="col">Status</th>
	        <th scope="col">Data Inicio</th>
	        <th scope="col">Data Fim</th>
	        <th scope="col">Veículo</th>
	        <th scope="col">Assegurado</th>
	        <th scope="col">Corretor</th>
	        <th scole="col">Valor Total</th>
	      </tr>
	    </thead>
	    <tbody>
	    	<% for (Compra compra : compraList) { %>
	    		<tr>
	    			<td><%= compra.getApolice().getId() %></td>
	    			<td><%= compra.getApolice().getStatus() %></td>
	    			<td><%= compra.getApolice().getDataInicio() %></td>
	    			<td><%= compra.getApolice().getDataFim() %></td>
	    			<td><%= compra.getVeiculo().getModelo() %></td>
	    			<td><%= compra.getCliente().getNome() %></td>
	    			<td><%= compra.getCorretor().getNome() %></td>
	    			<td><%= compra.getValorLiquidoPremios() + compra.getValorIOF() %></td>
	    		</tr>
	    	<% } %>
	    </tbody>
	  </table>
	  <div class="row">
	     <a href="/labsoft-site/" class="btn btn-primary">Voltar</a>
	  </div>
	</div>
</body>
</html>