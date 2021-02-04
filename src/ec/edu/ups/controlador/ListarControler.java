package ec.edu.ups.controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.edu.ups.ejb.ClienteFacade;
import ec.edu.ups.ejb.ReservaFacade;
import ec.edu.ups.modelo.Cliente;
import ec.edu.ups.modelo.Reserva;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@RequestScoped
public class ListarControler implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	private ReservaFacade ejbReservaFacade;
	
	@EJB
	private ClienteFacade ejbClienteFacade;
	
	private String cedula;
	private List<Reserva> reservas = new ArrayList<Reserva>();
	
	public void listarReservas() {
		try {
			Cliente cli = ejbClienteFacade.buscarCedula(cedula);
			this.setReservas(cli.getReservas());
		} catch (Exception e) {
			
		}
	}
	
	public String salir() {
		return "inicio";
	}
	
	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public ReservaFacade getEjbReservaFacade() {
		return ejbReservaFacade;
	}

	public void setEjbReservaFacade(ReservaFacade ejbReservaFacade) {
		this.ejbReservaFacade = ejbReservaFacade;
	}

	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	public ClienteFacade getEjbClienteFacade() {
		return ejbClienteFacade;
	}

	public void setEjbClienteFacade(ClienteFacade ejbClienteFacade) {
		this.ejbClienteFacade = ejbClienteFacade;
	}
	
	
	
	
}
