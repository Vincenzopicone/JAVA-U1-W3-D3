package controller;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Eventi;




public class EventoDAO {
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("JAVA-U1-W3-D3");
	static EntityManager em = emf.createEntityManager();
	
	public static void main(String[] args) {
		
		Eventi e = new Eventi();
		e.setTitolo("Evento 1");
		e.setDescrizione("Evento 1 Description");
		e.setTipoEvento("public");
		e.setDataEvento(LocalDate.of(2023, 2, 3));
		e.setNumeroMassimoPartecipanti(500);
		
		
		try {
			addEventi(e);
			
			
			} catch (Exception exc) {
				exc.printStackTrace();
			} finally {
				em.close();
				emf.close();
			}
	}
	
	
	public static void addEventi(Eventi e) {
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit(); 
		System.out.println("Evento salvato nel DB!");
	}


}
