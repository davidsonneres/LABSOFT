<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

    <title>SS Seguros</title>
</head>
<body>

<div id="header-bottom">
      <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="#"><i class="fas fa-car"></i> SS Seguros</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
          <div class="navbar-nav">
            <a class="nav-item nav-link" href="comprarSeguro.html">Comprar seguro</a>
            <a class="nav-item nav-link" href="gerarRelatorio.html">Gerar relat&oacute;rios</a>
            <a class="nav-item nav-link" href="alterarStatus.html">Alterar status da ap&oacute;lice</a>
            <form>
              <input type="text" name="user" placeholder="Usu&aacute;rio">
              <input type="password" name="pass" placeholder="Senha">
              <input type="submit" name="login" class="login loginmodal-submit" value="Login">
            </form>
          </div>
        </div>
      </nav>
    </div>

    <div class="jumbotron jumbotron-fluid" id="jumbo-imagem">
      <div class="container">
        <h1 class="display-4">Fluid jumbotron</h1>
        <p class="lead">This is a modified jumbotron that occupies the entire horizontal space of its parent.</p>

<!--  <div class="container">
      <section id="content">
        <form action="">
          <h1>Login Form</h1>
          <div>
            <input type="text" placeholder="Username" required="" id="username" />
          </div>
          <div>
            <input type="password" placeholder="Password" required="" id="password" />
          </div>
          <div>
            <input type="submit" value="Log in" />
          </div>
        </form>
      </section>
    </div>
-->



      </div>
    </div>

	<a href="CompraControle" type="button" class="btn btn-success">Comprar Seguro</a>
	<a href="RelatorioControle" type="button" class="btn btn-success">Gerar Relatórios</a>
	<a href="ApoliceStatusControle" type="button" class="btn btn-success">Alterar Status de Apólice</a>
	<a href="ApolicePendenteControle" type="button" class="btn btn-success">Apólice Pendente</a>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</body>
</html>