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
			<a style="color:#fff;"href="index_2.jsp?#" title="Crea tu cuenta">Crea tu cuenta</a>
			</span>
		</div>
		<div class="formulario">
			<h1>Bienvenido a la tienda virtual</h1>
			<h2>Iniciar sesión</h2>
			<form method = "get" action="./servletInicio">
				<input type="text" name ="txtusuario" placeholder = "Usuario"  class="form-control" required>
				<input type="password" name = "txtpassword" placeholder="Password"  class="form-control" required>
				<input type="submit" name = "accion" value="Ingresar">
			</form>
		</div>
		
		<div class="reset-password">
			<a href="#">Olvide mi contraseña</a>
		</div>
	</div>
	
</body>
</html>