package com.students.moodle.info.data.persistence.factory;

import com.students.moodle.info.data.persistence.interfaces.repository.UserRepository;

public class FactoryPersistence {

	private static UserRepository userRepository = null;

	private FactoryPersistence() {

	}

	public static void setUserRepository(final UserRepository repository) {
		userRepository = repository;
	}

	public static UserRepository getUserRepository() {
		return userRepository;
	}

}
