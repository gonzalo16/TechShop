<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*,com.ifragodevs.TechShop.entity.*"
	pageEncoding="UTF-8"%>
<%
List<Producto> productos = (List<Producto>) request.getAttribute("productos");
Optional<String> email = (Optional<String>) request.getAttribute("email");
%>
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

</head>

<body>

	<div class="wrapper">
		<!-- Sidebar  -->
		<nav id="sidebar">
			<div class="sidebar-header">
				<h3>Bootstrap Sidebar</h3>
			</div>

			<ul class="list-unstyled components">
				<p>Dummy Heading</p>
				<li><a href="#" data-toggle="collapse" aria-expanded="false">Home</a></li>
				<li><a href="/TechShop/productos.html" data-toggle="collapse"
					aria-expanded="false">Productos</a></li>
				<li><a href="/TechShop/carro.jsp" data-toggle="collapse"
					aria-expanded="false">Carrito</a></li>
				<li><a href="/TechShop/login.html" data-toggle="collapse"
					aria-expanded="false">Login</a></li>

			</ul>
		</nav>

		<!-- Page Content  -->
		<div id="content">

			<nav class="navbar navbar-expand-lg navbar-light bg-light">
				<div class="container-fluid">

					<button type="button" id="sidebarCollapse" class="btn btn-info">
						<i class="fas fa-align-left"></i> <span>Toggle Sidebar</span>
					</button>
					<button class="btn btn-dark d-inline-block d-lg-none ml-auto"
						type="button" data-toggle="collapse"
						data-target="#navbarSupportedContent"
						aria-controls="navbarSupportedContent" aria-expanded="false"
						aria-label="Toggle navigation">
						<i class="fas fa-align-justify"></i>
					</button>

					<div class="collapse navbar-collapse" id="navbarSupportedContent">
						<ul class="nav navbar-nav ml-auto">
							<li class="nav-item active"><a class="nav-link" href="#">Page</a>
							</li>
							<li class="nav-item"><a class="nav-link" href="">Page</a></li>
							<li class="nav-item"><a class="nav-link" href="#">Page</a></li>
							<li class="nav-item"><a class="nav-link" href="#">Page</a></li>
						</ul>
					</div>
				</div>
			</nav>


			<div class="container border rounded p-2">
				<%
				if (email.isPresent()) {
				%>

				<div class="row">
					<div class="col-3">
						<p>
							Bienvenido:
							<%=email.get()%></p>
						<%
						}
						%>
					</div>
					<%
					if (email.isPresent()) {
					%>
					<div class="col-9">
						<a class="btn btn-primary"
							href="<%=request.getContextPath()%>/productos/form" role="button">Añadir
							producto</a>
					</div>
					<%
					}
					%>
					<div class="row">
						<div class="col">
							<table class="table rounded">
								<thead>
									<tr>
										<th scope="col">Id</th>
										<th scope="col">Nombre</th>
										<th scope="col">Categoria</th>
										<%
										if (email.isPresent()) {
										%>
										<th scope="col">Precio</th>
										<th scope="col">Agregar</th>
										<th scope="col">Editar</th>
										<th scope="col">Eliminar</th>
										<%
										}
										%>
									</tr>
								</thead>
								<tbody>
									<%
									for (Producto p : productos) {
									%>
									<tr>
										<td><%=p.getId()%></td>
										<td><%=p.getNombre()%></td>
										<td><%=p.getCategoria().getNombre()%></td>
										<%
										if (email.isPresent()) {
										%>
										<td><%=p.getPrecio()%></td>
										<td><a
											class="link-success link-offset-2 link-underline-opacity-25 link-underline-opacity-100-hover"
											href="<%=request.getContextPath()%>/agregar-carro?id=<%=p.getId()%>">Agregar
												al carrito</a></td>
										<td><a
											class="link-success link-offset-2 link-underline-opacity-25 link-underline-opacity-100-hover"
											href="<%=request.getContextPath()%>/productos/form?id=<%=p.getId()%>">Editar</a></td>
										<td><a
											onclick="return confirm('¿Estas seguro que desea eliminar?');" class="link-danger link-offset-2 link-underline-opacity-25 link-underline-opacity-100-hover"
											href="<%=request.getContextPath()%>/productos/eliminar?id=<%=p.getId()%>">Eliminar</a></td>
										<%
										}
										%>
									</tr>

									<%
									}
									%>
								</tbody>
							</table>
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