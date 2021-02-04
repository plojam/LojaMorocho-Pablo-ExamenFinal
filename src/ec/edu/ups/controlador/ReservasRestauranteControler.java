package ec.edu.ups.controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.edu.ups.ejb.ReservaFacade;
import ec.edu.ups.ejb.RestauranteFacade;
import ec.edu.ups.modelo.Reserva;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@RequestScoped
public class ReservasRestauranteControler implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	private ReservaFacade ejbReservaFacade;
	
	@EJB
	private RestauranteFacade ejbRestauranteFacade;
	
	private String nombreRes;
	private int dia;
	private int mes;
	private int anio;
	private List<Integer> listDia;
	private List<Integer> listMes;
	private List<Integer> listAnio;
	private List<Reserva> reservas = new ArrayList<Reserva>();
	
	@PostConstruct
	public void contructor() {
		listDia = new ArrayList<Integer>();
		listMes = new ArrayList<Integer>();
		listAnio = new ArrayList<Integer>();
		
		for(int i=1;i<32;i++) {
			listDia.add(i);
		}
		
		for(int i=1;i<13;i++) {
			listMes.add(i);
		}
		
		for(int i=2021; i<2031; i++) {
			listAnio.add(i);
		}
		
	}
	
	
	public void listar() {
		try {
			List<Reserva> reservasList = ejbReservaFacade.reservaseRestauranteFecha(nombreRes, dia, mes, anio);
			this.setReservas(reservasList);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public String salir() {
		return "inicio";
	}
	
	
	public ReservaFacade getEjbReservaFacade() {
		return ejbReservaFacade;
	}
	public void setEjbReservaFacade(ReservaFacade ejbReservaFacade) {
		this.ejbReservaFacade = ejbReservaFacade;
	}
	public RestauranteFacade getEjbRestauranteFacade() {
		return ejbRestauranteFacade;
	}
	public void setEjbRestauranteFacade(RestauranteFacade ejbRestauranteFacade) {
		this.ejbRestauranteFacade = ejbRestauranteFacade;
	}
	public String getNombreRes() {
		return nombreRes;
	}
	public void setNombreRes(String nombreRes) {
		this.nombreRes = nombreRes;
	}
	public int getDia() {
		return dia;
	}
	public void setDia(int dia) {
		this.dia = dia;
	}
	public int getMes() {
		return mes;
	}
	public void setMes(int mes) {
		this.mes = mes;
	}
	public int getAnio() {
		return anio;
	}
	public void setAnio(int anio) {
		this.anio = anio;
	}
	public List<Reserva> getReservas() {
		return reservas;
	}
	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}


	public List<Integer> getListDia() {
		return listDia;
	}


	public void setListDia(List<Integer> listDia) {
		this.listDia = listDia;
	}


	public List<Integer> getListMes() {
		return listMes;
	}


	public void setListMes(List<Integer> listMes) {
		this.listMes = listMes;
	}


	public List<Integer> getListAnio() {
		return listAnio;
	}


	public void setListAnio(List<Integer> listAnio) {
		this.listAnio = listAnio;
	}
	
	
	
	
}
