package com.skillnet.Converter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ClientConverter {

    private int nit;
    private String razonsocial;
    private String correo;
    private String telefono;
    private String usuario;
    
	public ClientConverter() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ClientConverter(int nit, String razonsocial, String correo, String telefono, String usuario) {
		super();
		this.nit = nit;
		this.razonsocial = razonsocial;
		this.correo = correo;
		this.telefono = telefono;
		this.usuario = usuario;
	}




	public int getNit() {
		return nit;
	}




	public void setNit(int nit) {
		this.nit = nit;
	}




	public String getRazonsocial() {
		return razonsocial;
	}




	public void setRazonsocial(String razonsocial) {
		this.razonsocial = razonsocial;
	}




	public String getCorreo() {
		return correo;
	}




	public void setCorreo(String correo) {
		this.correo = correo;
	}




	public String getTelefono() {
		return telefono;
	}




	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}




	public String getUsuario() {
		return usuario;
	}




	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}




	@Override
	public String toString() {
		return "Value [nit=" + nit + ", razonsocial=" + razonsocial + ", correo=" + correo + ", telefono=" + telefono
				+ ", usuario=" + usuario + "]";
	}
    
}