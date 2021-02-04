package ec.edu.ups.controlador;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@RequestScoped
public class InicioControler implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public String cliente() {
		return "cliente";
	}
	
	public String restaurante() {
		return "restaurante";
	}
	
	
	public String reserva() {
		return "reserva";
	}
	
	public String resCliente() {
		return "resCliente";
	}
	
	public String resRestaurante() {
		return "resRestaurante";
	}
	
	
}
