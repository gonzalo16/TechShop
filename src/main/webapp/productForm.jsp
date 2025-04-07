<%@page import="java.time.format.DateTimeFormatter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	import=
	"java.util.*,
	java.time.format.*,
	com.ifragodevs.TechShop.entity.*"
	pageEncoding="UTF-8"%>

<%
List<Categoria> categorias = (List<Categoria>) request.getAttribute("categorias");
Map<String,String> errores = (Map<String,String>) request.getAttribute("errores");
Producto producto = (Producto)request.getAttribute("producto");
String fecha =  producto.getFechaRegistro() != null? producto.getFechaRegistro().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")): "";
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

<link href="../style.css" rel="stylesheet">
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

			<div class="container">
				<p class="display-5">Añadir producto</p>
				<form action="<%=request.getContextPath()%>/productos/form" method="post">
					<div class="row">
						<div class="col-6">
							<div class="mb-3">
								<label for="nombre" class="form-label">Nombre</label>
								<input
									type="text" class="form-control" id="nombre"
									aria-describedby="nombreHelp" name="nombre" value="<%=producto.getNombre() != null ? producto.getNombre(): ""%>">
								<%if(errores != null && errores.containsKey("nombre")){ %>
									<div style="color:red;"><%=errores.get("nombre") %></div>
								<%} %>
							</div>
						</div>

						<div class="col-3">
							<label for="sku" class="form-label">SKU</label> 
							<input
								type="text" class="form-control" id="sku"
								aria-describedby="nombreHelp" name="sku" value="<%=producto.getSku() != null ? producto.getSku() : ""%>">
								<%if(errores != null && errores.containsKey("sku")){ %>
									<div style="color:red;"><%=errores.get("sku") %></div>
								<%} %>
						</div>
						<div class="col-3">
							<div class="mb-3">
								<label for="precio" class="form-label">Precio</label>
								<input
									type="number" min="0" class="form-control" id="precio"
									name="precio" value="<%=producto.getPrecio() != 0 ? producto.getPrecio() : ""%>">
									<%if(errores != null && errores.containsKey("precio")){ %>
									<div style="color:red;"><%=errores.get("precio") %></div>
								<%} %>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="col-6">
							<div class="mb-3">
								<label for="fecha_registro" class="form-label">Fecha
									registro</label>
									<input type="date" class="form-control"
									id="fecha_registro" name="fecha_registro" value="<%=fecha%>">
									<%if(errores != null && errores.containsKey("fecha_registro")){ %>
									<div style="color:red;"><%=errores.get("fecha_registro") %></div>
								<%} %>
							</div>
						</div>
						<div class="col-6">
							<div class="mb-3">
								<label for="categoria" class="form-label">Categorias</label> <select
									class="form-control" name="categoria" id="categoria">
									<option value="">Seleccionar</option>
									<%
									for (Categoria c : categorias) {
									%>
									<option value="<%=c.getId()%>" <%=c.getId().equals(producto.getCategoria().getId())? "selected" : "" %>><%=c.getNombre()%></option>
									<%
									}
									%>
								</select>
							</div>
							<%if(errores != null && errores.containsKey("categoria")){ %>
									<div style="color:red;"><%=errores.get("categoria") %></div>
							<%} %>
						</div>
					</div>



					<button type="submit" class="btn btn-primary">Enviar</button>
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