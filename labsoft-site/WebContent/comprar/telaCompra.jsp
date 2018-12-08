<jsp:include page="../common/header.jsp" />

	<%@page import="model.Cliente"%>
	<%@page import="model.Veiculo" %>
	<% Cliente cliente = (Cliente) request.getAttribute("cliente");%>
	<% Veiculo veiculo = (Veiculo) request.getAttribute("veiculo");%>
	<% Boolean firstAccess = (Boolean) request.getAttribute("firstAccess"); %>
	<% Boolean firstVehicle = (Boolean) request.getAttribute("firstVehicle"); %>
	<script>
		function insertCamposValorDeterminado() {
			container = $("#valor-determinado");
			container.empty();
			if ($("#input-tipo-valor option:selected").text() == "FIPE") {
				$("<input type='label' name='valor-determinado' id='valor-determinado-valor' disabled required='required' value=" + <%= veiculo != null ? veiculo.getFipe().getValorFIPE() : "0.00" %> + ">").appendTo(container);
			} else {
				$("<input type='number' name='valor-determinado' id='valor-determinado-valor' required='required' placeholder='Digite o valor'></input>").appendTo(container);
			}
		};
	
    	function checkCPF() {
    		cpf = $("#input-cpf").val();
    		window.location.href = "ControleCompra?type=cpf&cpf=" + cpf;
    	}
    	
    	function checkRenavam() {
    		renavam = $("#input-renavam").val();
    		url = window.location.href;
    		renavamIndex = url.indexOf("&renavam=");
    		questionIndex = url.indexOf("?");
    		append = "";
    		if (questionIndex < 0) {
    			append = "?";
    		} else {
    			append = "&";
    		}
    		if (renavamIndex < 0) {
    			window.location.href += append + "renavam=" + renavam;
    		} else {
    			window.location.href = url.substring(0, renavamIndex) + append + "renavam=" + renavam;
    		}	
    	}
    </script>



    <div class="container">
    
    	<% if (firstAccess != null && cliente == null) { %>
		<div class="alert alert-danger alert-dismissible fade show" role="alert">
		  CPF Inválido
		  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
		    <span aria-hidden="true">&times;</span>
		  </button>
		</div>
		<% } %>
		<% if (firstVehicle != null & veiculo == null){%>
		<div class="alert alert-danger alert-dismissible fade show" role="alert">
		  RENAVAM Inválido
		  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
		    <span aria-hidden="true">&times;</span>
		  </button>
		</div>
		<% } %>
    
      <h1 class="text-center font-weight-bold m-4">Compre seguro</h1>

	<div class="container w-75">
	  <form method="POST">
	  
	    <h2>Dados do segurado</h2>
	    
	    <div class="border border-black rounded bg-light p-2">
	    <div class="form-row">
	      <div class="form-group col-sm-5">
	        <label for="input-cpf">CPF</label>
	        <input type="text" name="cpf" class="form-control" id="input-cpf" required="required" placeholder="Digite seu CPF"
	        		value=<%= cliente != null ? cliente.getCPF() : "" %>>
	         </div>
	
	<div class="form-group col-sm-3 my-auto mx-auto">
		<input class="btn btn-info mt-3" type="button" value="Verificar" id="button-verificar" onClick="checkCPF()">
	</div>
	
	         <div class="form-group col-sm-4">
	           <label for="input-sexo">Sexo</label>
	           <select class="form-control" name="sexo" id="input-sexo" <%= cliente != null ? "disabled" : "" %>>
	    <option <%= cliente != null && cliente.getSexo().equals("Masculino") ? "selected='selected'" : "" %>>Masculino</option>
	    <option <%= cliente != null && cliente.getSexo().equals("Feminino") ? "selected='selected'" : "" %>>Feminino</option>
	    <option <%= cliente != null && cliente.getSexo().equals("Outros") ? "selected='selected'" : "" %>>Outros</option>
	    </select>
	  </div>
	</div>
	
	<div class="form-group">
	  <label for="input-nome-segurado">Nome Completo</label>
	  <input type="text" class="form-control" id="input-nome-segurado" required="required" placeholder="Nome Completo"
	  		value='<%= cliente != null ? cliente.getNome() : "" %>' <%= cliente != null ? "disabled" : "" %>>
	</div>
	
	<div class="form-row">
	  <div class="form-group col-sm-8">
	    <label for="input-nacionalidade">Nacionalidade</label>
	    <input type="text" class="form-control" id="input-nacionalidade" required="required" placeholder="Nacionalidade"
	    		 value=<%= cliente != null ? cliente.getNacionalidade() : "" %> <%= cliente != null ? "disabled" : "" %>>
	</div>
	
	<div class="form-group col-sm-4">
	  <label for="input-data-nascimento">Data de nascimento</label>
	  <input type="date" class="form-control" id="input-data-nascimento" required="required" placeholder="Data de nascimento"
	  		 value=<%= cliente != null ? cliente.getDataNascimento().toString() : "" %> <%= cliente != null ? "disabled" : "" %>>
	  </div>
	</div>
	
	<div class="form-row">
	  <div class="form-group col-sm-8">
	    <label for="input-email">Email</label>
	    <input type="text" class="form-control" id="input-email" required="required" placeholder="Email"
	    		value='<%= cliente != null ? cliente.getEmail() : "" %>' <%= cliente != null ? "disabled" : "" %>>
	</div>
	
	<div class="form-group col-sm-4">
	  <label for="input-telefone">Telefone</label>
	  <input type="text" class="form-control" id="input-telefone" required="required" placeholder="Telefone"
	  		value='<%= cliente != null ? cliente.getTelefone() : "" %>' <%= cliente != null ? "disabled" : "" %>>
	  </div>
	</div>
	
	<div class="form-group">
	   <label for="input-cnh">CNH</label>
	   <input type="text" class="form-control" id="input-cnh" required="required" placeholder="CNH"
	   		value=<%= cliente != null ? cliente.getCNH() : "" %> <%= cliente != null ? "disabled" : "" %>>
	</div>
	
	<div class="form-group">
	  <label for="input-endereço">Endereço</label>
	  <input type="text" class="form-control" id="input-endereço" required="required" placeholder="Endereço"
	  		value='<%= cliente != null ? cliente.getEndereco() : "" %>' <%= cliente != null ? "disabled" : "" %>>
	        </div>
	</div>

          <h2 class="mt-4">Dados do veículo</h2>
          
          	    <div class="border border-black rounded bg-light p-2">
          <div class="form-row">
            <div class="form-group col-sm-9">
              <label for="input-renavam">RENAVAM</label>
              <input type="text" name="renavam" class="form-control" id="input-renavam" required="required" placeholder="Digite o RENAVAM do veículo"
              		value=<%= veiculo != null ? veiculo.getRenavam() : "" %>>
            </div>

			<div class="form-group col-sm-3 my-auto mx-auto">
			    <input class="btn btn-info mt-3" type="button" value="Verificar" id="button-verificar-renavam" onClick="checkRenavam()">
			</div>

          </div>
          
          
          <div class="form-row">
            <div class="form-group col-sm-6">
              <label for="input-marca">Marca</label>
              <input type="text" class="form-control" id="input-marca" required="required" placeholder="Marca"
              		value=<%= veiculo != null ? veiculo.getMarca() : "" %> <%= veiculo != null ? "disabled" : "" %>>
            </div>

            <div class="form-group col-sm-6">
              <label for="input-modelo">Modelo</label>
              <input type="text" class="form-control" id="input-modelo" required="required" placeholder="Modelo"
              		value=<%= veiculo != null ? veiculo.getModelo() : "" %> <%= veiculo != null ? "disabled" : "" %>>
            </div>
          </div>
		  

	          <div class="form-group">
	            <label for="input-tipo-valor">Tipo de Valor</label>
	            <select name="tipo-valor" class="form-control" id="input-tipo-valor" onchange="insertCamposValorDeterminado()">
	              <option selected="selected" value="FIPE">FIPE</option>
	              <option value="Determinado">Determinado</option>
	            </select>
	          </div>

	
          	<label>Valor em R$</label>
          	<span id="valor-determinado">
          		<input type="text" name="valor-determinado" id="valor-determinado-valor" disabled required="required" value='<%= veiculo != null ? veiculo.getFipe().getValorFIPE() : "0.00" %>'>
          	</span>


          <div class="form-group">
            <label for="input-franquia">Franquia</label>
            <select name="franquia" class="form-control" id="input-franquia">
              <option>Majorada</option>
              <option>Obrigatória</option>
              <option>Reduzida</option>
            </select>
          </div>

          <h2>Acessórios</h2>

          <div class="form-check">
           <input name="vidro" type="checkbox" class="form-check-input" id="vidro">
           <label class="form-check-label" for="vidro">Vidro</label>
         </div>

         <div class="form-check">
           <input name="retrovisor" type="checkbox" class="form-check-input" id="retrovisor">
           <label class="form-check-label" for="retrovisor">Retrovisor</label>
          </div>
		    </div>
			
			<div class="m-2">
				<input type="submit" class="btn btn-success col-sm-4" value="Next">
				<a href="/labsoft-site/" type="button" class="btn btn-danger col-sm-4">Cancelar</a>
        	</div>
        </form>
      </div>
    </div>

    
<jsp:include page="../common/footer.jsp" />