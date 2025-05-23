<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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

<link href="style.css" rel="stylesheet">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css"
	rel="stylesheet">

</head>

<body>

	<div class="wrapper">
		<!-- Aqui debemos agregar el archivo sidebar de layout  -->
		<jsp:include page="layout/sidebar.jsp" />

		<!-- Page Content  -->
		<div id="content">

			<!-- Navbar -->
			<jsp:include page="layout/navbar.jsp" />

			<!-- Filtros  -->
			<div class="">
				<div class="mb-4 p-3 bg-white rounded shadow-sm my-1">
					<div class="d-flex flex-wrap gap-2 align-items-center">
						<span class="fw-semibold me-2">Filtrar por:</span>
						<button class="btn btn-outline-secondary btn-sm">
							<i class="fas fa-tags me-1"></i> Categoría
						</button>
						<button class="btn btn-outline-secondary btn-sm">
							<i class="fas fa-dollar-sign me-1"></i> Precio
						</button>
						<button class="btn btn-outline-secondary btn-sm">
							<i class="fas fa-star me-1"></i> Valoración
						</button>
						<span class="fw-semibold ms-4 me-2">Ordenar por:</span>
						<button class="btn btn-outline-primary btn-sm">
							<i class="fas fa-sort-amount-down me-1"></i> Precio menor
						</button>
						<button class="btn btn-outline-primary btn-sm">
							<i class="fas fa-sort-amount-up me-1"></i> Precio mayor
						</button>
						<button class="btn btn-outline-primary btn-sm">
							<i class="fas fa-fire me-1"></i> Más vendido
						</button>
					</div>
				</div>
			</div>

			<div class="container border rounded p-2 shadow">
				<div class="row">
					<c:if test="${not empty username}">

						<div class="col-9 ">
							<a class="btn btn-primary"
								href="<c:out value="${pageContext.request.contextPath}" />/productos/form"
								role="button"><i class="bi bi-plus-lg"></i>Añadir producto</a>
						</div>


					</c:if>
					<div class="row mt-2">
						<div class="col">
							<table class="table rounded table-striped">
								<thead>
									<tr>
										<th scope="col">Id</th>
										<th scope="col">Nombre</th>
										<th scope="col">Categoria</th>

										<c:if test="${not empty username}">
											<th scope="col">Precio</th>
											<th scope="col">Agregar</th>
											<th scope="col">Editar</th>
											<th scope="col">Eliminar</th>
										</c:if>

									</tr>
								</thead>
								<tbody>
									<c:forEach items="${productos}" var="p">
										<tr>
											<td><c:out value="${p.id}" /></td>
											<td><c:out value="${p.nombre}" /></td>
											<td><c:out value="${p.categoria.nombre}" /></td>
											<c:if test="${not empty username}">
												<td><c:out value="${p.precio}" /></td>
												<td><a
													class="link-success link-offset-2 link-underline-opacity-25 link-underline-opacity-100-hover"
													href="${pageContext.request.contextPath}/agregar-carro?id=<c:out value="${p.id}"/>">Agregar
														al carrito</a></td>
												<td><a
													class="link-success link-offset-2 link-underline-opacity-25 link-underline-opacity-100-hover"
													href="${pageContext.request.contextPath}/productos/form?id=<c:out value="${p.id}"/>">Editar</a></td>
												<td><a
													onclick="return confirm('¿Estas seguro que desea eliminar?');"
													class="link-danger link-offset-2 link-underline-opacity-25 link-underline-opacity-100-hover"
													href="${pageContext.request.contextPath}/productos/eliminar?id=<c:out value="${p.id}"/>">Eliminar</a></td>
											</c:if>
										</tr>
									</c:forEach>
								</tbody>
							</table>

							<div>
								<nav aria-label="Page navigation example">
									<ul class="pagination">
										<li class="page-item"><a class="page-link" href="#">Previous</a></li>
										<li class="page-item"><a class="page-link" href="#">1</a></li>
										<li class="page-item"><a class="page-link" href="#">2</a></li>
										<li class="page-item"><a class="page-link" href="#">3</a></li>
										<li class="page-item"><a class="page-link" href="#">Next</a></li>
									</ul>
								</nav>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="script.js"></script>
	<script src="jquery.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>
</html>