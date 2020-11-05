<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="modelo.daos.ProductoDaoImplMysql"%>
<%@page import="java.util.Iterator"%>
<%@page import="modelo.beans.Producto"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Productos</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>
	<form class="form-horizontal" action="GestionProductos">
		<h1 class="text-center">Bienvenido ahora puedes ingresar un
			producto</h1>

		<%
			String mensaje = (String) request.getAttribute("mensaje");
		if (mensaje != null) {
		%>
		<h3 style="color: red;"><%=mensaje%></h3>
		<%
			}
		%>

		<br />

		<div class="form-group ">
			<label class="control-label col-sm-2" for="email">Descripción:</label>
			<div class="col-md-6 text-center">
				<input type="text" class="form-control text-center" maxlength="45"
					style="margin-left: 13%;" name="textdescripcion"
					placeholder="Manzana">
			</div>
		</div>
		<div class="form-group ">
			<label class="control-label col-sm-4" for="pwd">Precio
				unitario:</label>
			<div class="col-md-4 text-center">
				<input type="text" class="form-control text-center"
					style="margin-left: 20%;" name="textprecio" maxlength="7"
					placeholder="3.5">
			</div>
		</div>

		<input class="btn btn-primary text-center" style="margin-left: 20%"
			type="submit" name="opcion" value="Agregar"> <a
			class="btn btn-primary text-center"
			href="GestionProductos?opcion=VerTodos" role="button">Todos</a>
		<div class="form-group">
			<label class="control-label col-sm-2 " for="inputPassword6">Código:</label>
			<div class="col-md-4 text-center">
				<input type="text" class="form-control text-center"
					style="margin-left: 20%;" name="codigo" maxlength="8"
					placeholder="123">
			</div>
		</div>
		<input class="btn btn-dark text-center" style="margin-left: 20%"
			type="submit" name="opcion" value="consultar">

	</form>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</body>
</html>