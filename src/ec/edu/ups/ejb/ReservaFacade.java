package ec.edu.ups.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.modelo.Cliente;
import ec.edu.ups.modelo.Reserva;

@Stateless
public class ReservaFacade extends AbstractFacade<Reserva> {
	
	public ReservaFacade() {
		super(Reserva.class);
	}
	
	@PersistenceContext(unitName = "LojaMorocho-Pablo-ExamenFinal")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}
	
	public List<Reserva> reservaseRestauranteFecha(String nombre, int dia, int mes, int anio){
		String jpql = "SELECT r FROM Reserva r WHERE r.dia="+dia+" AND r.mes="+mes+" AND r.anio="+anio+" AND r.restaurante.nombre='"+nombre+"'";
		List<Reserva> res = em.createQuery(jpql).getResultList();
		return res;
	}
	
	public List<Reserva> reservaseClienteRestaurante(String nombre, int dia, int mes, int anio, String cedula){
		try {
			String jpql = "SELECT r FROM Reserva r WHERE r.dia="+dia+" AND r.mes="+mes+" AND r.anio="+anio+" AND r.restaurante.nombre='"+nombre+"' AND r.cliente.cedula='"+cedula+"'";
			List<Reserva> res = em.createQuery(jpql).getResultList();
			return res;
		} catch (Exception e) {
			return new ArrayList<Reserva>();
		}
		
	}
	
	public List<Reserva> reservaseClienteFecha(int hora, int minuto, int dia, int mes, int anio, String cedula){
		try {
			String jpql = "SELECT r FROM Reserva r WHERE r.dia="+dia+" AND r.mes="+mes+" AND r.anio="+anio+" AND r.hora="+hora+" AND r.minuto="+minuto+" AND r.cliente.cedula='"+cedula+"'";
			List<Reserva> res = em.createQuery(jpql).getResultList();
			return res;
		} catch (Exception e) {
			return new ArrayList<Reserva>();
		}
		
	}
	
	public List<Reserva> reservaseCliente(String cedula){
		try {
			String jpql = "SELECT r FROM Reserva r WHERE r.cliente.cedula='"+cedula+"'";
			List<Reserva> res = em.createQuery(jpql).getResultList();
			return res;
		} catch (Exception e) {
			return new ArrayList<Reserva>();
		}
		
	}
	
}
