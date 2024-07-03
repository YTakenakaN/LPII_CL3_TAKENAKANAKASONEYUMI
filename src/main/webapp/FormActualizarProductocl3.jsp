<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="model.TblProductocl3" %>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Actualizar Producto</title>
</head>
<body bgcolor="#c5dec9">
<h1 align="center">Actualizar Producto</h1>

<form method="post" action="ControladorProductoCl3">

<%
	String idproductoscl3=request.getAttribute("idproductoscl3").toString();
	String nombrecl3=(request.getAttribute("nombrecl3")!=null)?request.getAttribute("nombrecl3").toString():"";
	String precioventacl3=(request.getAttribute("precioventacl3")!=null)?request.getAttribute("precioventacl3").toString():"";
	String preciocompcl3=(request.getAttribute("preciocompcl3")!=null)?request.getAttribute("preciocompcl3").toString():"";
	String estadocl3=(request.getAttribute("estadocl3")!=null)?request.getAttribute("estadocl3").toString():"";
	String descripcl3=(request.getAttribute("descripcl3")!=null)?request.getAttribute("descripcl3").toString():"";
%>

<table align="center" border="2">
<tr>
<td>
<input type="hidden" name="idproductoscl3" value="<%=idproductoscl3%>">
</td>
</tr>

<tr>
<td>Nombre</td>
<td>
<input type="text" name="nombrecl3" value="<%=nombrecl3%>">
</td>
</tr>

<tr>
<td>Precio de venta</td>
<td>
<input type="text" name="precioventacl3" value="<%=precioventacl3%>">
</td>
</tr>

<tr>
<td>Precio de compra</td>
<td><input type="text" name="preciocompcl3" value="<%=preciocompcl3%>"></td>
</tr>

<tr>
<td>Estado</td>
<td><input type="text" name="estadocl3" value="<%=estadocl3%>"></td>
</tr>

<tr>
<td>Descripción</td>
<td><input type="text" name="descripcl3" value="<%=descripcl3%>"></td>
</tr>


<td colspan="2" align="center">
<input type="submit" value="Actualizar Producto">
</td>
</table>

</form>

</body>
</html>
