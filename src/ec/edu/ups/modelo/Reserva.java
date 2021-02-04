package ec.edu.ups.modelo;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Reserva
 *
 */
@Entity

public class Reserva implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int hora;
	private int minuto;
	private int dia;
	private int mes;
	private int anio;
	private int cantidad;
	
	@ManyToOne
	@JoinColumn
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn
	private Restaurante restaurante;
	
	public Reserva(int id, int hora, int minuto, int dia, int mes, int anio, int cantidad, Cliente cliente, Restaurante restaurante) {
		this.setId(id);
		this.setHora(hora);
		this.setMinuto(minuto);
		this.setDia(dia);
		this.setMes(mes);
		this.setAnio(anio);
		this.setCantidad(cantidad);
		this.setCliente(cliente);
		this.setRestaurante(restaurante);
	}
	
	public Reserva() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Restaurante getRestaurante() {
		return restaurante;
	}

	public void setRestaurante(Restaurante restaurante) {
		this.restaurante = restaurante;
	}
	
	
	
   
}
