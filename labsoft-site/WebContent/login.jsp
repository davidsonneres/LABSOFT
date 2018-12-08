<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	<!-- Font Awesome icons -->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
    <style type="text/css">
	    html, body {
	    	height: 100%;
	    	background-color: #F5F5F5;
	    }
    </style>
    
	<title>SS Seguros</title>
</head>
<body>

	<div class="container">
		<div class="row">
	        <div class="col-sm-4 mx-auto">
				<% Object successfulLogin = request.getAttribute("login"); %>
				<% if (successfulLogin != null && !(boolean) successfulLogin) { %>
				<div class="alert alert-danger alert-dismissible fade show" role="alert">
				  Usuário ou senha incorreto
				  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
				    <span aria-hidden="true">&times;</span>
				  </button>
				</div>
				<% } %>
				
				<i class="fa fa-car display-2 d-flex justify-content-center mt-5" aria-hidden="true"></i>
				<h2 class="d-flex justify-content-center my-3">SS Seguros</h2>
				<div class="border border-gray rounded bg-white">
					<div class="m-2">
						<form method="post">
						  <div class="form-group">
						    <label for="username">CPF:</label>
						    <input name="cpf" type="text" class="form-control" id="username" required="required" placeholder="Digite o cpf">
						  </div>
						  <div class="form-group">
						    <label for="password">Senha:</label>
						    <input name="senha" type="password" class="form-control" id="password" required="required" placeholder="Digite a senha">
						  </div>
						  <button type="submit" class="btn btn-success btn-block">Login</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

<jsp:include page="common/footer.jsp" />