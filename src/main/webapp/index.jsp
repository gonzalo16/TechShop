<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TechShop | Main Page</title>

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
		
		<!-- Content -->
		<div id="content">
			<!-- Navbar -->
			<jsp:include page="layout/navbar.jsp" />
			<p class="text-center">!Bienvenido!, a la página principal de TechShop</p>	
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