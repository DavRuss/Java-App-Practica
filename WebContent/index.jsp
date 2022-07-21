<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Menu Principal</title>
</head>
<style>
      /* unvisited link */
      a:link {
        color: #095484;
      }
      /* visited link */
      a:visited {
        color: #095484;
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
<h1 align="center"><font face="nunito,arial,verdana" color="black" size="32">Menu Principal</font></h1>
<body>
<table align="center" border="1" width="400">
	<tr bgcolor="skyblue">
		<th><a href="alta.jsp">Alta</a></th>
		<th><a href="serv?opcion=listar">Lista</a></th>
	</tr>
	<tr>
	<td align="center">Agrega un nuevo registro </td>
	<td align="center">Ver los registros y realizar cambios</td>
	</tr>
</table>
</body>
</html>