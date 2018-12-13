<jsp:include page="common/header.jsp" />

<style type="text/css"><%@ include file="css/telaInicial.css" %></style>

	<% Object successCompra = request.getAttribute("successCompra");%>
	<% if(successCompra != null && (boolean) successCompra) {%>
	<div class="alert alert-success alert-dismissible fade show" role="alert">
	  Pedido realizado com sucesso
	  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
	    <span aria-hidden="true">&times;</span>
	  </button>
	</div>
	<% request.setAttribute("successCompra", false); %>
	<% } %>
	
	<% String permission = (String) session.getAttribute("permission"); %>
	<% boolean firstLogin = (boolean) session.getAttribute("first-login"); %>
	<% if (firstLogin && permission.equals("cliente")) { %>
		<div class="alert alert-success alert-dismissible fade show" role="alert">
		  Logado como Cliente
		  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
		    <span aria-hidden="true">&times;</span>
		  </button>
		</div>
		<% session.setAttribute("first-login", false); %>
	<% } else if (firstLogin && permission.equals("corretor")) {%>
		<div class="alert alert-success alert-dismissible fade show" role="alert">
		  Logado como Corretor
		  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
		    <span aria-hidden="true">&times;</span>
		  </button>
		</div>
		<% session.setAttribute("first-login", false); %>
	<% } else if (firstLogin && permission.equals("gerente")) { %>
		<div class="alert alert-success alert-dismissible fade show" role="alert">
		  Logado como Gerente
		  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
		    <span aria-hidden="true">&times;</span>
		  </button>
		</div>
	<% } %>
	
	

    <div class="jumbotron jumbotron-fluid" id="jumbo-inicial">
		<div class="container h-100">
			<div class="row h-50 justify-content-center align-items-center">
	 			<div class="display-1 text-white font-weight-bold">Ótimo seguro</div>
			</div>
			<div class="row h-50 justify-content-center align-items-center">
			
				<a href="ControleCompra" class="btn btn-lg btn-light money-icon"><i class="far fa-money-bill-alt money-icon"></i> Compre agora</a>
			</div>
		</div>
    </div>

<jsp:include page="common/footer.jsp" />