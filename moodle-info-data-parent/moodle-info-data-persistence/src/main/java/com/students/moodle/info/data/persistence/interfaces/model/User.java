package com.students.moodle.info.data.persistence.interfaces.model;

public interface User {

	public Integer getId();

	public void setId(Integer id);

	public String getFirstName();

	public void setFirstName(String firstName);

	public String getLastName();

	public void setLastName(String lastName);

	public Role getRole();

	public void setRole(Role role);

}
