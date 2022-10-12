<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<script src="https://kit.fontawesome.com/64d58efce2.js"
	crossorigin="anonymous"></script>
<link rel="stylesheet" href="/resources/css/registrazione.css">
<link rel="icon" type="image/x-icon" href="/resources/img/Logo.svg" />
<title>Registrazione</title>
</head>
<body>
	<c:if test="${errore != null && errore==false}">
		<script type="text/javascript">
			alert = "credenziali errate"
		</script>
	</c:if>
	<div class="container">
		<div class="forms-container">
			<div class="signin-signup">
				<form action="/user/profile" method="post" class="sign-in-form">
					<h2 class="title">Accedi</h2>
					<div class="input-field">
						<i class="fas fa-user"></i> <input type="text" name="name"
							required placeholder="Username" />
					</div>
					<div class="input-field">
						<i class="fas fa-lock"></i> <input type="password" name="password"
							required placeholder="Password" />
					</div>
					<input type="submit" value="Login" class="btn solid" />
				</form>

				<form action="/user/registrazione/submit" method="post"
					class="sign-up-form">
					<h2 class="title">Registrati</h2>
					<div class="input-field">
						<i class="fas fa-user"></i> <input type="text" name="name"
							required placeholder="Username" />
					</div>
					<div class="input-field">
						<i class="fas fa-envelope"></i> <input type="email" name="email"
							required placeholder="Email" />
					</div>
					<div class="input-field">
						<i class="fas fa-lock"></i> <input type="password" name="password"
							required placeholder="Password" />
					</div>
					<input type="submit" class="btn" value="Registrati" />
				</form>
			</div>
		</div>
		<div class="panels-container">
			<div class="panel left-panel">
				<div class="content">
					<h3>Sei nuovo?</h3>
					<p>Entra a far parte della nostra community e condividi con noi
						le tue ricette vegane preferite!</p>
					<button class="btn transparent" id="sign-up-btn">
						Registrati</button>
				</div>
				<img src="/resources/img/Frutta.svg" class="image" alt="" />
			</div>
			<div class="panel right-panel">
				<div class="content">
					<h3>Sei già registrato?</h3>
					<p>Accedi e scopri le nuove ricette del giono, oppure caricane
						una tu!</p>
					<button class="btn transparent" id="sign-in-btn">Accedi</button>
				</div>
				<img src="/resources/img/Verdure.svg" class="image" alt="" />
			</div>
		</div>
	</div>
	<script type="text/javascript" src="/resources/js/registrazione.js"></script>
</body>
</html>