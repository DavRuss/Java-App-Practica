package com.adbansys.practica.model;

public class Cliente {
	private int idregistros;
	private String nombre;
	private String apellidopaterno;
	private String apellidomaterno;
	private String correo;
	private int edad;
	
	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	public Cliente(int idregistros, String nombre, String apellidopaterno, String apellidomaterno, String correo,
			int edad) {
		super();
		this.idregistros = idregistros;
		this.nombre = nombre;
		this.apellidopaterno = apellidopaterno;
		this.apellidomaterno = apellidomaterno;
		this.correo = correo;
		this.edad = edad;
	}

	public int getIdregistros() {
		return idregistros;
	}

	public void setIdregistros(int idregistros) {
		this.idregistros = idregistros;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidopaterno() {
		return apellidopaterno;
	}

	public void setApellidopaterno(String apellidopaterno) {
		this.apellidopaterno = apellidopaterno;
	}

	public String getApellidomaterno() {
		return apellidomaterno;
	}

	public void setApellidomaterno(String apellidomaterno) {
		this.apellidomaterno = apellidomaterno;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	@Override
	public String toString() {
		return "Cliente [idregistros=" + idregistros + ", nombre=" + nombre + ", apellidopaterno=" + apellidopaterno
				+ ", apellidomaterno=" + apellidomaterno + ", correo=" + correo + ", edad=" + edad + "]";
	}
	
	

}
