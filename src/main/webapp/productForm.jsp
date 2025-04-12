<%@page import="java.time.format.DateTimeFormatter" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listado de productos</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">

<link href="../style.css" rel="stylesheet">
</head>

<body>

	<div class="wrapper">
		<!-- Aqui debemos agregar el archivo sidebar de layout  -->
		<jsp:include page="layout/sidebar.jsp" />

		<!-- Page Content  -->
		<div id="content">
			
			<!-- Navbar -->
			<jsp:include page="layout/navbar.jsp" />
			
			<div class="container">
				<p class="display-6">Añadir producto</p>
				<form action="${pageContext.request.contextPath}/productos/form" method="post">
					<div class="row">
						<div class="col-6">
							<div class="mb-3">
								<label for="nombre" class="form-label">Nombre</label>
								<input
									type="text" class="form-control" id="nombre"
									aria-describedby="nombreHelp" name="nombre" value="${producto.nombre}">
								<c:if test="${errores != null && errores.containsKey('nombre')}">
									<div style="color:red;">${errores.nombre}</div>
								</c:if>
							</div>
						</div>

						<div class="col-3">
							<label for="sku" class="form-label">SKU</label> 
							<input
								type="text" class="form-control" id="sku"
								aria-describedby="nombreHelp" name="sku" value="${producto.sku}">
								<c:if test="${errores != null && !empty errores.sku}">
										<div style="color:red;">${errores.sku}</div>
								</c:if>
						</div>
						<div class="col-3">
							<div class="mb-3">
								<label for="precio" class="form-label">Precio</label>
								<input
									type="number" min="0" class="form-control" id="precio"
									name="precio" value="${producto.precio > 0? producto.precio: ""}">
									<c:if test="${errores != null && !empty errores.precio}">
										<div style="color:red;">${errores.precio}</div>
									</c:if>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="col-6">
							<div class="mb-3">
								<label for="fecha_registro" class="form-label">Fecha
									registro</label>
									<input type="date" class="form-control"
									id="fecha_registro" name="fecha_registro" value="${producto.fechaRegistro != null ? producto.fechaRegistro.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")): ""}">
									<c:if test="${errores != null && !empty errores.fecha_registro}">
										<div style="color:red;">${errores.fecha_registro}</div>
									</c:if>
							</div>
						</div>
						<div class="col-6">
							<div class="mb-3">
								<label for="categoria" class="form-label">Categorias</label> <select
									class="form-control" name="categoria" id="categoria">
									<option value="">Seleccionar</option>
									<c:forEach items="${categorias}" var="c">
									<option value="${c.id}" ${c.id.equals(producto.categoria.id)? "selected" : ""}>${c.nombre}</option>
									</c:forEach>
								</select>
							</div>
							<c:if test="${errores != null && !empty errores.categoria}">
										<div style="color:red;">${errores.categoria}</div>
							</c:if>
						</div>
					</div>

					<hr>
					<input type="hidden" name="id" value="${producto.id}"></input>
					<input type="submit" class="btn btn-primary" value="${producto.id != null && producto.id > 0? "Editar":"Crear"}"></button>
				</form>

			</div>
		</div>
	</div>
	<script src="script.js"></script>
	<script src="jquery.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</html>