package com.students.moodle.info.data.persistence.interfaces.repository;

import com.students.moodle.info.data.persistence.interfaces.model.User;

public interface UserRepository {

	User findUserWithId(Integer id);

}
