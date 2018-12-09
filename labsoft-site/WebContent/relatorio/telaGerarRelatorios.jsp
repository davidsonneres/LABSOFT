<jsp:include page="../common/header.jsp" />

	<%@page import="model.Compra"%>
	<%@page import="java.util.List" %>
	<%@page import="java.util.ArrayList" %>

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
	    <h1 class="text-center font-weight-bold m-4">Gerar relatório</h1>
	
		<h2>Período solicitado</h2>
		<div class="border border-black rounded bg-light p-2">
	
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

			  <button type="submit" class="btn btn-info col col-sm-4">Gerar</button>
	
			</form>
		</div>

	  <table class="table table-striped mt-4">
	    <thead class="thead-dark">
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

	  <a href="/labsoft-site/" class="btn btn-primary col col-sm-4">Voltar</a>
	</div>
	    
<jsp:include page="../common/footer.jsp" />