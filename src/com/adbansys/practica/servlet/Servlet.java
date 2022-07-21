package com.adbansys.practica.servlet;

//import java.awt.List;
import java.io.IOException;
//import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
//import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.adbansys.practica.dao.ClienteDAO;
import com.adbansys.practica.model.Cliente;
//import com.mysql.cj.xdevapi.Client;
//import com.google.protobuf.Internal.ListAdapter;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/serv")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ClienteDAO client;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Servlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
		String jdbcUrl = getServletContext().getInitParameter("jdbcUrl");
		String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
		// System.out.println(jdbcUrl);
		try {
			client = new ClienteDAO(jdbcUrl, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String opcion = request.getParameter("opcion");
		if (opcion.equals("listar")) {
			List<Cliente> lista = new ArrayList<>();
			try {
				lista = client.listarRegistros();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("lista", lista);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/listar.jsp");
			requestDispatcher.forward(request, response);
		}

		else if (opcion.equals("editar")) {
			int id = Integer.parseInt(request.getParameter("id"));
			Cliente p = new Cliente();
			try {
				p = client.registroId(id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("cliente", p);
			RequestDispatcher requestDispatcher1 = request.getRequestDispatcher("/editar.jsp");
			requestDispatcher1.forward(request, response);

		} else if (opcion.equals("eliminar")) {
			int id = Integer.parseInt(request.getParameter("id"));
			try {
				client.eliminar(id);
				RequestDispatcher requestDispatcher1 = request.getRequestDispatcher("/index.jsp");
				requestDispatcher1.forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String opcion = request.getParameter("opcion");
		if (opcion.equals("guardar")) {

			Cliente cliente = new Cliente();
			cliente.setNombre(request.getParameter("nombre"));
			cliente.setApellidopaterno(request.getParameter("apellidopaterno"));
			cliente.setApellidomaterno(request.getParameter("apellidomaterno"));
			cliente.setCorreo(request.getParameter("correo"));
			cliente.setEdad(Integer.parseInt(request.getParameter("edad")));
			try {
				client.alta(cliente);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
			requestDispatcher.forward(request, response);

		} else if (opcion.equals("editar")) {
			Cliente cliente = new Cliente();
			cliente.setIdregistros(Integer.parseInt(request.getParameter("id")));
			cliente.setNombre(request.getParameter("nombre"));
			cliente.setApellidopaterno(request.getParameter("apellidopaterno"));
			cliente.setApellidomaterno(request.getParameter("apellidomaterno"));
			cliente.setCorreo(request.getParameter("correo"));
			cliente.setEdad(Integer.parseInt(request.getParameter("edad")));
			try {
				client.editar(cliente);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
			requestDispatcher.forward(request, response);
		}

		// doGet(request, response);

	}
}
