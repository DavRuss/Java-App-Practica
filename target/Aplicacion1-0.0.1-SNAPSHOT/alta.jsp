<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alta</title>
</head>
<script type="text/javascript"> 
 function confirmacion() {
	 Swal.fire('Any fool can use a computer')
 }
</script>
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
<body>
	<h2 align="center"><font face="nunito,arial,verdana" color="black" size="32">Alta de Usuarios</font></h2>
	<form action="serv" method="post">
	<input type="hidden" name="opcion" value="guardar">
		<table cellspacing="0" cellpadding="2" border="2" width="300" align="center">
			<tr>
				<td align="right" bgcolor="skyblue">Nombre: </td>
				<td width="100" ><input type="text" name="nombre"></td>
			</tr>
			<tr>
				<td align="right" bgcolor="skyblue">Apellido Paterno: </td>
				<td width="100"><input type="text" name="apellidopaterno"></td>
			</tr>
			<tr>
				<td align="right" bgcolor="skyblue">Apellido Materno: </td>
				<td width="100"><input type="text" name="apellidomaterno"></td>
			</tr>
			<tr>
				<td align="right" bgcolor="skyblue">Correo: </td>
				<td width="100"><input type="text" name="correo"></td>
			</tr>
			<tr>
				<td align="right" bgcolor="skyblue">Edad: </td>
				<td width="100"><input type="text" name="edad"></td>
			</tr>
			<tr>
				<th colspan="2">
				<input type="submit" name="btnGrabar"value="Grabar Usuario"></th>
			</tr>
		</table>
		<table align="center">
		<tr>
		<th><a href="serv?opcion=listar">Lista</a></th>
		</tr>
		</table>
	</form>
	<button onclick="confirmacion()" id="btnPruebaId" name="btnPrueba" >Prueba</button>
	</body>
</html>