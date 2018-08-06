<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/font-awesome.min.css" rel="stylesheet">
<link href="css/main.css" rel="stylesheet">
<link href="css/animate.css" rel="stylesheet">
</head>
<body>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
	<c:choose>
		<c:when test="${param.localidade eq 'en_US'}">
			<fmt:setLocale value="en_US"/>
		</c:when>
		<c:otherwise>
			<fmt:setLocale value="pt_BR"/>
		</c:otherwise>
	</c:choose>
	<fmt:setBundle basename="message" var="locale"/>
	
	<header id="header" role="banner">
	<div class="main-nav">
		<div class="container">
			<div class="row">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target=".navbar-collapse">
						<span class="sr-only"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span> <span class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="mvc?logica=Index&localidade=${param.localidade}">
						<h1>
							<font color="white">PSW</font>
							
						</h1>
					</a>
					
				</div>
				<div class="collapse navbar-collapse">
				
				
					<ul class="nav navbar-nav navbar-right">
						<li class="scroll"><a href="mvc?logica=Index&localidade=${param.localidade}"><fmt:message key="inicio" /></a></li>
						<li class="scroll"><a href="mvc?logica=ListarPontoTuristicoLogic&localidade=${param.localidade}"><fmt:message key="tituloPonto" /></a></li>
						<li class="scroll"><a href="mvc?logica=ListarRestauranteLogic&localidade=${param.localidade}"><fmt:message key="tituloRestaurante" /></a></li>
						<li class="scroll"><a href="mvc?logica=ListarUsuarioLogic&localidade=${param.localidade}"><fmt:message key="tituloUsuario" /></a></li>
						
					</ul>
				</div>
			</div>
		</div>
	</div>
	</header>



	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/jquery.nav.js"></script>
	<script type="text/javascript" src="js/main.js"></script>
</body>
</html>