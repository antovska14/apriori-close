package com.students.moodle.info.data.services.dto;

import java.io.Serializable;

public final class IdIpDTO implements Serializable {

	private static final long serialVersionUID = 4787859947424887821L;
	private final UserDTO user;
	private final String ipAddress;

	public IdIpDTO(final UserDTO user, final String ipAddress) {
		this.user = user;
		this.ipAddress = ipAddress;
	}

	public UserDTO getUser() {
		return user;
	}

	public String getIpAddress() {
		return ipAddress;
	}

}
