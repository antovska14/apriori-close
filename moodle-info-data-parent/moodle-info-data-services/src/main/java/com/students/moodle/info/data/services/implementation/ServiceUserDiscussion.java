package com.students.moodle.info.data.services.implementation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.students.moodle.info.data.persistence.factory.FactoryPersistence;
import com.students.moodle.info.data.persistence.interfaces.repository.UserRepository;
import com.students.moodle.info.data.result.factory.FactoryResult;
import com.students.moodle.info.data.result.interfaces.result.search.SearchResult;
import com.students.moodle.info.data.services.dto.DTOConverter;
import com.students.moodle.info.data.services.dto.UserDTO;
import com.students.moodle.info.data.services.interfaces.ServiceSearchResult;

public final class ServiceUserDiscussion implements ServiceSearchResult {

	@Override
	public List<UserDTO> getActiveUsersInDiscussions() throws IOException {
		final SearchResult searchResult = FactoryResult.getSearchMapMode("user-discussion");
		final List<String> userIds = searchResult.getResult();
		final UserRepository userRepository = FactoryPersistence.getUserRepository();
		final List<UserDTO> list = new ArrayList<>();
		for (final String id : userIds) {
			final UserDTO userDTO = DTOConverter.covertToIUserDTO(userRepository.findUserWithId(Integer.valueOf(id)));
			list.add(userDTO);
		}
		return list;
	}
}
