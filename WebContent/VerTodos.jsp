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
<title>Ver todos</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>
	<table class="table">
		<thead class="thead-dark">
			<tr>
				<th class="text-center" scope="col">Código</th>
				<th class="text-center" scope="col">Descripción</th>
				<th class="text-center" scope="col">Precio/Unitario</th>
				<th class="text-center" scope="col">Delete</th>
			</tr>
		</thead>
		<%
			ProductoDaoImplMysql dao = new ProductoDaoImplMysql();
		List<Producto> list = dao.findAll();
		Iterator<Producto> iter = list.iterator();
		Producto pro = null;
		while (iter.hasNext()) {
			pro = iter.next();
		%>
		<tbody>
			<tr>
				<td class="text-center"><%=pro.getCodigo()%></td>
				<td class="text-center"><%=pro.getDescripcion()%></td>
				<td class="text-center"><%=pro.getPrecioUnitario()%></td>
				<td class="text-center"><a class="btn btn-danger "
					href="GestionProductos?opcion=eliminar&codigo=<%=pro.getCodigo()%>"
					type="submit">Delete</a></td>
			</tr>
			<%
				}
			%>

		</tbody>
	</table>
	<div class="form-group text-center">
		<div class="col-sm-offset-2 col-md-8">
			<a class="btn btn-success  col-md-2" href="Productos.jsp"
				role="button">Volver</a>

		</div>
	</div>
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