<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="${pageContext.request.contextPath}/style.css"
	rel="stylesheet">

</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container-fluid">
			<div class="row">
				<div class="col-6">
					<input type="text" class="form-control">
				</div>
				<div class="col-3">
					<button type="submit" class="btn btn-primary">Buscar</button>
				</div>
				<div class="col-3">
					<c:if test="${not empty username}">
						<span class="badge rounded-pill text-bg-primary">Usuario: <c:out
									value="${username}" /></span>
					</c:if>
				</div>
			</div>
		</div>
	</nav>
</body>
</html>