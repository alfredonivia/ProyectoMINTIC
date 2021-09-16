<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="estilos.css">
</head>
<body>
	<div class="contenedor-form">
		<div class="toggle">
			<span>
			<a style="color:#fff;"href="http://localhost:8080/TiendaVirtual/JSP/index_2.jsp?#" title="Crea tu cuenta">Crea tu cuenta</a>
			</span>
		</div>
		<div class="formulario">
			<h1>Bienvenido a la tienda virtual</h1>
			<h2>Iniciar sesión</h2>
			<form action="#">
				<input type="text" placeholder="Usuario" required>
				<input type="password" placeholder="Contraseña" required>
				<input type="submit" value="Iniciar Sesión">
			</form>
		</div>
		
		
		
		<div class="reset-password">
			<a href="#">Olvide mi contraseña</a>
		</div>
	</div>
	
</body>
</html>