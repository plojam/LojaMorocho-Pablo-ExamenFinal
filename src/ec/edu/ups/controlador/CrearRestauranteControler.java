package ec.edu.ups.controlador;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.edu.ups.ejb.RestauranteFacade;
import ec.edu.ups.modelo.Restaurante;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@RequestScoped
public class CrearRestauranteControler  implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	private RestauranteFacade ejbRestauranteFacade;
	
	private String nombre="";
	private String direccion="";
	private String telefono="";
	private int aforo=0;
	private String mensaje="";
	
	public String crearRestaurante() {
		try {
			Restaurante res = ejbRestauranteFacade.buscarPorNombre(nombre);
			
			if(res==null) {
				res = new Restaurante(0, nombre, direccion, telefono, aforo);
				ejbRestauranteFacade.create(res);
				return "inicio";
			}else {
				this.setMensaje("Ya existe un restaurante con este nombre");
				return "nada";
			}
			
		} catch (Exception e) {
			this.setMensaje("No se pudo crear el restaurante");
			return "nada";
		}
	}
	
	
	public String salir() {
		return "inicio";
	}


	public RestauranteFacade getEjbRestauranteFacade() {
		return ejbRestauranteFacade;
	}


	public void setEjbRestauranteFacade(RestauranteFacade ejbRestauranteFacade) {
		this.ejbRestauranteFacade = ejbRestauranteFacade;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
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


	public int getAforo() {
		return aforo;
	}


	public void setAforo(int aforo) {
		this.aforo = aforo;
	}


	public String getMensaje() {
		return mensaje;
	}


	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	
	
	
	
}
