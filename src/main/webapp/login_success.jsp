<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    String nombre_usuario = (String) session.getAttribute("username");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inicio sesion correcto</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
	
<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" rel="stylesheet">

<style type="text/css">
.gradient-custom {
	/* fallback for old browsers */
	background: #6a11cb;
	/* Chrome 10-25, Safari 5.1-6 */
	background: -webkit-linear-gradient(to right, rgba(106, 17, 203, 1),
		rgba(37, 117, 252, 1));
	/* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
	background: linear-gradient(to right, rgba(106, 17, 203, 1),
		rgba(37, 117, 252, 1))
}
</style>
</head>
<body>

	<section class="vh-100 gradient-custom">

		<div class="container py-5 h-100">

			<div
				class="row d-flex justify-content-center align-items-center h-100">

				<div class="col-12 col-md-8 col-lg-6 col-xl-5">

					<div class="card bg-dark text-white" style="border-radius: 1rem;">

						<div class="card-body p-5 text-center">

							<i class="bi bi-check-circle-fill text-success"
								style="font-size: 2.3rem;"></i>

							<h5 class="mt-4"><%= nombre_usuario %></h5>
							<p>Has iniciado sesion con éxito</p>

							<a href="${pageContext.request.contextPath}/index.jsp" class="btn btn-success">Entrar<i
								class="bi bi-box-arrow-right ps-3"></i></a>

						</div>

					</div>

				</div>

			</div>

		</div>

	</section>

</body>
</html>