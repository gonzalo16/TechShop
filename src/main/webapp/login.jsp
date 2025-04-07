<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Creacion de cuenta</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">

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

							<div class="mb-md-5 mt-md-4 pb-5">

								<h2 class="fw-bold mb-2 text-uppercase">Login</h2>
								<p class="text-white-50 mb-5">Porfavor introduce tu email y
									contraseña!</p>

								<form action="/TechShop/login" method="post">

									<div data-mdb-input-init class="form-outline form-white mb-4">
										<input type="email" id="email" name="email"
											class="form-control form-control-lg" /> <label
											class="form-label" for="typeEmailX">Email</label>
									</div>

									<div data-mdb-input-init class="form-outline form-white mb-4">
										<input type="password" id="password" name="password"
											class="form-control form-control-lg" /> <label
											class="form-label" for="typePasswordX">Contraseña</label>
									</div>

									<button data-mdb-button-init data-mdb-ripple-init
										class="btn btn-outline-light btn-lg px-5" type="submit">Login</button>
								</form>


								<div class="d-flex justify-content-center text-center mt-4 pt-1">
									<a href="#!" class="text-white"><i
										class="fab fa-facebook-f fa-lg"></i></a> <a href="#!"
										class="text-white"><i
										class="fab fa-twitter fa-lg mx-4 px-2"></i></a> <a href="#!"
										class="text-white"><i class="fab fa-google fa-lg"></i></a>
								</div>

							</div>

						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>
</html>