<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">

<link href="${pageContext.request.contextPath}/style.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" rel="stylesheet">

</head>
<body>
	<!-- Sidebar  -->
	<nav id="sidebar">
		<div class="sidebar-header">
			<h3>TechShop</h3>
		</div>
			<ul class="list-unstyled components">
				<li><a href="#" data-toggle="collapse" aria-expanded="false"><i class="bi bi-house me-2"></i>Home</a></li>
				<li><a href="/TechShop/productos" data-toggle="collapse"
					aria-expanded="false"><i class="bi bi-box me-2"></i>Productos</a></li>
				<li><a href="/TechShop/carro.jsp" data-toggle="collapse"
					aria-expanded="false"><i class="bi bi-cart me-2"></i>Carrito</a></li>
				
				
					<c:if test="${username == null}">
					<li><a href="/TechShop/login.html" data-toggle="collapse"
					aria-expanded="false"><i class="bi bi-person me-2"></i>Login</a></li>
					</c:if>
					
					<c:if test="${username != null}">
					<li><a href="${pageContext.request.contextPath}/logout" data-toggle="collapse"
					aria-expanded="false"><i class="bi bi-box-arrow-left me-2"></i>Logout</a></li>
					</c:if>
				
			</ul>
	</nav>
</body>
</html>