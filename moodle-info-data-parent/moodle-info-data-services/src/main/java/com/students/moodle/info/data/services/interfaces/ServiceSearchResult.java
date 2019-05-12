package com.students.moodle.info.data.services.interfaces;

import java.io.IOException;
import java.util.List;

import com.students.moodle.info.data.services.dto.UserDTO;

public interface ServiceSearchResult {

	List<UserDTO> getActiveUsersInDiscussions() throws IOException;

}
