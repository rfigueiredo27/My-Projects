<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:choose>
		<c:when test="${param.localidade eq 'en_US'}">
			<fmt:setLocale value="en_US"/>
		</c:when>
		<c:otherwise>
			<fmt:setLocale value="pt_BR"/>
		</c:otherwise>
	</c:choose>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Cadastrar Restaurante</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
<script src="js/bootstrap.js"></script>
<c:import url="../cabecalho.jsp" />
</head>
<body>
<fmt:setBundle basename="message" var="locale"/>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<br />
	<br />
	<br />
	<br />
	<div class="contact-section">
		<div class="container">
			<div class="row">
				<h3><fmt:message key="formulario" /></h3>
				<fmt:message key="idioma" />:<a href="mvc?logica=DetalheRestauranteLogic&id=${alb.id}&&localidade=pt_BR"> PT-BR</a> &nbsp; | &nbsp; <a href="mvc?logica=DetalheRestauranteLogic&id=${alb.id}&&localidade=en_US">EN-US</a>
				
				<form class="contact-form" method="post"
					action="<%=request.getContextPath()%>/mvc?logica=SalvarRestauranteLogic" >

					<div class="form-group">
						ID : <input type="text" readonly="readonly" name="id"
							class="form-control" value="${alb.id}" />
					</div>

					<div class="form-group">
						<fmt:message key="nome" />: <input type="text" readonly="readonly" name="nome" class="form-control"
							value="${alb.nome}" />
					</div>

					<div class="form-group">
						<fmt:message key="descricao" />: <input type="text" readonly="readonly" name="descricao"
							class="form-control" value="${alb.descricao}" />
					</div>

					<div class="form-group">
						<fmt:message key="cidade" />: <input type="text" readonly="readonly" name="cidade" class="form-control"
							value="${alb.cidade}" />
					</div>

					<div class="form-group">
						estado: <input type="text" readonly="readonly" name="estado" class="form-control"
							value="${alb.estado}" />
					</div>

					 <a
						class="btn btn-danger" href="mvc?logica=ListarRestauranteLogic&localidade=${param.localidade}"><fmt:message key="voltar" /></a>
				</form>
			</div>
		</div>
	</div>
	<c:import url="../rodape.jsp" />

</body>
</html>