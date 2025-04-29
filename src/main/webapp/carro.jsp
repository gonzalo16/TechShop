<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.ifragodevs.TechShop.entity.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Carro de compras</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">

<link href="style.css" rel="stylesheet">
</head>
<body>

	<div class="wrapper">
		<!-- Aqui debemos agregar el archivo sidebar de layout  -->
		<jsp:include page="layout/sidebar.jsp" />
		<div id="content">

			<!-- Navbar -->
			<jsp:include page="layout/navbar.jsp" />

			<c:choose>
				<c:when test="${carro == null || carro.items.isEmpty()}">
					<div class="alert alert-warning">Lo sentimos no hay productos
						en el carro de compras</div>
				</c:when>

				<c:otherwise>
				<form>
					<div class="container border rounded p-2">
						<table class="table">
							<tr>
								<th>Id</th>
								<th>Nombre</th>
								<th>Precio €</th>
								<th>Cantidad</th>
								<th>Total</th>
								<th>Borrar</th>
							</tr>
							<c:forEach items="${carro.items}" var="item">
								<tr>
									<td>${item.producto.id}</td>
									<td>${item.producto.nombre}</td>
									<td>${item.producto.precio}</td>
									<td>${item.cantidad}</td>
									<td>${item.importe}</td>
									<td><a
										class="link-danger link-offset-2 link-underline-opacity-25 link-underline-opacity-100-hover"
										href="${pageContext.request.contextPath}/productos/eliminar?id=<c:out value="${p.id}"/>">Eliminar</a></td>
									</td>
								</tr>
							</c:forEach>
							<tr>
								<td colspan="6"><strong>Total: ${carro.totalItems}</strong></td>
							</tr>
						</table>
					</div>
				  </form>
				</c:otherwise>
			</c:choose>
		</div>
	</div>

	<script src="jquery.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>
</html>