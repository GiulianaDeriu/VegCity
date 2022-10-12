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
<link rel="stylesheet" href="/resources/css/profile.css">
<link rel="icon" type="image/x-icon" href="/resources/img/Logo.svg" />
<title>Profile</title>
</head>
<body>
	<div class="container">
		<div class="forms-container">
			<div class="profile">
			
			<a href="/logout">Log out</a>
<!-- 				<input type="submit" formaction="/logout" formmethod="post" -->
<!-- 					class="btn" value="Log out" name="logout" id="logout"/>	 -->
				<form class="account-form"> 
					<h2 class="title">Le tue ricette</h2>
					<div class="container-1">
						<div id="output-account">
							<c:forEach items="${tue}" var="globale">
								<h4>
									titolo: ${globale.titolo} <input type="submit"
										formaction="/ricetta/updateRecipe?id=${globale.id}"
										formmethod="post" class="little-btn" value="modifica" />
										<input
										type="submit"
										formaction="/ricetta/deleteRecipe?id=${globale.id}"
										formmethod="post" class="little-btn" value="elimina" />
								</h4>
								<p>ingredienti: ${globale.ingredienti}</p>
								<p>preparazione: ${globale.preparazione}</p>
								<p>cottura: ${globale.cottura}</p>
								<%-- 						<p>img: ${globale.img} </p> --%>
							</c:forEach>
						</div>
					</div>
					<input type="submit" formaction="/ricetta/newRecipe"
						formmethod="post" class="btn" value="Aggiungi" name="aggiungi" />
				</form>
				<form action="#" class="users-form">
					<h2 class="title">Nuove Ricette</h2>
					<div class="container-2">
						<div id="output-ricette">
							<c:forEach items="${tutte}" var="globale">
								<h4>titolo: ${globale.titolo}</h4>
								<p>ingredienti: ${globale.ingredienti}</p>
								<p>preparazione: ${globale.preparazione}</p>
								<p>cottura: ${globale.cottura}</p>
								<%-- 						<p>img: ${globale.img} </p> --%>
							</c:forEach>
						</div>
					</div>
					.
					<!-- 					<div class="search"> -->
					<%-- 						<form action="" class="search"> --%>
					<!-- 							<input type="search" class="input-search" required> <i -->
					<!-- 								class="fa fa-search"></i> -->
					<%-- 						</form> --%>
					<!-- 					</div> -->
				</form>
			</div>
		</div>
		<div class="panels-container">
			<div class="panel left-panel">
				<div class="content">
					<h3>Cerchi qualcosa di nuovo?</h3>
					<p>Clicca sul bottone per scoprire le ricette degli altri
						utenti!</p>
					<button class="btn transparent" id="users-btn">Nuove
						ricette</button>
				</div>
				<img src="/resources/img/utente.svg" class="image" alt="" />
			</div>
			<div class="panel right-panel">
				<div class="content">
					<h3>Vuoi condividere una tua ricetta?</h3>
					<p>Clicca sul bottone per aggiungere, modificare o eliminare le
						tue ricette!</p>
					<button class="btn transparent" id="account-btn">Vai al
						tuo account</button>
				</div>
				<img src="/resources/img/community.svg" class="image" alt="" />
			</div>
		</div>
	</div>
	<script type="text/javascript" src="/resources/js/profile.js"></script>
</body>
</html>