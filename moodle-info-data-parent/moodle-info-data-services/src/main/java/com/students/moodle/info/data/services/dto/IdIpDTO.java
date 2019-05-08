package com.students.moodle.info.data.services.dto;

import java.io.Serializable;

public final class IdIpDTO implements Serializable {

	private static final long serialVersionUID = 4787859947424887821L;
	private final String firstName;
	private final String lastName;
	private final String ipAddress;

	public IdIpDTO(final String firstName, final String lastName, final String ipAddress) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.ipAddress = ipAddress;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getIpAddress() {
		return ipAddress;
	}

}
