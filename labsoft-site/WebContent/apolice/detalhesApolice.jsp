<jsp:include page="../common/header.jsp" />

	<script type="text/javascript">
		function salvarAlteracao() {
			var novoStatus = $("#sel option:selected").text();
			window.location.href += "?status = " + novoStatus;
							
		}
	</script>

	<%@page import="java.sql.Date"%>
	<%@page import="java.util.List"%>
	<%@page import="java.util.Map"%>
	<%@page import="java.text.SimpleDateFormat" %>
	<%@page import="model.Apolice" %>
	
	<% SimpleDateFormat ft = new SimpleDateFormat("dd.MM.yyyy"); %>
	<% Apolice apolice = (Apolice) request.getAttribute("apolice");%>
	
	<div class="container">
	<h1 class="text-center font-weight-bold m-4">Apólice</h1>
	<div class="border border-black rounded bg-light p-2">

	<p><strong>Id:</strong> <%= apolice.getId() %></p>
	<p><strong>Data de Início:</strong> <%= ft.format(apolice.getDataInicio()) %></p>
	<p><strong>Data de Fim:</strong> <%= ft.format(apolice.getDataFim()) %></p>
	<p><strong>Status atual:</strong> <%= apolice.getStatus() %></p>
	<form action = "" method = "post">
		<label name="id" value = <%= apolice.getId() %> hidden></label>
    	<label for="sel"><strong>Alterar status</strong></label>
        <select name = "status" class="form-control" id="sel" >
        	<option>Ativo</option>
            <option>Cancelado</option>
            <option>Encerrado</option>
        </select>
        <div class="row justify-content-between mt-4">
        	<div class="col-sm-4">
	        	<input type="submit" class="btn btn-success btn-block" value="Salvar">
	        </div>
	        <div class="col-sm-4">
				<a class="btn btn-primary btn-block" href="ApoliceControle">Voltar</a>
			</div>
		</div>
    </form>
    

	</div>
	</div>

<jsp:include page="../common/footer.jsp" />