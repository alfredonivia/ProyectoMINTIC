<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Crea tu cuenta</title>
<link rel="stylesheet" href="estilos.css">
</head>
<body>
	<div class="contenedor-form">
			<h2>Crea tu cuenta</h2>
			<form method = "get" action="../servletInicio">
				<input type="text" placeholder="Cedula" required>
				<input type="text" placeholder="Usuario" required>
				<input type="text" placeholder="Nombre" required>
				<input type="password" placeholder="Password" required>
				<input type="email" placeholder="Email" required>
				<input type="submit" value="Registrarse">
			</form>
		</div>

</body>
</html>