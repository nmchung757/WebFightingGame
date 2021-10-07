package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Developer;

/**
 * @author Noah Chung - nmchung
 * CIS175 - Fall 2021
 * Oct 7, 2021
 */
public class DeveloperHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("WebFightingGame");
	
	public void insertDeveloper(Developer d) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(d);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Developer> showAllDevelopers() {
		EntityManager em = emfactory.createEntityManager();
		List<Developer> allDevelopers = em.createQuery("SELECT d FROM Developer d").getResultList();
		return allDevelopers;
	}

	/**
	 * @param developerName
	 * @return
	 */
	public Developer findDeveloper(String nameToLookUp) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Developer> typedQuery = em.createQuery("select dev from Developer dev where dev.developerName = :selectedName", Developer.class);
		typedQuery.setParameter("selectedName", nameToLookUp);
		typedQuery.setMaxResults(1);
		
		Developer foundDeveloper;
		try {
			foundDeveloper = typedQuery.getSingleResult();
		} catch (NoResultException ex) {
			foundDeveloper = new Developer(nameToLookUp);
		}
		em.close();
		
		return foundDeveloper;
	}
}
