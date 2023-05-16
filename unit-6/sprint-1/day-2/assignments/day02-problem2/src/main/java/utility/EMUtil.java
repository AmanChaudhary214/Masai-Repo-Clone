package utility;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMUtil {

	public static final EntityManagerFactory emf;

	static {
		emf = Persistence.createEntityManagerFactory("masaiUnit");
	}

	public static EntityManager provideEntityManager() {
		return emf.createEntityManager();
	}

}
