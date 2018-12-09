<jsp:include page="../common/header.jsp" />

	<script>
		function goBack() {
		    window.history.back();
		}
		
		function cancelar() {
			window.location.href = "/labsoft-site";
		}
	</script>

	<%@page import="model.Compra" %>
	<%@page import="model.Acessorio" %>
	<% Compra compra = (Compra) session.getAttribute("compra");%>

    <div class="container">
      <h1 class="text-center font-weight-bold m-4">Confirmar Compra</h1>

      <div class="container w-75">
		<div class="border border-black rounded bg-light p-2">
          <p><strong>Segurado:</strong> <%= compra.getCliente().getNome() %></p>
          <p><strong>Veículo:</strong> <%= compra.getVeiculo().getModelo() %></p>
          <% if (compra.getTipoValor().equals("FIPE")) {%>
          	<p><strong>FIPE:</strong> R$ <%= compra.getVeiculo().getFipe().getValorFIPE() %></p>
          <% } else {%>
          	<p><strong>Determinado:</strong> R$ <%= compra.getValorDeterminado() %>
          <% } %>

          <p><strong>Acessórios:</strong></p>
          <% if (compra.getAcessorios().size() > 0) {%>
          	<% for (Acessorio acessorio : compra.getAcessorios()) { %>
          		<p><%= acessorio.getTipoAcessorio() %>: R$ <%= acessorio.getValorAcessorio() %></p>
          	<% } %>

          <% } else { %>
          <p>Nenhum</p>
          <% } %>
          <p><strong>Franquia:</strong> <%= compra.getTipoFranquia() %></p>
          <p><strong>Prêmio Líquido:</strong> R$ <%= compra.getValorLiquidoPremios() %></p>
          <p><strong>IOF:</strong> R$ <%= compra.getValorIOF() %></p>
          <p><strong>Total:</strong> R$ <%= compra.getValorLiquidoPremios() + compra.getValorIOF() %></p>
		
		  <form method="POST">
		  	<input name="confirm" type="text" value="true" hidden></input>
		  	<input type="submit" value="Confirmar Compra" class="btn btn-success"></input>
			  <input type="button" class="btn btn-primary" onclick="goBack()" value="Editar dados"></input>
	          <input type="button" class="btn btn-danger" onclick="cancelar()" value="Cancelar"></input>
		  </form>
          
      </div>
      </div>
    </div>

<jsp:include page="../common/footer.jsp" />