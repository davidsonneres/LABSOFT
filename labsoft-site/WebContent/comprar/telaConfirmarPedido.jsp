<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@page import="model.Compra" %>
	<%@page import="model.Acessorio" %>
	<% Compra compra = (Compra) session.getAttribute("compra");%>

	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
	<script>
		function goBack() {
		    window.history.back();
		}
	</script>
    <title>Confirmar Compra</title>
</head>
<body>


    <div class="container">
      <h1>Confirmar Compra</h1>

      <div class="container w-75">

          <h2>Confirma��o de compra</h2>
          <p>Segurado: <%= compra.getCliente().getNome() %></p>
          <p>Ve�culo: <%= compra.getVeiculo().getModelo() %></p>
          <% if (compra.getTipoValor().equals("FIPE")) {%>
          	<p>FIPE: R$ <%= compra.getVeiculo().getFipe().getValorFIPE() %></p>
          <% } else {%>
          	<p>Determinado: R$ <%= compra.getValorDeterminado() %>
          <% } %>

          <p>Acess�rios:</p>
          <% if (compra.getAcessorios().size() > 0) {%>
          	<% for (Acessorio acessorio : compra.getAcessorios()) { %>
          		<p><%= acessorio.getTipoAcessorio() %>: R$ <%= acessorio.getValorAcessorio() %></p>
          	<% } %>

          <% } else { %>
          <p>Nenhum</p>
          <% } %>
          <br>
          <p>Franquia: <%= compra.getTipoFranquia() %></p>
          <p>Pr�mio L�quido: R$ <%= compra.getValorLiquidoPremios() %></p>
          <p>IOF: R$ <%= compra.getValorIOF() %></p>
          <p>Total: R$ <%= compra.getValorLiquidoPremios() + compra.getValorIOF() %></p>
		
		  <form method="POST">
		  	<input name="confirm" type="text" value="true" hidden></input>
		  	<input type="submit" value="Confirmar Compra" class="btn btn-success"></input>
		  </form>
          <button class="btn btn-primary" onclick="goBack()">Editar dados</button>
          <a href="/labsoft-site" type="button" class="btn btn-danger">Cancelar</a>
        </form>
      </div>
    </div>
</body>
</html>