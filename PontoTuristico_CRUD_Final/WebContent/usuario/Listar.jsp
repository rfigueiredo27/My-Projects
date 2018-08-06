<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="psw"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="mapa"%>
<c:import url="../cabecalho.jsp" />
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
<title>Usuarios</title>
<link rel="stylesheet" type="text/css"
	href="DataTable/css/jquery.dataTables.css">
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<script type="text/javascript" language="javascript"
	src="DataTable/js/jquery.js"></script>
<script type="text/javascript" language="javascript"
	src="DataTable/js/jquery.dataTables.js"></script>
<script type="text/javascript" language="javascript"
	src="DataTable/js/tabela.js"></script>
</head>
<body>
<fmt:setBundle basename="message" var="locale"/>
	<br />
	<br />
	<br />
	<br />
	<br />
	<div class="container">
		<div class="row">
			<!--Usando a taglib própria-->
			
			<h3><fmt:message key="tituloUsuario" /></h3><fmt:message key="idioma" />:<a href="mvc?logica=ListarUsuarioLogic&&localidade=pt_BR"> PT-BR</a> &nbsp; | &nbsp; <a href="mvc?logica=ListarUsuarioLogic&&localidade=en_US">EN-US</a>
			<br>
			<h4><strong>Pesquisas</strong></h4>
			
			<div class="dataTables_wrapper">
			
				<div style="float: left;">
	                <table class="tableIndexLista table-striped table-hover">
	                    <tr id="filter_col2" data-column="1">
	                        <td align="right"><b>&nbsp&nbsp <fmt:message key="nome" />:</b></td>
	                        <td align="left">
	                            <input type="search" class="column_filter" id="col1_filter"></td>
	                    </tr>                 
	                </table>
	            </div>
	            <div style="float: left;">
	                <table class="tableIndexLista table-striped table-hover">
	                    <tr id="filter_col3" data-column="2">
	                        <td align="right"><b>&nbsp&nbsp <fmt:message key="usuario" />:</b></td>
	                        <td align="left">
	                            <input type="search" class="column_filter" id="col2_filter"></td>
	                    </tr> 
	                </table>
	            </div>
	            
	            </div>
	            <br><br><br>
			
				<table id="tabela"
					class="tableIndexLista table-striped table-bordered table-hover">
					<thead>
						<tr>
							<th><fmt:message key="tituloUsuario" /></th>
							<th><fmt:message key="tituloUsuario" /></th>
							<th><fmt:message key="tituloUsuario" /></th>
							<th><fmt:message key="tituloUsuario" /></th>
							<th align="center"><center>
									<a class='btn btn-info' href="mvc?logica=InsereUsuarioLogic">
								Inserir Novo</a>
								</center></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${lista}" var="x">
							<tr>
								<td>${x.id}</td>
								<td>${x.nome}</td>
								<td>${x.login}</td>
								<td>xxx</td>
								<td align="center"><a class='btn btn-success'
									href="<%=request.getContextPath()%>/mvc?logica=EditarUsuarioLogic&id=${x.id}&localidade=${param.localidade}"><fmt:message key="alterar" /></a>
									<a class='btn btn-warning'
									href="<%=request.getContextPath()%>/mvc?logica=DetalheUsuarioLogic&id=${x.id}&localidade=${param.localidade}"><fmt:message key="detalhes" /></a>
									<a class='btn btn-danger'
									href="<%=request.getContextPath()%>/mvc?logica=RemoveUsuarioLogic&id=${x.id}&localidade=${param.localidade}"><fmt:message key="excluir" /></a>
								</td>

							</tr>
						</c:forEach>

					</tbody>
				</table>
			</div>
		</div>
	</div>
	<br>
	<c:import url="../rodape.jsp" />
</body>