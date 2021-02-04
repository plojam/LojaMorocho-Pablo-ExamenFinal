package ec.edu.ups.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.modelo.Restaurante;

@Stateless
public class RestauranteFacade extends AbstractFacade<Restaurante> {
	
	public RestauranteFacade() {
		super(Restaurante.class);
	}
	
	@PersistenceContext(unitName = "LojaMorocho-Pablo-ExamenFinal")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}
	
	public Restaurante buscarPorNombre(String nombre) {
		Restaurante restaurante = null;
		try {
			String jpql = "SELECT r FROM Restaurante r WHERE r.nombre='"+nombre+"'";
			restaurante = (Restaurante) em.createQuery(jpql).getSingleResult();
			return restaurante;
		} catch (Exception e) {
			return null;
		}
		
	}
	
	
}
