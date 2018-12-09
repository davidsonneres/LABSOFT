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
	<h1>Apólice</h1>
	<p>Id: <%= apolice.getId() %></p>
	<p>Data de Início: <%= ft.format(apolice.getDataInicio()) %></p>
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

<jsp:include page="../common/footer.jsp" />