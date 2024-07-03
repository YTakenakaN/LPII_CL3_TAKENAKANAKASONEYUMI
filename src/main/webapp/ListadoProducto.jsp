
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page import="java.util.*"  %>
<%@page import="model.TblProductocl3" %>

<!DOCTYPE htm>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listado de Productos</title>
</head>
<body bgcolor="c5dec9">
<h1 align="center">Listado de Productos Registrados en BD</h1>

<h2 align="center">
<a href="FormRegistrarProductocl3.jsp" style="text-decoration:none; color=blue">Registrar Producto</a>
</h2>


<table border="2" align="center">

<tr>
	<td>Id</td>
	<td>Nombre</td>
	<td>Precio venta</td>
	<td>Precio compra</td>
	<td>Estado</td>
	<td>Descripción</td>
	<td colspan="2" align="center">Acciones</td>
</tr>


<%
	List<TblProductocl3> listadoproducto=(List<TblProductocl3>)request.getAttribute("listadodeproductos");
	//Condición si el listado no es vacio
	if(listadoproducto!=null){
		//aplicammos un bucle for
		for(TblProductocl3 list:listadoproducto){
			%>
				<tr>
					<td><%=list.getIdproductoscl3()%></td>
					<td><%=list.getNombrecl3()%></td>		
					<td><%=list.getPrecioventacl3()%></td>
					<td><%=list.getPreciocompcl3()%></td>
					<td><%=list.getEstadocl3()%></td>
					<td><%=list.getDescripcl3()%></td>
				
				<td><a href="ControladorProductoCl3?accion=Modificar&idproductoscl3=<%=list.getIdproductoscl3() %>">Actualizar</a></td>				
				<td><a href="ControladorProductoCl3?accion=Eliminar&idproductoscl3=<%=list.getIdproductoscl3() %>">Eliminar</a></td>
				</tr>
		<% 		
		}//fin del bucle for
		%>
		<%
	}//fin de la condición
	
%>

</table>
</body>
</html>
