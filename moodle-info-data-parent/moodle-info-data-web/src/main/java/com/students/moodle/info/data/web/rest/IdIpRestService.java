package com.students.moodle.info.data.web.rest;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.students.moodle.info.data.services.dto.IdIpDTO;
import com.students.moodle.info.data.services.factory.FactoryService;
import com.students.moodle.info.data.services.interfaces.ServiceIdIp;

@Path("ip-user")
public final class IdIpRestService {
	@Context
	private ServletContext context;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<IdIpDTO> getIdIpCombinations() throws IOException {
		final ServiceIdIp service = FactoryService.getServiceIdIp();
		return service.getMostFrequentUserIpAddressCombination();
	}
}
