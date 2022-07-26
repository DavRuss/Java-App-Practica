package com.adbansys.practica.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class Conexion {
	private Connection jdbcConnection;
	private String jdbcUrl;
	private String jdbcUsername;
	private String jdbcPassword;
	
	public Conexion(String jdbcUrl, String jdbcUsername, String jdbcPassword) {
		this.jdbcUrl = jdbcUrl;
		this.jdbcUsername = jdbcUsername;
		this.jdbcPassword = jdbcPassword;
	}
	
	public void conectar() throws SQLException {
		if (jdbcConnection==null || jdbcConnection.isClosed()) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");			
			} catch (ClassNotFoundException e) {
				throw new SQLException(e);
			}
		}
		jdbcConnection=DriverManager.getConnection(jdbcUrl,jdbcUsername,jdbcPassword);
	}
	
	public void desconectar() throws SQLException {
		if (jdbcConnection !=null && !jdbcConnection.isClosed()) {
			jdbcConnection.close();
		}
	}
	
	public Connection getJdbcConnection() {
		return jdbcConnection;
	}
}
