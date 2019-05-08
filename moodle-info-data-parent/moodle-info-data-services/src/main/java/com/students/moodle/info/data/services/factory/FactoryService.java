package com.students.moodle.info.data.services.factory;

import com.students.moodle.info.data.services.interfaces.ServiceIdIp;

public final class FactoryService {

	private static ServiceIdIp serviceIdIp = null;

	private FactoryService() {

	}

	public static void setServiceIdIp(final ServiceIdIp service) {
		serviceIdIp = service;
	}

	public static ServiceIdIp getServiceIdIp() {
		return serviceIdIp;
	}
}