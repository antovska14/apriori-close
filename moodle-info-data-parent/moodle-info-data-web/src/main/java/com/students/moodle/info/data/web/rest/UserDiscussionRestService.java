package com.students.moodle.info.data.web.rest;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.students.moodle.info.data.services.dto.UserDTO;
import com.students.moodle.info.data.services.factory.FactoryService;
import com.students.moodle.info.data.services.interfaces.ServiceSearchResult;

@Path("discussion-users")
public final class UserDiscussionRestService {
	@Context
	private ServletContext context;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<UserDTO> getUsersActiveInDsicussions() throws IOException {
		final ServiceSearchResult service = FactoryService.getSearchMapMode("user-discussion");
		return service.getActiveUsersInDiscussions();
	}
}