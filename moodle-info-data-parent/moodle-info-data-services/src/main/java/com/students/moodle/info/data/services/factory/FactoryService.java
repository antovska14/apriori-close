package com.students.moodle.info.data.services.factory;

import java.util.HashMap;
import java.util.Map;

import com.students.moodle.info.data.services.interfaces.ServiceIdIp;
import com.students.moodle.info.data.services.interfaces.ServiceSearchResult;

public final class FactoryService {

	private static ServiceIdIp serviceIdIp = null;
	private static Map<String, ServiceSearchResult> searchMap = new HashMap<>();

	private FactoryService() {

	}

	public static void setServiceIdIp(final ServiceIdIp service) {
		serviceIdIp = service;
	}

	public static ServiceIdIp getServiceIdIp() {
		return serviceIdIp;
	}

	public static void addToSearchMap(final String description, final ServiceSearchResult searchResult) {
		searchMap.put(description, searchResult);
	}

	public static ServiceSearchResult getSearchMapMode(final String key) {
		return searchMap.get(key);
	}

}