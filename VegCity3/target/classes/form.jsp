<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://kit.fontawesome.com/66db582487.js"
	crossorigin="anonymous"></script>
<link rel="stylesheet" href="/resources/css/form.css">
<link rel="icon" type="image/x-icon" href="/resources/img/Logo.svg" />
<title>Form</title>
</head>
<body>
	<div class="container">
		<div class="forms-container">
			<form action="/ricetta/createRecipe" method="post" class="recipe">
				<input type="hidden" name="id" value="${recipe.id}" />
				<h2 class="title">Condividi la tua ricetta!</h2>
				<div class="input-field">
					<i class="fas fa-carrot"></i> <input id="titolo" type="text"
						name="titolo" required placeholder="Titolo"
						value="${recipe.titolo}">
				</div>
				<div class="input-field">
					<i class="fas fa-lemon"></i> <input id="ingredienti" type="text"
						name="ingredienti" required placeholder="Ingredienti"
						value="${recipe.ingredienti}" />
				</div>
				<div class="input-field">
					<i class="fas fa-utensils"></i> <input id="preparazione"
						type="text" name="preparazione" required
						placeholder="preparazione" value="${recipe.preparazione}" />
				</div>
				<div class="input-field">
					<i class="fas fa-fire"></i> <input id="cottura" type="text"
						name="cottura" required placeholder="Cottura"
						value="${recipe.cottura}">
				</div>
				<!-- 				<div class="input-field"> -->
				<!-- 					<i class="fa-solid fa-image"></i> <input type="file" -->
				<%-- 						name="foto_ricetta" value="${recipe.img}"> --%>
				<!-- 				</div> -->
				<input type="submit" class="btn" value="Invia" />
			</form>
			<img id="libro" class="image" src="/resources/img/Libro1.svg">
		</div>
	</div>
</body>
</html>