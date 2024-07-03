<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registrar Producto</title>
</head>
<body bgcolor="#c5dec9">
<h1 align="center">Registrar Producto</h1>
<form action="ControladorProductoCl3" method="post">
<table align="center"  border="2" >

<tr>
<td>Nombre</td>
<td><input type="text" name="nombrecl3"></td>
</tr>

<tr>
<td>Precio Venta</td>
<td><input type="number" name="precioventacl3"></td>
</tr>

<tr>
<td>Precio Compra</td>
<td><input type="number" name="preciocompcl3"></td>
</tr>

<tr>
<td>Estado</td>
<td><input type="text" name="estadocl3"></td>
</tr>

<tr>
<td>Descripción</td>
<td><input type="text" name="descripcl3"></td>
</tr>


<td colspan="2" align="center">
<input type="submit" value="Registrar Producto">
</td>
</table>

</form>

<a align="center" href="ControladorProductoCl3">Atrás</a>
</body>
</html>