package ec.edu.ups.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.modelo.Cliente;

@Stateless
public class ClienteFacade extends AbstractFacade<Cliente> {
	
	public ClienteFacade() {
		super(Cliente.class);
	}

	@PersistenceContext(unitName = "LojaMorocho-Pablo-ExamenFinal")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}
	
	public Cliente buscarCedula(String cedula) {
		Cliente cli = null;
		try {
			String jpql = "SELECT c FROM Cliente c WHERE c.cedula='"+cedula+"'";
			cli = (Cliente) em.createQuery(jpql).getSingleResult();
			return cli;
		} catch (Exception e) {
			return null;
		}
		
	}
	
}
