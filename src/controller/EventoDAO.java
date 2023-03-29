package controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Eventi;
import model.TipoEvento;





public class EventoDAO {
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("JAVA-U1-W3-D3");
	static EntityManager em = emf.createEntityManager();
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		Eventi e = new Eventi();
		e.setTitolo("Evento 3");
		e.setDescrizione("Evento 3 Description");
		e.setTipoEvento(TipoEvento.PUBBLICO);
		e.setDataEvento(LocalDate.of(2022,8,3));
		e.setNumeroMassimoPartecipanti(1250);
		
		
		try {
			save(e);
				
			//Eventi eventoLetto = getById(2l);
			//System.out.println(eventoLetto);
			//eventoLetto.setDescrizione("descrizione modificata");
			//updateEvent(eventoLetto);
			//delete(eventoLetto);
			//List <Eventi> lista = findAll();
			//lista.forEach(ut -> System.out.println(ut));
			
			} catch (Exception exc) {
				exc.printStackTrace();
			} finally {
				em.close();
				emf.close();
			}
	}
	
	
	public static void save(Eventi e) {
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit(); 
		System.out.println("Evento salvato nel DB!");
	}
	public static Eventi getById (Long id) {
		em.getTransaction().begin();
		Eventi e = em.find(Eventi.class, id);
		
		em.getTransaction().commit();
		return e;
	}
	public static void delete(Eventi e) {
		em.getTransaction().begin();
		em.remove(e);
		em.getTransaction().commit();
		System.out.println("Evento cancellato");
	}
	public static void updateEvent (Eventi e) {
		em.getTransaction().begin();
		em.merge(e);
		em.getTransaction().commit();
		System.out.println("Evento modificato");
	}
	public static List<Eventi> findAll () {
		Query q = em.createNamedQuery("Eventi.findAll");
		return q.getResultList();
	}


}
