package com.adbansys.practica.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
//import java.util.Set;

//import javax.print.attribute.SetOfIntegerSyntax;

import com.adbansys.practica.conexion.Conexion;
import com.adbansys.practica.model.Cliente;

public class ClienteDAO {
	private Conexion con;
	private Statement stm;

	public ClienteDAO(String jdbcUrl, String jdbcUsername, String jdbcPassword) throws SQLException {
		con = new Conexion(jdbcUrl, jdbcUsername, jdbcPassword);
		con.conectar();
		// Imprime la liga de conexion en la consola
		// System.out.println(con.getJdbcConnection());
	}

	// Alta de un registro
	public boolean alta(Cliente a) throws SQLException {
		boolean estado = false;
		// Statement stm;

		String sql = "INSERT INTO registros VALUES (NULL,'" + a.getNombre() + "','" + a.getApellidopaterno() + "','"
				+ a.getApellidomaterno() + "','" + a.getCorreo() + "'," + a.getEdad() + ")";

		try {
			con.conectar();
			stm = con.getJdbcConnection().createStatement();
			stm.executeUpdate(sql);
			estado = true;
			stm.close();
			con.desconectar();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			estado = false;
		} finally {
			try {
				con.desconectar();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return estado;
	}

	// Editar un registro
	public boolean editar(Cliente a) throws SQLException {
		boolean estado = false;
		// Statement stm;

		String sql = "UPDATE registros SET nombre='" + a.getNombre() + "',apellidopaterno='" + a.getApellidopaterno()
				+ "',apellidomaterno='" + a.getApellidomaterno() + "',correo='" + a.getCorreo() + "',edad="
				+ a.getEdad() + " WHERE idregistros=" + a.getIdregistros();

		try {
			con.conectar();
			stm = con.getJdbcConnection().createStatement();
			stm.executeUpdate(sql);
			estado = true;
			stm.close();
			con.desconectar();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			estado = false;
		} finally {
			try {
				con.desconectar();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return estado;
	}

	// Eliminar un registro
	public void eliminar(int idRegistro) throws SQLException {
		String sql = "DELETE FROM registros WHERE idregistros=" + idRegistro;

		try {
			con.conectar();
			stm = con.getJdbcConnection().createStatement();
			stm.executeUpdate(sql);

			stm.close();
			con.desconectar();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				con.desconectar();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// listar registros
	public List<Cliente> listarRegistros() throws SQLException {
		// Statement stm;
		ResultSet res = null;
		List<Cliente> listaCliente = new ArrayList<>();
		con.conectar();
		stm = con.getJdbcConnection().createStatement();
		String sql = "SELECT * FROM registros";
		res = stm.executeQuery(sql);
		try {
			while (res.next()) {
				Cliente a = new Cliente();
				a.setIdregistros(res.getInt(1));
				a.setNombre(res.getString(2));
				a.setApellidopaterno(res.getString(3));
				a.setApellidomaterno(res.getString(4));
				a.setCorreo(res.getString(5));
				a.setEdad(res.getInt(6));
				listaCliente.add(a);
				// System.out.println(a);
			}

			stm.close();
			con.desconectar();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				con.desconectar();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return listaCliente;
	}

	// obtener ID
	public Cliente registroId(int idRegistro) throws SQLException {
		ResultSet res = null;
		Cliente p = new Cliente();
		try {
			con.conectar();
			stm = con.getJdbcConnection().createStatement();
			String sql = "SELECT * FROM registros WHERE idregistros=" + idRegistro;
			res = stm.executeQuery(sql);
			if (res.next()) {
				p.setIdregistros(res.getInt(1));
				p.setNombre(res.getString(2));
				p.setApellidopaterno(res.getString(3));
				p.setApellidomaterno(res.getString(4));
				p.setCorreo(res.getString(5));
				p.setEdad(res.getInt(6));
				// System.out.println(a);
			}

			stm.close();
			con.desconectar();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				con.desconectar();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return p;
	}
}
