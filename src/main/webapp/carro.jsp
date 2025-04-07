<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.ifragodevs.TechShop.entity.*"%>
<%
Carro carro = (Carro) session.getAttribute("carro");
%>
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

				<%
				if (carro == null || carro.getItems().size() == 0) {
				%>
				<p>Lo sentimos no hay productos en el carro</p>
				<%
				} else {
				%>
				<div class="container border rounded p-2">
				<table class="table">
					<tr>
						<th>Id</th>
						<th>Nombre</th>
						<th>Precio</th>
						<th>Cantidad</th>
						<th>Total</th>
					</tr>
					<%
					for (ItemCarro item : carro.getItems()) {
					%>
					<tr>
						<td><%=item.getProducto().getId()%></td>
						<td><%=item.getProducto().getNombre()%></td>
						<td><%=item.getProducto().getPrecio()%></td>
						<td><%=item.getCantidad()%></td>
						<td><%=item.getImporte()%></td>
					</tr>
					<%
					}
					%>
				</table>

				<%
				}
				%>
				</div>
				

		</div>
	</div>

	<script src="jquery.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>
</html>