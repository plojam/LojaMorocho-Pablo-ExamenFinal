package ec.edu.ups.controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.edu.ups.ejb.ClienteFacade;
import ec.edu.ups.ejb.ReservaFacade;
import ec.edu.ups.ejb.RestauranteFacade;
import ec.edu.ups.modelo.Cliente;
import ec.edu.ups.modelo.Reserva;
import ec.edu.ups.modelo.Restaurante;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@RequestScoped
public class ReservaControlador implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	private ClienteFacade ejbClienteFacade;
	
	@EJB
	private RestauranteFacade ejbRestauranteFacade;
	
	@EJB
	private ReservaFacade ejbReservaFacade;
	
	private String cedula="";
	private String nombreRes="";
	private int hora=0;
	private int minuto=0;
	private int dia=0;
	private int mes=0;
	private int anio=0;
	private int cantidad=0;
	private String mensajecli="";
	private String mensajeres="";
	private String mensaje="";
	private List<Integer> listHora;
	private List<Integer> listMinuto;
	private List<Integer> listDia;
	private List<Integer> listMes;
	private List<Integer> listAnio;
	
	@PostConstruct
	public void contructor() {
		listHora = new ArrayList<Integer>();
		listMinuto = new ArrayList<Integer>();
		listDia = new ArrayList<Integer>();
		listMes = new ArrayList<Integer>();
		listAnio = new ArrayList<Integer>();
		
		listMinuto.add(00);
		listMinuto.add(30);
		
		for(int i=7;i<23;i++) {
			listHora.add(i);
		}
		
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
	
	public void buscarCliente() {
		try {
			Cliente cli = ejbClienteFacade.buscarCedula(cedula);
			if(cli!=null) {
				
			}else {
				this.setMensajecli("El cliente no existe");
			}
		} catch (Exception e) {
			this.setMensajecli("No se pudo buscar el cliente");
		}
	}
	
	
	public void buscarRestaurante() {
		try {
			Restaurante res = ejbRestauranteFacade.buscarPorNombre(nombreRes);
			if(res!=null) {
				
			}else {
				this.setMensajeres("El restaurante no existe");
			}
		} catch (Exception e) {
			this.setMensajeres("No se pudo buscar el restaurante");
		}
	}
	
	public String crearReserva() {
		try {
			Cliente cli = ejbClienteFacade.buscarCedula(cedula);
			Restaurante res = ejbRestauranteFacade.buscarPorNombre(nombreRes);
			List<Reserva> reserva = ejbReservaFacade.reservaseClienteFecha(hora, minuto, dia, mes, anio, cedula);
			if(reserva.size()==0) {
				reserva = ejbReservaFacade.reservaseClienteRestaurante(nombreRes, dia, mes, anio, cedula);
				if(reserva.size()==0) {
					if(res.getAforo()>cantidad) {
						Reserva reser = new Reserva(0, hora, minuto, dia, mes, anio, cantidad, cli, res);
						ejbReservaFacade.create(reser);
						return "inicio";
					}else {
						this.setMensaje("El aforo es menor a la cantidad de gente");
						return "nada";
					}
					
				}else {
					this.setMensaje("Este cliente ya tiene una reservacion en este restaurante el mismo dia");
					return "nada";
				}
			}else {
				this.setMensaje("Este cliente ya tiene una reservacion a la misma hora");
				return "nada";
			}
			
		} catch (Exception e) {
			this.setMensaje("No se pudo crear la reserva");
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

	public RestauranteFacade getEjbRestauranteFacade() {
		return ejbRestauranteFacade;
	}

	public void setEjbRestauranteFacade(RestauranteFacade ejbRestauranteFacade) {
		this.ejbRestauranteFacade = ejbRestauranteFacade;
	}

	public ReservaFacade getEjbReservaFacade() {
		return ejbReservaFacade;
	}

	public void setEjbReservaFacade(ReservaFacade ejbReservaFacade) {
		this.ejbReservaFacade = ejbReservaFacade;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombreRes() {
		return nombreRes;
	}

	public void setNombreRes(String nombreRes) {
		this.nombreRes = nombreRes;
	}

	public int getHora() {
		return hora;
	}

	public void setHora(int hora) {
		this.hora = hora;
	}

	public int getMinuto() {
		return minuto;
	}

	public void setMinuto(int minuto) {
		this.minuto = minuto;
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

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getMensajecli() {
		return mensajecli;
	}

	public void setMensajecli(String mensajecli) {
		this.mensajecli = mensajecli;
	}

	public String getMensajeres() {
		return mensajeres;
	}

	public void setMensajeres(String mensajeres) {
		this.mensajeres = mensajeres;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public List<Integer> getListHora() {
		return listHora;
	}

	public void setListHora(List<Integer> listHora) {
		this.listHora = listHora;
	}

	public List<Integer> getListMinuto() {
		return listMinuto;
	}

	public void setListMinuto(List<Integer> listMinuto) {
		this.listMinuto = listMinuto;
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
