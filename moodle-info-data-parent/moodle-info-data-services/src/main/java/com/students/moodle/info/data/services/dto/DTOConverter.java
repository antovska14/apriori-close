package com.students.moodle.info.data.services.dto;

import com.students.moodle.info.data.persistence.interfaces.model.User;

public final class DTOConverter {

	private DTOConverter() {

	}

	public static IdIpDTO covertToIdIpDTO(final User user, final String ipAddress) {
		final UserDTO userDTO = new UserDTO(user.getFirstName(), user.getLastName());
		final IdIpDTO idIpDTO = new IdIpDTO(userDTO, ipAddress);
		return idIpDTO;
	}

	public static UserDTO covertToIUserDTO(final User user) {
		final UserDTO userDTO = new UserDTO(user.getFirstName(), user.getLastName());
		return userDTO;
	}
}
