<jsp:include page="../common/header.jsp" />

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

	<% SimpleDateFormat ft = new SimpleDateFormat("dd.MM.yyyy"); %>
	<% Map<Integer, Apolice> apoliceList = (Map) request.getAttribute("apoliceList"); %>
	
	
	<div class="container">
	<h1 class="text-center font-weight-bold m-4">Lista de Apólices</h1>

	<div class="border border-black rounded bg-light p-2">
	<table class="table table-striped">
		<thead class="thead-dark">
			<tr>
				<th>Id</th>
				<th>Data de início</th>
				<th>Data de fim</th>
				<th>Status</th>
			</tr>
		</thead>
		<tbody>
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
		</tbody>
	</table>
	<div class="col col-sm-4">
		<a href="/labsoft-site" class="btn btn-primary btn-block">Inicial</a>
	</div>
	</div>

	</div>

<jsp:include page="../common/footer.jsp" />