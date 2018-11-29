<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@page import="model.Cliente"%>
	<%@page import="model.Veiculo" %>
	<% Cliente cliente = (Cliente) request.getAttribute("cliente");%>
	<% Veiculo veiculo = (Veiculo) request.getAttribute("veiculo");%>
	<% Boolean firstAccess = (Boolean) request.getAttribute("firstAccess"); %>
	
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.min.js" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

	<script>
		function insertCamposValorDeterminado() {
			container = $("#valor-determinado");
			container.empty();
			if ($("#input-tipo-valor option:selected").text() == "FIPE") {
				$("<input type='label' name='valor-determinado' id='valor-determinado-valor' disabled value=" + <%= veiculo != null ? veiculo.getFipe().getValorFIPE() : "0.00" %> + ">").appendTo(container);
			} else {
				$("<input type='number' name='valor-determinado' id='valor-determinado-valor' placeholder='Digite o valor'></input>").appendTo(container);
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
    		if (renavamIndex < 0) {
    			window.location.href += "&renavam=" + renavam;
    		} else {
    			window.location.href = url.substring(0, renavamIndex) + "&renavam=" + renavam;
    		}	
    	}
    </script>

    <title>Comprar seguro</title>
</head>
<body>

    <div class="container">
    
    	<% if (firstAccess != null && cliente == null) { %>
		<div class="alert alert-danger alert-dismissible fade show" role="alert">
		  CPF Inválido
		  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
		    <span aria-hidden="true">&times;</span>
		  </button>
		</div>
		<% } else if (firstAccess != null & veiculo == null){%>
		<div class="alert alert-danger alert-dismissible fade show" role="alert">
		  RENAVAM Inválido
		  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
		    <span aria-hidden="true">&times;</span>
		  </button>
		</div>
		<% } %>
    
      <h1>Compre seguro</h1>

      <div class="container w-75">
        <form method="POST">
          <h2>Dados do segurado</h2>
          <div class="form-row">
            <div class="form-group col-sm-5">
              <label for="input-cpf">CPF</label>
              <input type="text" name="cpf" class="form-control" id="input-cpf" placeholder="Digite seu CPF"
              		value=<%= cliente != null ? cliente.getCPF() : "" %>>
            </div>

			<div class="form-group col-sm-2">
				<input type="button" value="Verificar" id="button-verificar" onClick="checkCPF()">
			</div>

            <div class="form-group col-sm-5">
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
            <input type="text" class="form-control" id="input-nome-segurado" placeholder="Nome Completo"
            		value='<%= cliente != null ? cliente.getNome() : "" %>' <%= cliente != null ? "disabled" : "" %>>
          </div>

          <div class="form-row">
            <div class="form-group col-sm-8">
              <label for="input-nacionalidade">Nacionalidade</label>
              <input type="text" class="form-control" id="input-nacionalidade" placeholder="Nacionalidade"
              		 value=<%= cliente != null ? cliente.getNacionalidade() : "" %> <%= cliente != null ? "disabled" : "" %>>
            </div>

            <div class="form-group col-sm-4">
              <label for="input-data-nascimento">Data de nascimento</label>
              <input type="date" class="form-control" id="input-data-nascimento" placeholder="Data de nascimento"
              		 value=<%= cliente != null ? cliente.getDataNascimento().toString() : "" %> <%= cliente != null ? "disabled" : "" %>>
            </div>
          </div>

          <div class="form-row">
            <div class="form-group col-sm-8">
              <label for="input-email">Email</label>
              <input type="text" class="form-control" id="input-email" placeholder="Email"
              		value='<%= cliente != null ? cliente.getEmail() : "" %>' <%= cliente != null ? "disabled" : "" %>>
            </div>

            <div class="form-group col-sm-4">
              <label for="input-telefone">Telefone</label>
              <input type="text" class="form-control" id="input-telefone" placeholder="Telefone"
              		value='<%= cliente != null ? cliente.getTelefone() : "" %>' <%= cliente != null ? "disabled" : "" %>>
            </div>
          </div>

          <div class="form-row">
             <label for="input-cnh">CNH</label>
             <input type="text" class="form-control" id="input-cnh" placeholder="CNH"
             		value=<%= cliente != null ? cliente.getCNH() : "" %> <%= cliente != null ? "disabled" : "" %>>
          </div>

          <div class="form-row">
            <label for="input-endereço">Endereço</label>
            <input type="text" class="form-control" id="input-endereço" placeholder="Endereço"
            		value='<%= cliente != null ? cliente.getEndereco() : "" %>' <%= cliente != null ? "disabled" : "" %>>
          </div>


          <h2>Dados veículo</h2>
          <div class="form-row">
            <div class="form-group col-sm-10">
              <label for="input-renavam">RENAVAM</label>
              <input type="text" name="renavam" class="form-control" id="input-renavam" placeholder="Digite o RENAVAM do veículo"
              		value=<%= veiculo != null ? veiculo.getRenavam() : "" %>>
            </div>

			<div class="form-group col-sm-2">
			    <input type="button" value="Verificar" id="button-verificar-renavam" onClick="checkRenavam()">
			</div>
          </div>
          
          
          <div class="form-row">
            <div class="form-group col-sm-6">
              <label for="input-marca">Marca</label>
              <input type="text" class="form-control" id="input-marca" placeholder="Marca"
              		value=<%= veiculo != null ? veiculo.getMarca() : "" %> <%= veiculo != null ? "disabled" : "" %>>
            </div>

            <div class="form-group col-sm-6">
              <label for="input-modelo">Modelo</label>
              <input type="text" class="form-control" id="input-modelo" placeholder="Modelo"
              		value=<%= veiculo != null ? veiculo.getModelo() : "" %> <%= veiculo != null ? "disabled" : "" %>>
            </div>
          </div>
		  
		  <div>
			  <div class="col-sm-6">
		          <div class="form-group">
		            <label for="input-tipo-valor">Tipo de Valor</label>
		            <select name='tipo-valor' class="form-control" id="input-tipo-valor" onchange="insertCamposValorDeterminado()">
		              <option selected="selected">FIPE</option>
		              <option>Determinado</option>
		            </select>
		          </div>
	          </div>
	          <div class="col-sm-6">
	          	<label>Valor em R$</label>
	          	<span id="valor-determinado">
	          		<input type="label" name="valor-determinado" id="valor-determinado-valor" disabled value='<%= veiculo != null ? veiculo.getFipe().getValorFIPE() : "0.00" %>'>
	          	</span>
	          </div>
		  </div>
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
           <input type="checkbox" class="form-check-input" id="vidro">
           <label class="form-check-label" for="vidro">Vidro</label>
         </div>

         <div class="form-check">
           <input type="checkbox" class="form-check-input" id="retrovisor">
           <label class="form-check-label" for="retrovisor">Retrovisor</label>
          </div>


          <input type="submit" class="btn btn-success" value="Next">
          <a href="inicial.html" type="button" class="btn btn-danger">Cancelar</a>
        </form>
      </div>
    </div>
    
  </body>
</html>