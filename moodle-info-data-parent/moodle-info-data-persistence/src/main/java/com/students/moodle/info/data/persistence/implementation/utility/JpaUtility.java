package com.students.moodle.info.data.persistence.implementation.utility;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public final class JpaUtility {
	private static EntityManagerFactory emFactory;

	private JpaUtility() {

	}

	public static void initializeEntityFactory() {
		emFactory = Persistence.createEntityManagerFactory("moodle-info-data-persistence");
	}

	public static EntityManager getEntityManager() {
		return emFactory.createEntityManager();
	}

	public static void close() {
		emFactory.close();
	}
}