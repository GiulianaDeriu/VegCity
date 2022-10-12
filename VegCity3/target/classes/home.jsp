<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script src="https://kit.fontawesome.com/66db582487.js"
	crossorigin="anonymous"></script>
<link rel="stylesheet" href="/resources/css/index.css">
<link rel="icon" type="image/x-icon" href="/resources/img/Logo.svg" />
<title>VegCity</title>
</head>
<body>
	<div class="container">
		<div class="navbar">
			<div class="vegcity">
				<span id="veg" style="color: #078146">VEG</span> <span id="city"
					style="color: #7dba41">CITY</span>
			</div>
			<label> <input type="checkbox"> <span class="menu">
					<span class="hamburger"></span>
			</span>
				<ul>
					<li><a href="#">Home</a></li>
					<li><a href="#">About</a></li>
					<li><a href="#">Contact</a></li>
					<a href="login"><button class="login">Login</button></a>
				</ul>
			</label>
		</div>
		<section>
			<div class="left">
				<h2>
					Cucina<br>Vegana
				</h2>
				<p>VegCity è un ricettario digitale dove poter condividere e
					scoprire ogni giorno nuove fantastiche ricette 100% vegan!
					Condividi anche tu una ricetta speciale con noi!</p>
				<a href="registrazione"><button id="ricetta">Condividi
						la tua ricetta qui!</button></a>
			</div>
			<div class="right">
				<img id="market" class="image" src="/resources/img/Market2.svg">
			</div>
		</section>
	</div>
</body>
</html>