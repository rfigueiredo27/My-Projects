<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

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

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/font-awesome.min.css" rel="stylesheet">
<link href="css/main.css" rel="stylesheet">
<link href="css/animate.css" rel="stylesheet">
<link href="css/responsive.css" rel="stylesheet">
<c:import url="cabecalho.jsp" />
</head>
<body>
	<fmt:setBundle basename="message" var="locale"/>

	<section id="explore">
	<div class="container">
		<div class="row">
			<div class="watch">
				<img class="img-responsive" src="images/watch.png" alt="">

				<h2><fmt:message key="idioma" />:<a href="mvc?logica=Index&localidade=pt_BR"> PT-BR</a> &nbsp; | &nbsp; <a href="mvc?logica=Index&localidade=en_US">EN-US</a></h2>
			</div>
			<div class="col-md-4 col-md-offset-2 col-sm-5">
				<h2><fmt:message key="tituloPonto" /></h2>
			</div>
			<div class="col-sm-7 col-md-6">
				<h2 class="center">
					<a href="mvc?logica=ListarPontoTuristicoLogic&localidade=${param.localidade}"><fmt:message key="acessarPonto" /></a>
				</h2>
			</div>
			<div class="col-md-4 col-md-offset-2 col-sm-5">
				<h2><fmt:message key="tituloRestaurante" /></h2>
			</div>
			<div class="col-sm-7 col-md-6">
				<h2 class="center">
					<a href="mvc?logica=ListarRestauranteLogic"><fmt:message key="acessarRestaurante" /></a>
				</h2>
			</div>
			<div class="col-md-4 col-md-offset-2 col-sm-5">
				<h2><fmt:message key="tituloUsuario" /></h2>
			</div>
			<div class="col-sm-7 col-md-6">
				<h2 class="center">
					<a href="mvc?logica=ListarUsuarioLogic&localidade=${param.localidade}"><fmt:message key="acessarUsuario" /></a>
				</h2>
			</div>
		</div>
	</div>
	</section>
	<c:import url="rodape.jsp" />
</body>
</html>