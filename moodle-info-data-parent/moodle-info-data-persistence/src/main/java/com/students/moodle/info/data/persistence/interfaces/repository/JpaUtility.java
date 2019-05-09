package com.students.moodle.info.data.persistence.interfaces.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public final class JpaUtility {
	private static final EntityManagerFactory emFactory;
	static {
		emFactory = Persistence.createEntityManagerFactory("moodle-info-data-persistence");
	}

	public static EntityManager getEntityManager() {
		return emFactory.createEntityManager();
	}

	public static void close() {
		emFactory.close();
	}
}