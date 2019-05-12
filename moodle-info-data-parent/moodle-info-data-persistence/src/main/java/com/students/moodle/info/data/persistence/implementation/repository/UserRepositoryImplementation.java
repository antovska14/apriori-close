package com.students.moodle.info.data.persistence.implementation.repository;

import javax.persistence.EntityManager;

import com.students.moodle.info.data.persistence.implementation.model.JpaUser;
import com.students.moodle.info.data.persistence.interfaces.model.User;
import com.students.moodle.info.data.persistence.interfaces.repository.UserRepository;

public final class UserRepositoryImplementation implements UserRepository {

	private final EntityManager entityManager;

	public UserRepositoryImplementation(final EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public User findUserWithId(final Integer id) {
		return entityManager.find(JpaUser.class, Integer.valueOf(id));
	}

}
