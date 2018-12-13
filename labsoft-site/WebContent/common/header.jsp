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

<% String permission = (String) session.getAttribute("permission"); %>

<div id="header-bottom">
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark text-light">
			<a class="navbar-brand" href="/labsoft-site/"><i class="fas fa-car"></i> SS Seguros</a>
				<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
			<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item">
						<a class="nav-link text-light" href="ControleCompra">Comprar seguro</a>
					</li>
					<% if (permission.equals("gerente")) { %>
						<li class="nav-item">
							<a class="nav-link text-light" href="ControleRelatorio">Gerar relat&oacute;rios</a>
						</li>
					<% } %>
					<% if (permission.equals("corretor")) {%>
						<li class="nav-item">
							<a class="nav-link text-light" href="ApoliceControle">Alterar status da ap&oacute;lice</a>
						</li>
					<% } %>
				</ul>
				<ul class="navbar-nav">
					<div class="navbar-nav align-items-end">
						<a class="nav-item nav-link active" href="/labsoft-site?logout=true">Logout</a>
					</div>	
				</ul>
			</div>
		</nav>
	</div>