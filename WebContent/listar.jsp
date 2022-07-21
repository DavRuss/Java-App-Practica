<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<title>Lista</title>
</head>
<style>
/* unvisited link */
a:link {
	color: #A9F5F2;
}
/* visited link */
a:visited {
	color: #A9F5F2;
}
/* mouse over link */
a:hover {
	color: #8ebf42;
}
/* selected link */
a:active {
	color: #800000;
}
</style>
<body>
	<h2 align="center">
		<font face="nunito,arial,verdana" color="black" size="32">Usuarios</font>
	</h2>
	<p align="center">
		<font face="nunito,arial,verdana" color="black" size="3">Para
			editar seleccione el ID del usuario</font>
	</p>
	<p align="center">
		<font face="nunito,arial,verdana" color="black" size="3">Para
			quitar un usuario permanentemente seleccione la opcion eliminar</font>
	</p>
	<table align="center" cellspacing="0" cellpadding="2" border="2"
		width="600">
		<tr bgcolor="skyblue">
			<td><font face="verdana" color="#220A29" size="2">ID</font></td>
			<td><font face="verdana" color="#220A29" size="2">Nombre</font></td>
			<td><font face="verdana" color="#220A29" size="2">Apellido
					Paterno</font></td>
			<td><font face="verdana" color="#220A29" size="2">Apellido
					Materno</font></td>
			<td><font face="verdana" color="#220A29" size="2">Correo</font></td>
			<td><font face="verdana" color="#220A29" size="2">Edad</font></td>
		</tr>
		<c:forEach var="client" items="${lista}">
			<tr bgcolor="purple">
				<td><a
					href="serv?opcion=editar&id=<c:out value="${client.idregistros}"></c:out>"><c:out
							value="${client.idregistros}"></c:out></a></td>
				<td><font face="nunito,arial,verdana" color="white" size="3"><c:out
							value="${client.nombre}"></c:out></font></td>
				<td><font face="nunito,arial,verdana" color="white" size="3"><c:out
							value="${client.apellidopaterno}"></c:out></font></td>
				<td><font face="nunito,arial,verdana" color="white" size="3"><c:out
							value="${client.apellidomaterno}"></c:out></font></td>
				<td><font face="nunito,arial,verdana" color="white" size="3"><c:out
							value="${client.correo}"></c:out></font></td>
				<td><font face="nunito,arial,verdana" color="white" size="3"><c:out
							value="${client.edad}"></c:out></font></td>
				<td><a
					href="serv?opcion=eliminar&id=<c:out value="${client.idregistros}"></c:out>">
						<button>Eliminar</button></a></td>
			</tr>
		</c:forEach>
	</table>
	<table>
	<tr></tr>
	</table>
	<center>
	<a href="index.jsp">
		<button>Menu</button>
	</a>
	</center>
</body>
</html>