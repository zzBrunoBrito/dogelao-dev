package dao.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Fabrica {

	private static EntityManagerFactory factory = 
			Persistence.createEntityManagerFactory("fjn");

	private Fabrica() {
	}

	public static EntityManager getEntityManager() {
		return factory.createEntityManager();
	}

	public static void fecharFabrica() {
		factory.close();
	}

}