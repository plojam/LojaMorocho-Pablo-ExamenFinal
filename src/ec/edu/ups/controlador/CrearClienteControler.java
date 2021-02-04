package ec.edu.ups.controlador;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.edu.ups.ejb.ClienteFacade;
import ec.edu.ups.modelo.Cliente;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@RequestScoped
public class CrearClienteControler implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	private ClienteFacade ejbClienteFacade;
	
	private String nombre="";
	private String apellido="";
	private String cedula="";
	private String correo="";
	private String direccion="";
	private String telefono="";
	private String mensaje="";
	
	public String crearCliente() {
		try {
			Cliente cli = ejbClienteFacade.buscarCedula(cedula);
			if(cli==null) {
				cli = new Cliente(0, nombre, apellido, cedula, correo, direccion, telefono);
				ejbClienteFacade.create(cli);
				return "inicio";
			}else {
				this.setMensaje("Ya existe un usuario con esta cedula");
				return "nada";
			}
		} catch (Exception e) {
			this.setMensaje("No se pudo crear al usuario");
			return "nada";
		}
	}
	
	public String salir() {
		return "inicio";
	}

	public ClienteFacade getEjbClienteFacade() {
		return ejbClienteFacade;
	}

	public void setEjbClienteFacade(ClienteFacade ejbClienteFacade) {
		this.ejbClienteFacade = ejbClienteFacade;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	
	
}
